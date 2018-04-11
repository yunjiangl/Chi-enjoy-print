// pages/lawyerMessageNotify/lawyerMessageNotify.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pageBackgroundColor: '#999'
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },
  chageBackgroundColor:function(){
    var bgColor = this.data.pageBackgroundColor == '#3798fb' ? '#999' : '#3798fb';
    //设置背景颜色数据
    this.setData({
      pageBackgroundColor:bgColor
    });
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