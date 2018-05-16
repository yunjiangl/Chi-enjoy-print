// pages/lawyersInformation/lawyersInformation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    lawyerInfo:null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var lawyerInfo = JSON.parse(options.lawyerInfo);
    console.log(lawyerInfo)
    this.setData({
      lawyerInfo: lawyerInfo
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
  
  },

  imBtn:function(){
    console.log(this.data.lawyerInfo);
    var userCode = getApp().data.userInfo.userCode;
    var attorneyCode = this.data.lawyerInfo.userCode;
    var userName = getApp().data.userInfo.userName;
    var attorneyName = this.data.lawyerInfo.nickName;
    console.log(userCode);
    console.log(attorneyCode);
    console.log(userName);
    console.log(attorneyName);
    wx.navigateTo({
      url: '../talking/talking?userCode=' + userCode + '&attorneyCode=' + attorneyCode + '&userName=' + userName + '&attorneyName=' + attorneyName
    })
  }

})