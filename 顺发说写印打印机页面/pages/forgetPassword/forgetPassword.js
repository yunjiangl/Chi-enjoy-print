// pages/forgetPassword/forgetPassword.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    yanzhengma: ''
  },
  yanzhengmaInput: function (e) {
    console.log(e)
    this.setData({
      yanzhengma: e.detail.value
    })
    wx.request({
      url: 'http://123.206.42.162:10001/forgetpassword/verification',
      header: {
        'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken,
      },
      date: {
        code: yanzhengma
      },
      method: 'POST',
      success: function (res) {
        console.log(res)
      }
    })
  },
  changeName: function () {
    wx.request({
      url: 'http://123.206.42.162:10001/forgetpassword/code',
      header: {
        'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken,
      },
      date: {},
      method: 'POST',
      success: function (res) {
        console.log(res)
      }
    })
  },

  nextbtn: function () {
    wx.navigateTo({
      url: '../resetPassword/resetPassword',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    });
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