// pages/setPrint/setPrint.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    orderAmout: null,
    colcorAmout: 2,
    userageAmout: 2,
    typeAmout: 1,
    items1: [
      { name: 'putong', value: '单面', checked: 'true' },
    ],
    items2: [
      { checked: 'true' },
    ],
    items3: [
      { name: 'putong', value: '彩色', checked: 'true' },
    ],
    filePaper: 1,
    printerNum: 1, // 打印数量，默认为1
    order: {
      customerCode: null,// 客户code
      attorneyCode: null, // 律师code
      printerCode: null, // 打印机code
      fileCodes: null, // 文件code(多个文件中间用英文逗号分隔)
      paperType: 9, // 纸张类型
      printerNum: 1, // 打印数量
      paperColcor: 10, // 纸张颜色
      paperUsage: 12, // 纸张使用
      serviceAmout: null, // 服务费
      fileType: null,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
    },
    printerAddress: '请选择打印机',
  },

  finish: function () {
    var that = this
    if (that.data.order.printerCode == null) {
      wx.showModal({
        title: '提示',
        content: '请选择打印机',
        success: function (res) {
          if (res.confirm) {
            that.getPrinterCode()
          } else if (res.cancel) {
            console.log('用户点击取消')
          }
        }
      })
    } else {

      wx.request({
        url: app.data.api + app.data.urlOrderSave,
        method: 'POST',

        header: {
          "Content-Type":
          "application/x-www-form-urlencoded",
          'X-ACCESS-TOKEN': app.data.userInfo.accessToken
        },
        data: {
          customerCode: that.data.order.customerCode,// 客户code
          attorneyCode: that.data.order.attorneyCode, // 律师code
          printerCode: that.data.order.printerCode, // 打印机code
          fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
          paperType: that.data.order.paperType, // 纸张类型
          printerNum: that.data.printerNum, // 打印数量
          paperColcor: that.data.order.paperColcor, // 纸张颜色
          paperUsage: that.data.order.paperUsage, // 纸张使用
          serviceAmout: that.data.order.serviceAmout, // 服务费
          fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
        },
        success: function (res) {
          app.loginCheck(res)
          console.log('保存订单结果' + res.data.data)
          app.payAction(res.data.data, app.data.userInfo.openId)
          wx.redirectTo({
            url: '../printOrders/printOrders'
          })
        }
      })
    }
  },

  minus: function () {
    var that = this
    if (that.data.printerNum > 1) {
      that.setData({
        printerNum: that.data.printerNum - 1,
        order: {
          customerCode: that.data.order.customerCode,// 客户code
          attorneyCode: that.data.order.attorneyCode, // 律师code
          printerCode: that.data.order.printerCode, // 打印机code
          fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
          paperType: that.data.order.paperType, // 纸张类型
          printerNum: ((that.data.printerNum - 1) * that.data.filePaper), // 打印数量
          paperColcor: that.data.order.paperColcor, // 纸张颜色
          paperUsage: that.data.order.paperUsage, // 纸张使用
          serviceAmout: that.data.order.serviceAmout, // 服务费
          fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
        },
        orderAmout: (that.data.order.printerNum - 1) * that.data.colcorAmout * that.data.userageAmout * that.data.typeAmout,
      })
    }
  },

  add: function () {
    var that = this
    that.setData({
      printerNum: that.data.printerNum + 1,
      order: {
        customerCode: that.data.order.customerCode,// 客户code
        attorneyCode: that.data.order.attorneyCode, // 律师code
        printerCode: that.data.order.printerCode, // 打印机code
        fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
        paperType: that.data.order.paperType, // 纸张类型
        printerNum: ((that.data.printerNum + 1) * that.data.filePaper), // 打印数量
        paperColcor: that.data.order.paperColcor, // 纸张颜色
        paperUsage: that.data.order.paperUsage, // 纸张使用
        serviceAmout: that.data.order.serviceAmout, // 服务费
        fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
      },
      orderAmout: (that.data.order.printerNum + 1) * that.data.colcorAmout * that.data.userageAmout * that.data.typeAmout,
    })
  },
  // 获取打印机code
  getPrinterCode: function () {

    wx: wx.navigateTo({
      url: '../map/map?costs=true',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    that.getAumot()
    this.setData({
      orderAmout: that.data.order.printerNum * that.data.colcorAmout * that.data.userageAmout * that.data.typeAmout,
      order: {
        customerCode: app.data.userInfo.userCode,// 客户code
        attorneyCode: '', // 律师code
        printerCode: null, // 打印机code
        fileCodes: options.fileCode, // 文件code(多个文件中间用英文逗号分隔)
        paperType: 9, // 纸张类型
        printerNum: that.data.order.printerNum, // 打印数量
        paperColcor: 11, // 纸张颜色
        paperUsage: 12, // 纸张使用
        serviceAmout: 0, // 服务费
        fileType: 5,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
      }
    })

  },

  getAumot: function () {
    var that = this
    wx.request({
      url: app.data.api + app.data.urlDictionaryGet,
      method: 'GET',
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      data: {
        code: 'paper_type_a4'
      },
      success: function (res) {
        app.loginCheck(res)
        console.log(res.data.value)
        that.setData({
          typeAmout: res.data.value
        })
      }
    })
    wx.request({
      url: app.data.api + app.data.urlDictionaryGet,
      method: 'GET',
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      data: {
        code: 'paper_use_one'
      },
      success: function (res) {
        app.loginCheck(res)
        that.setData({
          userageAmout: res.data.value
        })

      }
    })
    wx.request({
      url: app.data.api + app.data.urlDictionaryGet,
      method: 'GET',
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      data: {
        code: 'paper_colour_colours'
      },
      success: function (res) {
        app.loginCheck(res)
        that.setData({
          colcorAmout: res.data.value
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