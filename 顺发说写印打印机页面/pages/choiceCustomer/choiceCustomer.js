// pages/cohiceCustomer/cohiceCustomer.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fileInfo: null,
    userCode: 'wechat00000000000', // 所要发送文件的客户，这个后面应该改为动态的
    fileType: null,
    order: {
      customerCode: null,// 客户code
      attorneyCode: null, // 律师code
      printerCode: null, // 打印机code
      fileCodes: null, // 文件code(多个文件中间用英文逗号分隔)
      paperType: null, // 纸张类型
      printerNum: null, // 打印数量
      paperColcor: null, // 纸张颜色
      paperUsage: null, // 纸张使用
      serviceAmout: null, // 服务费
      fileType: null,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    // 把接收到的字符串转换成json对象
    var dictionaryInfo = JSON.parse(options.fileInfo);
    console.log(dictionaryInfo);
    this.setData({
      fileInfo: dictionaryInfo,
      fileType: options.fileType
    })
  },
  choice: function () {
    var that = this;
    // 把要传递的json对象转换成字符串
    var fileInfo = JSON.stringify(that.data.fileInfo);
    console.log(that.data.fileInfo.length )
    for (var i = 0; i < that.data.fileInfo.length; i++) {
      //categoryCode作为ab和c的判断
      if (that.data.fileInfo[i].categoryCode=='cde'){
        console.log('测试');
        wx.showModal({
          title: '发送到：' + that.data.order.customerCode,
          content: '文件信息：' + that.data.fileInfo[i].fileName,
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
                  app.loginCheck(res)
                  console.log('保存订单结果' + res)
                }
              })
            } else if (res.cancel) {
              console.log('用户点击取消')
              // 取消保存订单信息
            }
          }
        })

      }else{
        wx: wx.navigateTo({
          url: '../lawyerSettingCosts/lawyerSettingCosts?fileInfo=' + fileInfo + '&userCode=' + that.data.userCode + "&fileType=" + that.data.fileType,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })
      }
    }
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