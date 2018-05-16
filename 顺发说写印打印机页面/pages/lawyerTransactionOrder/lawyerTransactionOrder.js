// pages/lawyerTransactionOrder/lawyerTransactionOrder.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nameOrCode:null,
    time:null
  },
  getData: function () {
    var that = this;
    console.log("测试1")
    console.log(app.data.userInfo.accessToken);
    wx.request({
      url: app.data.api + 'order/attorney',
      method: 'GET',
      data: {
        nameOrCode: that.data.nameOrCode,
        time: that.data.time
      },
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      success: function (res) {
        console.log(res)
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    that.getData();
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