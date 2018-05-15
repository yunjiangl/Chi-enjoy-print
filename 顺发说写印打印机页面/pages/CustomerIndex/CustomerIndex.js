//index.js
//获取应用实例
const app = getApp()
//轮播图
// var app = getApp()
var template = require('../../template/template.js');
Page({
  data: {
    motto: 'Hello World',
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgUrls:[
      {
        link:'pages/index/index',
        url:'../images/index01.png'
      },{
        link:'pages/index/index',
        url:'../images/index02.png'
      },{
        link:'pages/index/index',
        url:'../images/index03.png'
      }
    ],
    // 是否出现焦点
    indicatorDots:true,
    //是否自动播放
    autoplay:true,
    //自动播放时间
    interval:5000,
    //滑动动画时间
    duration:1000,

  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  choice:function(){
    wx.navigateTo({
      url: '../choice/choice',
    })
  },
  choiceB: function () {
    wx.navigateTo({
      url: '../choice/choice',
    })
  },
  choiceC: function () {
    wx.navigateTo({
      url: '../lawyerFileClassC/lawyerFileClassC',
    })
  },
  uploadImg:function(){
    wx.chooseImage({
      count: 9, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        console.log(tempFilePaths)
      }
    })
  },
  // 扫二维码
  scanCode:function(){
    wx.scanCode({
      success:(res) =>{
        console.log(res)
      }
    })
  },
  onLoad: function () {
    template.tabbar("tabBar", 0, this, app.data.userInfo.userType, app.data.userInfo.isLock)//0表示第一个tabbar
  },
})
