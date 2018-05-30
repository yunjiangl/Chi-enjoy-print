

//index.js
//获取应用实例
const app = getApp()
//轮播图
// var app = getApp()
var template = require('../../template/template.js');
Page({
  data: {
    motto: 'Hello World',
    userInfo: null,
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgUrls: [
      {
        link: 'pages/index/index',
        url: '../images/index01.png'
      }, {
        link: 'pages/index/index',
        url: '../images/index02.png'
      }, {
        link: 'pages/index/index',
        url: '../images/index03.png'
      }, {
        link: 'pages/index/index',
        url: '../images/index04.png'
      }
    ],
    // 是否出现焦点
    indicatorDots: true,
    //是否自动播放
    autoplay: true,
    //自动播放时间
    interval: 5000,
    //滑动动画时间
    duration: 1000,

  },
  onLoad: function (options) {

    this.setData({
      userInfo: getApp().data.userInfo
    });
    template.tabbar("tabBar", 0, this, app.data.userInfo.userType)//0表示第一个tabbar
  },
  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  choice: function () {
    wx.navigateTo({
      url: '../lawyerFileClassA/lawyerFileClassA',
    })
  },
  choiceB: function () {
    wx.navigateTo({
      url: '../lawyerFileClassB/lawyerFileClassB',
    })
  },
  choiceC: function () {
    wx.navigateTo({
      url: '../lawyerFileClassC/lawyerFileClassC',
    })
  },
  //文件打印
  mainRight: function () {
    // wx.navigateTo({
    //   url: '../ImportFile/ImportFile',
    // })

    wx.getSavedFileInfo({
      filePath: '/', //仅做示例用，非真正的文件路径
      success: function (res) {
        console.log(res.size)
        console.log(res.createTime)
      }
    })
  },

  uploadImg: function () {
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        wx.uploadFile({
          url: app.data.api + app.data.urlUploadFileE,
          filePath: tempFilePaths[0],
          name: 'multipartFile',
          header: {
            'X-ACCESS-TOKEN': app.data.userInfo.accessToken
          },
          formData: {
            'abstracts': '用户上传手机图片', // 摘要
            'userCode': app.data.userInfo.userCode,//用户code
          },
          success: function (res) {
            var data = JSON.parse(res.data);
            console.log(data)
            wx.navigateTo({
                url: '../setPrint/setPrint?fileCode=' + data.data
            })
          }
        })
      }
    })
  },
  map: function () {
    wx.navigateTo({
      url: '../map/map',
    })
  },
  // 扫二维码
  scanCode: function () {
    console.log(getApp().data.userInfo);
    wx.scanCode({
      success: (res) => {
        console.log(res)
      }
    })
  }
})

