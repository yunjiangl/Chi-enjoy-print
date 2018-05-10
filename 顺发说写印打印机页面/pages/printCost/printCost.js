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
    app.payAction(that.data.orderCode, app.data.userInfo.openId)
    wx.navigateTo({
      url: '../printOrders/printOrders',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var orderAmount = this.keepTwoDecimalFull(options.orderAmount)
    this.setData({
      orderAmount: orderAmount,
      orderCode: options.orderCode
    })
  },
  //四舍五入保留2位小数（不够位数，则用0替补）
  keepTwoDecimalFull: function (num) {
    var result = parseFloat(num);
    if (isNaN(result)) {
      return false;
    }
    result = Math.round(num) / 100;
    var s_x = result.toString();
    var pos_decimal = s_x.indexOf('.');
    if (pos_decimal < 0) {
      pos_decimal = s_x.length;
      s_x += '.';
    }
    while (s_x.length <= pos_decimal + 2) {
      s_x += '0';
    }
    return s_x;
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