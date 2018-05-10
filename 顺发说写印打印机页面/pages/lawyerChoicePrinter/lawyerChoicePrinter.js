// pages/lawyerChoicePrinter/lawyerChoicePrinter.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },
  //加入
  toJoin: function (e) { 
    var code = e.currentTarget.dataset.key
    wx.showModal({
      title: '提示',
      content: '确定加入此设备？',
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定')
          wx.request({
            url: app.data.api + app.data.urlPrinterApply + code,
            method: 'GET',
            data: {
              //printer/apply/
            },
            header: {
              'content-type': 'application/json' // 默认值
            },
            success: function (res) {
              wx.showToast({
                title: '已提交申请',
                icon: 'success',
                duration: 2000
              })
            }
          })
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },
  //查看
  look: function (e) {
    var code = e.currentTarget.dataset.key
    wx.navigateTo({
      url: '../lawyerSeeeQuipment/lawyerSeeeQuipment?code='+code,
    })

   },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (e) {
  console.log(e)
  var that = this

  wx.request({
    url: app.data.api + app.data.urlPrinterFind + e.createId,
    method:'GET',
    data: {
      //managerName:e.manager
    },
    header: {
      'content-type': 'application/json' // 默认值
    },
    success: function (res) {
      console.log(res.data.data)
      that.setData({
        details: res.data.data,
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