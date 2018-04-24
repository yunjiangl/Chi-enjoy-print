// pages/lawyerFileList/lawyerFileList.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    query: null,
    code: null,
    page: 0,
    pageSize: 10,
    fileInfoList: []
  },
  // downloadDocument:function(){
  //   wx.navigateBack({
  //     url:'/pages/setting/document/download/download'
  //   });
  // },

  /**
   * 获取数据
   */
  getData: function () {
    var that = this;
    that.setData({
      page: that.data.page + 1
    })
    wx.request({
      url: app.data.api + 'file/m/a/page',
      method: 'GET',
      data: {
        query: that.data.query,
        categoryCode: that.data.code,
        page: that.data.page,
        pageSize: that.data.pageSize
      },
      success: function (res) {
        var list = that.data.fileInfoList;
        for (var i = 0; i < res.data.data.content.length; i++) {
          list.push(res.data.data.content[i])
        }
        that.setData({
          fileInfoList: list
        })
      }

    })
  },
  /**
   * 获取摘要信息
   */
  abstractsInfo: function (e) {

    wx.showModal({
      title: '摘要',
      content: e.currentTarget.dataset.abstracts,
      showCancel: false,
      success: function (res) {
        if (res.confirm) {

        } else if (res.cancel) {

        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    var that = this;
    var code = '';
    var query = '';

    if (!(Object.prototype.toString.call(options.query) === '[object Undefined]')) {
      query = options.query
    }
    if (!(Object.prototype.toString.call(options.code) === '[object Undefined]')) {
      code = options.code
    }
   
    that.setData({
      code: code,
      query: query
    })
   
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
    var that = this;
    that.getData();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})