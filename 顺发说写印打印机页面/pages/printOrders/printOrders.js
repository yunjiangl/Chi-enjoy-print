var app = getApp()
var template = require('../../template/template.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //tab切换
    navbar: ['待付款', '待打印', '已完成'],
    currentTab: 3,
    orderList: [],
    msg: '',
    orderStart: '',//订单状态
    page: 1, // 当前页
    pageSize: 10 // 页面数据大小
  },
  navbarTap: function (e) {

    if (e.currentTarget.dataset.idx == 0) {
      this.setData({
        orderStart: 1
      })
    } else if (e.currentTarget.dataset.idx == 1) {
      this.setData({
        orderStart: 5
      })
    } else if (e.currentTarget.dataset.idx == 2) {
      this.setData({
        orderStart: 7
      })
    }
    this.setData({
      page: 1,
      currentTab: e.currentTarget.dataset.idx,
      orderList: [],
    })

    this.getData()
  },
  goCost: function (e) {
    var that = this
    var orderInfo = that.data.orderList[e.currentTarget.dataset.idx]
    if (orderInfo.status == 1 || orderInfo.status == 4) {
      wx.navigateTo({
        url: '../printCost/printCost?orderAmount=' + orderInfo.orderAmount + "&orderCode=" + orderInfo.orderCode,
      })
    } else if (orderInfo.status == 5) {
      wx.showModal({
        title: '',
        content: '正在将文件发送至打印机',
        showCancel: false
      })
      wx.request({
        url: app.data.api + app.data.urlOrderPrinter + orderInfo.orderCode,
        method: "GET",
        header: {
          'X-ACCESS-TOKEN': app.data.userInfo.accessToken
        },
        success:function(res){
          console.log(res)
          wx.redirectTo({
            url: '../printOrders/printOrders',
          })
        }
      })
    }
  },
  setprint: function () {
    wx.navigateTo({
      url: '../setPrint/setPrint',
    })
  },

  goMap:function(e){
    var that = this
    wx.navigateTo({
        url: '../map/map?printCode=' + that.data.orderList[e.currentTarget.dataset.idx].printerCode,
    })
  },

  getData: function () {
    var that = this
    wx.request({
      url: app.data.api + app.data.urlOrderList,
      method: "GET",
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      data: {
        userCode: app.data.userCode, // 用户唯一标识
        status: that.data.orderStart, // 订单的状态
        page: that.data.page, // 第几页
        pageSize: that.data.pageSize, // 每页显示的数据
      },
      success: function (res) {
        console.log(res)
        app.loginCheck(res)
        var list = that.data.orderList;
        if (res.data.data.content.length == 0 && that.data.orderList == []) {
          that.setData({
            msg: '没有信息哦哦'
          })
        } else {
          for (var i = 0; i < res.data.data.content.length; i++) {
            list.push(res.data.data.content[i])
          }
          that.setData({
            orderList: list,
            msg: ''
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 加载导航栏
    template.tabbar("tabBar", 3, this, app.data.userInfo.userType, app.data.userInfo.isLock)//0表示第一个tabbar
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
    var that = this
    this.setData({
      page: that.data.page + 1
    })
    this.getData();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    return {
      // title:'title',//分享标题
      // desc:'desc',//分享描述
      // path:'path'//分享路径
    }
  }
})