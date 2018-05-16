// pages/deviceOwner/deviceOwner.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },
  //查看
  look: function (e) {
    var code = e.currentTarget.dataset.key
   
    wx.navigateTo({
      url: '../lawyerSeeeQuipment1/lawyerSeeeQuipment1?code=' + code ,
    })

  },
  //退出
  quit: function (e) {
    var bgColor = this.data.pageBackgroundColor == '#3798fb' ? '#999' : '#3798fb';
    var index = e.currentTarget.dataset.key
    console.log(index)
    wx.showModal({
      content: '确定退出该设备，不做该设备的线上管理员了吗？',
      success: function (res) {
        if (res.confirm) {

          wx.request({
            url: app.data.api + app.data.urlPrinterOut+index,
            data: {
             // code:index
            },
            header: {
              'X-ACCESS-TOKEN': app.data.userInfo.accessToken,
              'content-type': 'application/json' // 默认值
            },
            success: function (res) {
              console.log(res)
              
            }
          })
          console.log('用户点击确定')
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
    //设置背景颜色数据
    // this.setData({
    //   pageBackgroundColor: bgColor
    // });
  },
  //申请加入
  toJoin:function(){
    wx.navigateTo({
      url: '../lawyerChoiceOwner/lawyerChoiceOwner',
    })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  var that=this

  wx.request({
    url: app.data.api + app.data.urlPrinterMy,
    data: {
      page:0,
      pageSize:100
    },
    header: {
      'X-ACCESS-TOKEN': app.data.userInfo.accessToken,
      'content-type': 'application/json' // 默认值
    },
    success: function (res) {
      console.log(res.data)
      that.setData({
        details: res.data.data.dataPacket,
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