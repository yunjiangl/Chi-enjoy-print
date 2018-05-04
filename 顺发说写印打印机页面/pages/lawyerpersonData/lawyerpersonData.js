// pages/lawyerpersonData/lawyerpersonData.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    cache: '10.00M'
  },
  // 成交订单
  order: function () {
    wx.navigateTo({
      url: '../lawyerTransactionOrder/lawyerTransactionOrder',
    })
  },
  //消息
  message: function () {
    wx.navigateTo({
      url: '../lawyerMessageNotify/lawyerMessageNotify',
    })
  },
  //设备
  device: function () {
    wx.navigateTo({
      url: '../deviceOwner/deviceOwner',
    })
  },
  //如何使用
  why: function () {
    wx.navigateTo({
      url: '../howuse/howuse',
    })
  },
  //清楚缓存
  remove: function () {
    var that=this
    wx.clearStorage()
    wx.showToast({
      title: '清理中...',
      icon: 'loading',
      duration: 2000,
      complete:function () {
        setTimeout(function () {
          wx.showToast({
            title: '清理完成',
            icon:'success'
          })
          //要延时执行的代码
          that.setData({
            cache: '0.00M'
          })
        }, 2000) //延迟时间
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.getStorage({
      key: 'key',
      success: function (res) {
        console.log(res.data)
      },
      fail: function () { },
      complete: function () { }
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
    var that = this
    wx.request({
      url: app.data.api + app.data.urlUserDetails,
      data: {
        code: app.data.userCode
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data.data.nickName)
        that.setData({
          details: res.data.data,
          showView: (res.data.data.userType == "1" ? false:true )
        })
      }
    })
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