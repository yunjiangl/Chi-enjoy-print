// 引入SDK核心类
var QQMapWX = require('../../lib/qqmap-wx-jssdk.js');
var app = getApp()
// pages/choice/choice.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    address:'',//地址  
    printList : null // 附近打印机列表
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
              method : 'GET',
              data:{
                longitude : res.longitude,
                latitude : res.latitude
              },
              success: function(resdata){
                that.setData({
                  address: address,
                  printList: resdata.data.data
                })
              }
            })
            
          },
          fail:function(r){
            console.log(r)
          }
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  choiceLawyer:function(e){
    var that = this
    // 把要传递的json对象转换成字符串
    var printInfo = JSON.stringify(that.data.printList[e.currentTarget.dataset.idx]);
    wx.navigateTo({
      url: '../choiceLawyer/choiceLawyer?printInfo='+ printInfo
    })
  }
})