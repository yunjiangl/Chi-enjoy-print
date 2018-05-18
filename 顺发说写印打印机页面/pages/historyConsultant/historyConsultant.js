var template = require('../../template/template.js');
var app = getApp()
// pages/historyConsultant/historyConsultant.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // wx.getLocation({
    //   type: 'gcj02', //返回可以用于wx.openLocation的经纬度
    //   success: function (res) {
    //     var latitude = res.latitude
    //     var longitude = res.longitude
    //     wx.openLocation({
    //       latitude: latitude,
    //       longitude: longitude,
    //       scale: 28
    //     })
    //   }
    // })
    template.tabbar("tabBar", 2, this, app.data.userInfo.userType, app.data.userInfo.isLock);//0表示第一个tabbar
    this.getData();
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

  getData:function(){
    var that = this;
    //请求接口获取数据展示
    wx.request({
      url: getApp().data.api + "im/list",
      method: "GET",
      header: {
        'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken
      },
      data: {
        userType: getApp().data.userInfo.userType,
        userCode: getApp().data.userInfo.userCode
      },
      success: function (res) {
        console.log(res);
        if(res.data.code==200){
          that.setData({
            list:res.data.data.content,
            type:getApp().data.userInfo.userType
          });
        }
      }
    })

  },
  btnView: function (e) {
    var viewId = e.target.id;
    var viewDataSet = e.currentTarget.dataset;
    var userCode = viewDataSet.user;
    var attorneyCode = viewDataSet.attorney;
    var userName = viewDataSet.username;
    var attorneyName = viewDataSet.attorneyname;
    console.log(userCode); 
    console.log(attorneyCode); 
    console.log(userName); 
    console.log(attorneyName); 
    wx.navigateTo({
      url: '../talking/talking?userCode=' + userCode + '&attorneyCode=' + attorneyCode + '&userName=' + userName + '&attorneyName=' + attorneyName
    })
  }
})