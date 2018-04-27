// pages/lawyerFourFileList/lawyerFourFileList.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
    dictionaryList: null,
    filetype: null
  },
  trun: function () {
  trun: function (e) {
    var that = this
    wx.navigateTo({
      url: '../lawyerFileList/lawyerFileList',
      url: '../lawyerFileList/lawyerFileList?code=' + e.currentTarget.dataset.code + "&fileType=" + that.data.fileType,
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  






    // 把接收到的字符串转换成json对象
    var dictionaryInfo = JSON.parse(options.dictionaryInfo);

    wx.setNavigationBarTitle({
      title: dictionaryInfo.name
    })
    this.setData({
      dictionaryList: dictionaryInfo.list,
      fileType: options.fileType
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