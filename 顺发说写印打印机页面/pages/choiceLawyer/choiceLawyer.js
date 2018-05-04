// pages/choiceLawyer/choiceLawyer.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    printInfo: null,
    page: 0,
    pageSize: 10,
    lawyerList: [],
  },

  /**
  * 获取数据
  */
  getData: function () {
    var that = this;
    that.setData({
      page: that.data.page + 1
    })
    wx.request({
      url: app.data.api + app.data.urlPrinterAttorney,
      method: 'GET',
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      data: {
        page: that.data.page,
        pageSize: that.data.pageSize,
        code: that.data.printInfo.code
      },
      success: function (res) {
        var list = that.data.lawyerList;
        console.log(res)
        for (var i = 0; i < res.data.data.content.length; i++) {
          list.push(res.data.data.content[i])
        }
        that.setData({
          lawyerList: list
        })
        console.log(that.data.lawyerList)
      }

    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 把接收到的字符串转换成json对象
    var printInfo = JSON.parse(options.printInfo);
    console.log(printInfo)
    this.setData({
      printInfo: printInfo
    })
    this.getData()
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
  lawyerInfo: function (e) {
    var that = this
    // 把要传递的json对象转换成字符串
    var lawyerInfo = JSON.stringify(that.data.lawyerList[e.currentTarget.dataset.idx]);
    wx.navigateTo({
      url: '../lawyersInformation/lawyersInformation?lawyerInfo=' + lawyerInfo
    })
  }
})