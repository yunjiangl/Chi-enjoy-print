// pages/printCost/printCost.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    orderAmount: null
  },
  clearing: function () {
    var that = this
    wx.request({
      url: app.data.api + app.data.urlUserDetails,
      method: 'GET',
      header:{
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      data:{
        code: app.data.userCode
      },
      success:function(res){
        console.log(res)
        app.loginCheck(res)
        app.payAction(that.data.orderCode, res.data.data.openId)
      }
    })
    
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      orderAmount: options.orderAmount,
      orderCode: options.orderCode
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

  }
})