// pages/personalCenter/personalCenter.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },
  ImprovingPersonalData:function(){
      wx.navigateTo({
        url: '../improvingPersonalData/improvingPersonalData?userCode=' + this.data.details.userCode,
      })
      console.log('usercode:'+this.data.details.userCode);
  },
logout:function(){
  
  wx.request({
    url: app.data.api + app.data.urlLogout,
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
    wx.request({
      url: app.data.api + app.data.urlUserDetails,
      data: {
        code: app.data.userCode
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data.data.nickName)
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