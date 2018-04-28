// pages/cohiceCustomer/cohiceCustomer.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fileInfo: null,
    userCode: 'wechat00000000000', // 所要发送文件的客户，这个后面应该改为动态的
    fileType: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    // 把接收到的字符串转换成json对象
    var dictionaryInfo = JSON.parse(options.fileInfo);
    this.setData({
      fileInfo: dictionaryInfo,
      fileType: options.fileType
    })
  },
  choice: function () {
    var that = this;
    // 把要传递的json对象转换成字符串
    var fileInfo = JSON.stringify(that.data.fileInfo);
    wx: wx.navigateTo({
      url: '../lawyerSettingCosts/lawyerSettingCosts?fileInfo=' + fileInfo + '&userCode=' + that.data.userCode + "&fileType=" + that.data.fileType,
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
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