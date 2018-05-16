var template = require('../../template/template.js');
// pages/personalCenter/personalCenter.js

var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },
  ImprovingPersonalData:function(){
      wx.navigateTo({
        url: '../improvingPersonalData/improvingPersonalData',
      })
  },
logout:function(){
  
  wx.request({
    url: app.data.api + app.data.urlLogout,
    header: {
      "X-ACCESS-TOKEN": getApp().data.userInfo.accessToken
    },
    success: function (res) {
      console.log('退出');
      wx.showToast({
        title: '成功退出',
        icon: 'success',
        duration: 2000
      })
    }
  })

},

  how:function(){
    wx.navigateTo({
      url: '../howuse/howuse',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    template.tabbar("tabBar", 4, this, app.data.userInfo.userType, app.data.userInfo.isLock)//0表示第一个tabbar
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
    var that = this
    console.log(app.data.userInfo)
    wx.request({
      url: app.data.api + app.data.urlUserDetails,
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      data: {
        code: app.data.userCode
      },
      success: function (res) {
        console.log(res.data.data)
        that.setData({
          details: res.data.data
        })
      }
    })

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
  
  }
})