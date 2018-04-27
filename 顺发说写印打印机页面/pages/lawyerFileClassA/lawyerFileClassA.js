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
  
    navbar: null,
    currentTab: 0,
    listNavBar: null,
    listTitleTab: 0,
    listUntilData: null,
    fileName: null,
    fileType: 4
  },
  navbarTap:function(e){



  searchFile: function () {
    var that = this;

    wx.navigateTo({
      url: '../lawyerFileList/lawyerFileList?query=' + that.data.fileName + "&fileType=" + that.data.fileType,
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  fileNameInput: function (e) {
    this.setData({
      currentTab:e.currentTarget.dataset.idx
      fileName: e.detail.value
    })
  },

  navbarTap: function (e) {
    var that = this;
    this.setData({
      currentTab: e.currentTarget.dataset.idx,
      listNavBar: that.data.navbar[e.currentTarget.dataset.idx].list,
      listUntilData: that.data.navbar[e.currentTarget.dataset.idx].list[0].list
    });
  },
  listNavBarTab:function(e){
  listNavBarTab: function (e) {
    var that = this;

    this.setData({
      listTitleTab: e.currentTarget.dataset.idx
      listTitleTab: e.currentTarget.dataset.idx,
      listUntilData: that.data.listNavBar[e.currentTarget.dataset.idx].list
    })
  },
  trun:function(){
    wx:wx.navigateTo({
      url: '../lawyerFourFileList/lawyerFourFileList',
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
  trun: function (e) {
    var that = this;
    // 把要传递的json对象转换成字符串
    var dictionaryInfo = JSON.stringify(that.data.listUntilData[e.currentTarget.dataset.idx]);
    wx: wx.navigateTo({
      url: '../lawyerFourFileList/lawyerFourFileList?dictionaryInfo=' + dictionaryInfo + "&fileType=" + that.data.fileType,
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
    var that = this;

    wx.request({
      url: app.data.api + 'dictionary/a/list',
      method: 'GET',
      success: function (data) {

        that.setData({
          navbar: data.data.data[0].list,
          listNavBar: data.data.data[0].list[0].list,
          listUntilData: data.data.data[0].list[0].list[0].list
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