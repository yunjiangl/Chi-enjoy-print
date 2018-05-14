// pages/lawyerChoiceOwner/lawyerChoiceOwner.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },
  managerOn:function(e){
    var createId = e.currentTarget.dataset.key
    console.log(createId);
    wx.navigateTo({
      url: '../lawyerChoicePrinter/lawyerChoicePrinter?createId=' + createId
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this

    wx.request({
      url: app.data.api + app.data.urlPrinterAll,
      data: {
      },
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken,
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data.data)
        that.setData({
          details: res.data.data,
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
  
  }
})