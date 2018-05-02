var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    navbar: null,
    currentTab: 0,
    listNavBar: null,
    listTitleTab: 0,
    listUntilData: null,
    fileName: null,
    fileType: 4
  },

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
      fileName: e.detail.value
    })
  },

  navbarTap: function (e) {
    var that = this;
   
    if (that.data.navbar[e.currentTarget.dataset.idx].list.length == 0) {
      wx.showModal({
        title: '提示',
        content: '没有数据了',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
          } else if (res.cancel) {
            console.log('用户点击取消')
          }
        }
      })
    } else {
      this.setData({
        currentTab: e.currentTarget.dataset.idx,
        listNavBar: that.data.navbar[e.currentTarget.dataset.idx].list,
        listUntilData: that.data.navbar[e.currentTarget.dataset.idx].list[0].list
      });
    }
  },
  listNavBarTab: function (e) {
    var that = this;
   
    if (that.data.listNavBar[e.currentTarget.dataset.idx].list.length == 0) {
      wx.showModal({
        title: '提示',
        content: '没有数据了',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
          } else if (res.cancel) {
            console.log('用户点击取消')
          }
        }
      })
    }
    else {
      this.setData({
        listTitleTab: e.currentTarget.dataset.idx,
        listUntilData: that.data.listNavBar[e.currentTarget.dataset.idx].list
      })
    }
  },
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
      url: app.data.api + app.data.urlDictionaryAList,
      method: 'GET',
      header:{
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
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