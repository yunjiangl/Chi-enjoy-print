//获取应用实例
// var app = getApp()
// var util = require('../../utils/util.js')
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
    checked: '',
    selectPerson: true,
    firstPerson: '请选择职业年限',
    selectArea: false,
    items2: [
      { checked: 'true' },
    ],
    show: show,
    provinces: provinces,
    citys: citys,
    countys: countys,
    value: [0, 0, 0],
    sex: '',
    src1: '../images/photo.png',
    src2: '../images/photo.png',
    src3: '../images/photo.png',
    //执业证号
    dates: [
      { "data_name": "1", "name": "金融证券", "state": 0 },
      { "data_name": "2", "name": "征地拆迁", "state": 0 },
      { "data_name": "3", "name": "行政法律", "state": 0 },
      { "data_name": "4", "name": "知识产权", "state": 0 },
      { "data_name": "5", "name": "劳动纠纷", "state": 0 },
      { "data_name": "6", "name": "海事海商", "state": 0 },
      { "data_name": "7", "name": "商事仲裁", "state": 0 },
      { "data_name": "8", "name": "合同纠纷", "state": 0 },
      { "data_name": "8", "name": "合同纠纷", "state": 0 },
      { "data_name": "8", "name": "合同纠纷", "state": 0 },
    ]
  },
  //选择执业后加样式
  select_date: function (e) {
    var index = e.currentTarget.dataset.key;
    if (this.data.dates[index].state == 1) {
      this.data.dates[index].state = 0;
    } else if (this.data.dates[index].state == 0) {
      this.data.dates[index].state = 1;
    }
    var name = this.data.dates[index].name
    var ds = this.data.dates

    console.log(name)
    this.setData({
      dates: ds,
    });
  },
  formSubmit: function (e) {
    // 姓名
    var code = this.data.details.userCode;
    var name = e.detail.value.name;
    // 年龄
    var age = e.detail.value.age;
    // 手机
    var mobile = e.detail.value.mobile;
    // 微信
    var weChatId = e.detail.value.weChatId;
    // 性别
    var sex = this.data.sex;
    //所在地
    var portrait = this.data.details.portrait;
    var province = this.data.province;
    var city = this.data.city;
    var area = this.data.county;
    var address = province + city + area;
    //执业机构
    var workOrg = e.detail.value.workOrg;
    //执业证号
    var workNum = e.detail.value.workNum;
    //执业类型
    var domains = '';
    var dates = this.data.dates;
    for (var i = 0; i < dates.length ; i++){
      if (dates[i].state == 1){
        domains += dates[i].name+',';
        }
    }

    //职业年限
    var workYear = this.data.firstPerson;
    console.log(this.data.firstPerson);
    //审核图片
    var checkImg = this.data.src3;
    //资格证图片
    var attorneyCardImg = this.data.src2;
    //身份证
    var identityCardImg = this.data.src1;

    console.log('姓名:' + name + '年龄:' + age + '手机:' + age + '微信:' + weChatId + '性别:' + sex + '所在地:' + address + '执业机构:' + workOrg + '执业证号:' + workNum + '执业类型:' + domains + '职业年限:' + workYear + '审核图片:' + checkImg + '资格证图片:' + attorneyCardImg + '身份证:' + identityCardImg);

    wx.request({
      url: 'http://127.0.0.1:10001/user/attorney/update',
      data: {
        userCode: code,
        wechatId: weChatId,
        mobile: mobile,
        portrait: portrait,
        age: age,
        gen: this.data.sex,
        province: province,
        city: city,
        area: area,
        address: address,
        checkImg: checkImg,
        attorneyCardImg: attorneyCardImg,
        identityCardImg: identityCardImg,
        workNum: workNum,
        workOrg: workOrg,
        workYear: workYear,
        domains: domains
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success: function (res) {
        console.log('修改成功');
        wx.showToast({
          title: '修改成功',
          icon: 'success',
          duration: 2000
        })
      }
    })
  },
  //性别
  radioChange: function (e) {
    console.log(e.detail.value);
    this.setData({
      sex: e.detail.value
    })
  },
  //上传IDCard
  uploadOne: function () {
    var that = this;
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths;
        console.log(tempFilePaths[0]);
        that.setData({
          src1: tempFilePaths[0]
        })
        upload(that, tempFilePaths,1);
      }
    })

  },


  //上传律师证书
  uploadTwo: function () {
    var that = this;
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths;
        that.setData({
          src2: tempFilePaths[0]
        })
        upload(that, tempFilePaths,2);
      }
    })
  },


  //上传年审
  uploadThree: function () {
    var that = this;
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths;
        that.setData({
          src3: tempFilePaths[0]
        })
        upload(that, tempFilePaths,3);
      }
    })
  },


  //点击选择类型
  clickPerson: function () {
    var selectPerson = this.data.selectPerson;
    if (selectPerson == true) {
      this.setData({
        selectArea: true,
        selectPerson: false,
      })
    } else {
      this.setData({
        selectArea: false,
        selectPerson: true,
      })
    }

  },
  //点击切换
  mySelect: function (e) {
    this.setData({
      firstPerson: e.target.dataset.me,
      selectPerson: true,
      selectArea: false,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onShow: function (options) {
    var that = this;
    
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

  onLoad: function (options) {
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

    wx.request({
      url: 'http://127.0.0.1:10001/user/details',
      data: {
        code: 'wechat00000000007'
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {

        var item;
        if (res.data.data.gen == '男') {
          item = [
            { name: '男', value: '男', checked: 'true' },
            { name: '女', value: '女' },
          ]
        } else {
          item = [
            { name: '男', value: '男' },
            { name: '女', value: '女', checked: 'true' },
          ]
        }

        that.setData({
          details: res.data.data,
          items: item,
          sex: res.data.data.gen

        })

      }
    })


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

  },
  //隐藏弹窗浮层
  hiddenFloatView(e) {
    console.log(e);
    moveY = 200;
    show = true;
    t = 0;
    animationEvents(this, moveY, show);

  },
  //页面滑至底部事件
  onReachBottom: function () {
    // Do something when page reach bottom.
  },
  tiaozhuan() {
    wx.navigateTo({
      url: '../../pages/modelTest/modelTest',
    })
  }
})
//上传文件
function upload(page, path,num) {
  wx.showToast({
    icon: "loading",
    title: "正在上传"
  }),
    wx.uploadFile({
    url: "http://127.0.0.1:10001/upload/file/userimg",
      filePath: path[0],
      name: 'multipartFile',
      header: { "content-type": "multipart/form-data" },
      formData: {
        //和服务器约定的token, 一般也可以放在header中
        //'session_token': wx.getStorageSync('session_token')
      },
      success: function (res) {
        console.log(res.data);
        if (res.statusCode != 200) {
          wx.showModal({
            title: '提示',
            content: '上传失败',
            showCancel: false
          })
          return;
        }
        var data = res.data
        

        switch (num) {
          case 1:
            page.setData({  //上传成功修改显示头像
              src1: data
            })
            break;
          case 2:
            page.setData({  //上传成功修改显示头像
              src2: data
            })
            break;
          case 3:
            page.setData({  //上传成功修改显示头像
              src3: data
            })
            break;
        }
      },
      fail: function (e) {
        console.log(e);
        wx.showModal({
          title: '提示',
          content: '上传失败',
          showCancel: false
        })
      },
      complete: function () {
        wx.hideToast();  //隐藏Toast
      }
    })
}





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
  that.setData({
    province: "请选择所在地",
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