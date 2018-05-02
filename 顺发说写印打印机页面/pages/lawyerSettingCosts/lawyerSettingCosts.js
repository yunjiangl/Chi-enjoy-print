// pages/lawyerSettingCosts/lawyerSettingCosts.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {

    items1: [
      { name: '12', value: '单面', checked: 'true' },
      { name: '13', value: '双面' },
    ],
    items2: [
      { checked: 'true' },
    ],
    items3: [
      { name: '10', value: '黑白', checked: 'true' },
      { name: '11', value: '彩色' },
    ],
    printerNum: 1, // 打印数量，默认为1
    paperUsage: null,//范围
    fileNames: [],
    filePaper: null,
    printerAddress: '尚未选择打印机',
    order: {
      customerCode: null,// 客户code
      attorneyCode: null, // 律师code
      printerCode: null, // 打印机code
      fileCodes: null, // 文件code(多个文件中间用英文逗号分隔)
      paperType: 9, // 纸张类型
      printerNum: null, // 打印数量
      paperColcor: 10, // 纸张颜色
      paperUsage: 12, // 纸张使用
      serviceAmout: null, // 服务费
      fileType: null,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
    }

  },

  minus: function () {
    var that = this
    that.setData({
      printerNum: that.data.printerNum - 1,
      order: {
        customerCode: that.data.order.customerCode,// 客户code
        attorneyCode: that.data.order.attorneyCode, // 律师code
        printerCode: that.data.order.printerCode, // 打印机code
        fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
        paperType: that.data.order.paperType, // 纸张类型
        printerNum: (that.data.printerNum * that.data.filePaper), // 打印数量
        paperColcor: that.data.order.paperColcor, // 纸张颜色
        paperUsage: that.data.order.paperUsage, // 纸张使用
        serviceAmout: that.data.order.serviceAmout, // 服务费
        fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
      }
    })
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
        printerNum: (that.data.printerNum * that.data.filePaper), // 打印数量
        paperColcor: that.data.order.paperColcor, // 纸张颜色
        paperUsage: that.data.order.paperUsage, // 纸张使用
        serviceAmout: that.data.order.serviceAmout, // 服务费
        fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
      }
    })
  },
  // 改变单双面
  usageChange: function (e) {
    var that = this
    that.setData({
      order: {
        customerCode: that.data.order.customerCode,// 客户code
        attorneyCode: that.data.order.attorneyCode, // 律师code
        printerCode: that.data.order.printerCode, // 打印机code
        fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
        paperType: that.data.order.paperType, // 纸张类型
        printerNum: that.data.order.printerNum, // 打印数量
        paperColcor: that.data.order.paperColcor, // 纸张颜色
        paperUsage: e.detail.value, // 纸张使用
        serviceAmout: that.data.order.serviceAmout, // 服务费
        fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
      }
    })
  },
  // 改变颜色
  colcorChange: function (e) {
    var that = this
    that.setData({
      order: {
        customerCode: that.data.order.customerCode,// 客户code
        attorneyCode: that.data.order.attorneyCode, // 律师code
        printerCode: that.data.order.printerCode, // 打印机code
        fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
        paperType: that.data.order.paperType, // 纸张类型
        printerNum: that.data.order.printerNum, // 打印数量
        paperColcor: e.detail.value, // 纸张颜色
        paperUsage: that.data.order.paperUsage, // 纸张使用
        serviceAmout: that.data.order.serviceAmout, // 服务费
        fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
      }
    })
  },
  // 获取律师输入服务费用
  serviceAmout: function (e) {
    var that = this
    that.setData({
      order: {
        customerCode: that.data.order.customerCode,// 客户code
        attorneyCode: that.data.order.attorneyCode, // 律师code
        printerCode: that.data.order.printerCode, // 打印机code
        fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
        paperType: that.data.order.paperType, // 纸张类型
        printerNum: that.data.order.printerNum, // 打印数量
        paperColcor: that.data.order.paperColcor, // 纸张颜色
        paperUsage: that.data.order.paperUsage, // 纸张使用
        serviceAmout: e.detail.value, // 服务费
        fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
      }
    })
  },
  showModal: function () {
    var that = this
    var msg = ''
    for (var i in this.data.fileNames) {
      msg += this.data.fileNames[i]
    }
    console.log(that.data.order)
    wx.showModal({
      title: '发送到：' + that.data.order.customerCode,
      content: '律师服务费：' + that.data.order.serviceAmout + msg,
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定')
          // 向服务端发送订单数据保存订单
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
              console.log('保存订单结果' + res)
            }
          })
        } else if (res.cancel) {
          console.log('用户点击取消')
          // 取消保存订单信息
        }
      }
    })
  },
  // 获取律师的code
  getLawyerCode: function () {
    var that = this
    // 因为接口原因，目前将律师的code设置为死的数据，当接口获取成功之后可将此方法删除
    that.setData({
      order: {
        customerCode: that.data.order.customerCode,// 客户code
        attorneyCode: app.data.userCode, // 律师code
        printerCode: that.data.order.printerCode, // 打印机code
        fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
        paperType: that.data.order.paperType, // 纸张类型
        printerNum: that.data.order.printerNum, // 打印数量
        paperColcor: that.data.order.paperColcor, // 纸张颜色
        paperUsage: that.data.order.paperUsage, // 纸张使用
        serviceAmout: that.data.order.serviceAmout, // 服务费
        fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
      }
    })


  },
  // 获取打印机code，目前写死，之后需要调整
  getPrinterCode: function () {
    // console.log("获得打印机code")
    // var that = this
    // this.setData({
    //   order: {
    //     customerCode: that.data.order.customerCode,// 客户code
    //     attorneyCode: that.data.order.attorneyCode, // 律师code
    //     printerCode: '1561563', // 打印机code
    //     fileCodes: that.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
    //     paperType: that.data.order.paperType, // 纸张类型
    //     printerNum: that.data.order.printerNum, // 打印数量
    //     paperColcor: that.data.order.paperColcor, // 纸张颜色
    //     paperUsage: that.data.order.paperUsage, // 纸张使用
    //     serviceAmout: that.data.order.serviceAmout, // 服务费
    //     fileType: that.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
    //   }
    // })
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
    // 在页面加载时就设置order的律师code
    this.getLawyerCode()
    // 把接收到的字符串转换成json对象
    var fileInfo = JSON.parse(options.fileInfo);

    var fileCodes = '' // 文件code
    var filePaper = null // 页数
    var fileNames = []

    // 通过循环，获得订单的一些初始数据 
    for (var i in fileInfo) {
      filePaper += fileInfo[i].fileNum
      fileCodes += fileInfo[i].fileCode
      fileNames.push(fileInfo[i].fileName)
      if (i != fileInfo.length - 1) {
        fileCodes += ","
      }
    }
    var that = this
    this.setData({
      fileNames: fileNames,
      filePaper: filePaper,
      order: {
        customerCode: options.userCode,// 客户code
        attorneyCode: that.data.order.attorneyCode, // 律师code
        printerCode: that.data.order.printerCode, // 打印机code
        fileCodes: fileCodes, // 文件code(多个文件中间用英文逗号分隔)
        paperType: that.data.order.paperType, // 纸张类型
        printerNum: filePaper, // 打印数量
        paperColcor: that.data.order.paperColcor, // 纸张颜色
        paperUsage: that.data.order.paperUsage, // 纸张使用
        serviceAmout: that.data.order.serviceAmout, // 服务费
        fileType: options.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
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