// pages/lawyerTransactionOrder/lawyerTransactionOrder.js
var app = getApp();
var util = require('../../utils/util.js');  
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nameOrCode:'',
    timeone:'',
    zxoder:null,
    nameOrCode:null,
    time:null,
    userCode:null,
    count:0
  },
  getData: function () {
    var that = this;
    var userCode = app.data.userInfo.userCode;
    //console.log(userCode);
    //console.log("测试1");
    //console.log(app.data.userCode)
    //console.log(app.data.userInfo.accessToken);
    wx.request({
      url: app.data.api + 'order/attorney',
      method: 'GET',
      data:{
        userCode: userCode
      },
      header: {
        'X-ACCESS-TOKEN': app.data.userInfo.accessToken
      },
      success: function (res) {
        var list = [];
        var count=0;
        //console.log(res.data.data)
        for (var i = 0; i < res.data.data.length; i++) {
          list.push(res.data.data[i]);
          count=count+res.data.data[i].serviceAmount;
        }
        //console.log(list)
        that.setData({
          zxoder:list,
          userCode: userCode,
          count:count
        })
       // console.log(that.data.zxoder)
      }
    })
  },
  sousuo: function (e) {
    var that = this;
    //console.log(e.detail.value)
    that.setData({
      nameOrCode: e.detail.value
    })
  },
  ss: function () {
    var that = this;
    var nameOrCode = that.data.nameOrCode;
    console.log(nameOrCode);
    console.log("测试一");
    if (nameOrCode == null || nameOrCode == '') {
      //console.log("测试1")
      wx.showModal({
        content: '请输入查询的内容',
        success: function (res) {
          // console.log(res.confirm);
        }
      })
    } else {
      wx.request({
        url: app.data.api + 'order/attorney',
        header: {
          'X-ACCESS-TOKEN': app.data.userInfo.accessToken
        },
        method: 'GET',
        data: {
          userCode: that.data.userCode,
          nameOrCode: nameOrCode
        },
        success: function (resdata) {
          if (resdata.data.data.length == 0) {
            wx.showModal({
              content: '没有查询的内容',
              success: function (res) {
                // console.log(res.confirm);
              }
            })
          }
          that.setData({
            printList: resdata.data.data
          })
        }
      })
    }
  },
  bindDateChange:function(e){
    var that=this;
    var time = e.detail.value+"-01";
    //var date = new Date(time);
   // console.log(date)
      wx.request({
        url: app.data.api + 'order/attorney',
        header: {
          'X-ACCESS-TOKEN': app.data.userInfo.accessToken
        },
        method: 'GET',
        data: {
          userCode: that.data.userCode,
          timeo:time
        },
        success: function (resdata) {
          //console.log(resdata.data.data.length);
          if(resdata.data.data.length==0){
            wx.showModal({
              content: '没有查询的内容',
              success: function (res) {
                // console.log(res.confirm);
              }
            })
          }
          that.setData({
            printList: resdata.data.data
          })
        }
      })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    that.getData();
    var time = util.formatTime(new Date());
    //console.log(time)
    // 再通过setData更改Page()里面的data，动态更新页面的数据  
    this.setData({
      timeone: time
    });  
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