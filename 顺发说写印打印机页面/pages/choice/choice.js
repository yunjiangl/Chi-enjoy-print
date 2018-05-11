// 引入SDK核心类
var QQMapWX = require('../../lib/qqmap-wx-jssdk.js');
var app = getApp()
// pages/choice/choice.js
var area = require('../../utils/area.js')

var areaInfo = [];//所有省市区县数据

var provinces = [];//省

var citys = [];//城市

var countys = [];//区县

var index = [0, 0, 0];

var cellId;

var t = 0;
var show = false;
var moveY = 200;

Page({

  /**
   * 页面的初始数据
   */
  data: {
    address: '',//地址  
    printList: null, // 附近打印机列表
    show: show,
    provinces: null,
    citys: null,
    countys: null,
    value: [0, 0, 0],
    hideAddress:true,
    name:null
  },
  //获取经纬度
  getLocation: function (e) {
    console.log(e)
    var that = this
    wx.getLocation({
      success: function (res) {
        console.log(res)
        that.setData({
          hasLocation: true,
          location: {
            longitude: res.longitude,
            latitude: res.latitude
          }
        })
      }
    })
  },
  //根据经纬度在地图上显示
  openLocation: function (e) {
    var value = e.detail.value
    wx.openLocation({
      longitude: Number(value.longitude),
      latitude: Number(value.latitude)
    })
  },

  //滑动事件
  bindChange: function (e) {
    var val = e.detail.value
    // console.log(e)
    //判断滑动的是第几个column
    //若省份column做了滑动则定位到地级市和区县第一位
    if (index[0] != val[0]) {
      val[1] = 0;
      val[2] = 0;
      getCityArr(val[0], this);//获取地级市数据
      getCountyInfo(val[0], val[1], this);//获取区县数据
    } else {    //若省份column未做滑动，地级市做了滑动则定位区县第一位
      if (index[1] != val[1]) {
        val[2] = 0;
        getCountyInfo(val[0], val[1], this);//获取区县数据
      }
    }
    index = val;

    console.log(index + " => " + val);

    //更新数据
    this.setData({
      value: [val[0], val[1], val[2]],
      province: provinces[val[0]].name,
      city: citys[val[1]].name,
      county: countys[val[2]].name
    })

  },
  xuanze: function(){
    var that=this;
    console.log("测试");
    var province = that.data.province;
    var city = that.data.city;
    var area=that.data.county;
    var name=that.data.name;
    wx.request({
      url: app.data.api + app.data.urlPrinterNearby,
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      method: 'GET',
      data: {
        province: province,
        city: city,
        area: area,
        name:name
      },
      success: function (resdata) {
          console.log(resdata);
        that.setData({
          printList: resdata.data.data
        })
      }
    })


  },
  sousuo: function(e){
    var that=this;
    //console.log(e.detail.value)
    that.setData({
      name: e.detail.value
    })
    //console.log("name"+that.data.name);
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    // 实例化腾讯地图API核心类
    var qqmapsdk = new QQMapWX({
      key: 'A4OBZ-E3UWJ-EY7FL-K2RHY-JAQM6-5JFRM' // 必填
    });
    //1、获取当前位置坐标
    wx.getLocation({
      type: 'wgs84',
      success: function (res) {
        console.log(res)
        //2、根据坐标获取当前位置名称，显示在顶部:腾讯地图逆地址解析
        qqmapsdk.reverseGeocoder({
          location: {
            latitude: res.latitude,
            longitude: res.longitude
          },
          success: function (addressRes) {
            console.log(addressRes)
            var address = addressRes.result.formatted_addresses.recommend;
            wx.request({
              url: app.data.api + app.data.urlPrinterNearby,
              header: {
                'X-ACCESS-TOKEN': app.data.userInfo.accessToken
              },
              method: 'GET',
              data: {
                longitude: res.longitude,
                latitude: res.latitude,
                name: that.data.name
              },
              success: function (resdata) {
               // console.log(res.latitude),
               //  console.log(res.longitude),
                console.log(resdata);
                that.setData({
                  address: address,
                  printList: resdata.data.data
                })
              }
            })

          },
          fail: function (r) {
            console.log(r)
          }
        })
      }
    })

    cellId = options.cellId;
    var that = this;
    var date = new Date()
    console.log(date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日");

    //获取省市区县数据
    area.getAreaInfo(function (arr) {
      areaInfo = arr;
      //获取省份数据
      getProvinceData(that);
    });

    // that.setData({
    //   details: res.data.data,
    //   items: item,
    //   sex: res.data.data.gen,
    //   province: res.data.data.province,
    //   city: res.data.data.city,
    //   county: res.data.data.area,
    //   firstPerson: res.data.data.attorney.workYear

    // })

  },

  // ------------------- 分割线 --------------------
  onReady: function () {
    this.animation = wx.createAnimation({
      transformOrigin: "50% 50%",
      duration: 0,
      timingFunction: "ease",
      delay: 0
    }
    )
    this.animation.translateY(200 + 'vh').step();
    this.setData({
      animation: this.animation.export(),
      show: show
    })
  },
  //移动按钮点击事件
  translate: function (e) {
    if (t == 0) {
      moveY = 0;
      show = false;
      t = 1;
    } else {
      moveY = 200;
      show = true;
      t = 0;
    }
    // this.animation.translate(arr[0], arr[1]).step();
    animationEvents(this, moveY, show);
    this.setData({
      // config: {
      hideAddress: false
      // }
    })

  },
  //隐藏弹窗浮层
  hiddenFloatView(e) {
    var that=this;
    console.log(e);
    moveY = 200;
    show = true;
    t = 0;
    animationEvents(this, moveY, show);
    that.xuanze();
  },

  choiceLawyer: function (e) {
    var that = this
    // 把要传递的json对象转换成字符串
    var printInfo = JSON.stringify(that.data.printList[e.currentTarget.dataset.idx]);
    wx.navigateTo({
      url: '../choiceLawyer/choiceLawyer?printInfo=' + printInfo
    })
  }
})


//动画事件
function animationEvents(that, moveY, show) {
  console.log("moveY:" + moveY + "\nshow:" + show);
  that.animation = wx.createAnimation({
    transformOrigin: "50% 50%",
    duration: 400,
    timingFunction: "ease",
    delay: 0
  }
  )
  that.animation.translateY(moveY + 'vh').step()

  that.setData({
    animation: that.animation.export(),
    show: show
  })

}

// ---------------- 分割线 ---------------- 

//获取省份数据
function getProvinceData(that) {
 // var thaa=this;
 // console.log(thaa.Page.data.address);
  var s;
  provinces = [];
  var num = 0;
  for (var i = 0; i < areaInfo.length; i++) {
    s = areaInfo[i];
    if (s.di == "00" && s.xian == "00") {
      provinces[num] = s;
      num++;
    }
  }
  that.setData({
    provinces: provinces
  })

  //初始化调一次
  getCityArr(0, that);
  getCountyInfo(0, 0, that);
  console.log(that.data.address);
  that.setData({
    // province: "请选择地址",
    // city: "市辖区",
    // county: "东城区",
  })

}

// 获取地级市数据
function getCityArr(count, that) {
  var c;
  citys = [];
  var num = 0;
  for (var i = 0; i < areaInfo.length; i++) {
    c = areaInfo[i];
    if (c.xian == "00" && c.sheng == provinces[count].sheng && c.di != "00") {
      citys[num] = c;
      num++;
    }
  }
  if (citys.length == 0) {
    citys[0] = { name: '' };
  }

  that.setData({
    city: "",
    citys: citys,
    value: [count, 0, 0]
  })
}
// 获取区县数据
function getCountyInfo(column0, column1, that) {
  var c;
  countys = [];
  var num = 0;
  for (var i = 0; i < areaInfo.length; i++) {
    c = areaInfo[i];
    if (c.xian != "00" && c.sheng == provinces[column0].sheng && c.di == citys[column1].di) {
      countys[num] = c;
      num++;
    }
  }
  if (countys.length == 0) {
    countys[0] = { name: '' };
  }
  that.setData({
    county: "",
    countys: countys,
    value: [column0, column1, 0]
  })
}