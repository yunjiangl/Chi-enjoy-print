// pages/forgetPassword/forgetPassword.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      PWD:''
  },
  PWDInput: function (e) {
    console.log(e)
    this.setData({
      PWD: e.detail.value
    })
    },

  loginSure:function(){
    wx.request({
      url: 'http://123.206.42.162:10001/forgetpassword/save',
      header: {
        'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken,
      },
      date: {
        pwd: PWD
      },
      method: 'POST',
      success: function (res) {
        console.log(res)
      }
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