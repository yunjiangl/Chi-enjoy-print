var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    navbar:['民事案由','刑事罪名','行政案由'],
    currentTab:0,
    listNavBar:['民事','商事','知识产权','企业破产清算','破坏社会主义市场经济罪','侵犯公民人身权利、民主权利罪'],
    listTitleTab:0,
  
  },
  navbarTap:function(e){
    this.setData({
      currentTab:e.currentTarget.dataset.idx
    });
  },
  listNavBarTab:function(e){
    this.setData({
      listTitleTab: e.currentTarget.dataset.idx
    })
  },
  trun:function(){
    wx:wx.navigateTo({
      url: '../lawyerFourFileList/lawyerFourFileList',
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
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