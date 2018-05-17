// pages/lawyerMessageNotify/lawyerMessageNotify.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pageBackgroundColor: '#999',
    newsSelect:null,
    id1:null,
    code:null,
    uCode:null
  },
getData:function(){
  var that = this;
  wx.request({
    url: 'http://localhost:10001/user/newsSelect',
    method: 'GET', // 请求方法
    header: {
      'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken // 响应头，固定写法
    },
    // 请求数据
    data: {
      name: app.data.userInfo.userName
    },
    success: function (res) {
      //console.log(res.data.zxPrinterManager.printerCode);

      console.log(res.data);
      //console.log(res.data[0].userCode);
      if(res.data.length!=0){
        that.setData({
          uCode: res.data[0].userCode
        })
      }
      
      that.setData({
        newsSelect: res.data
      })
    }
  })
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.getData()
    console.log(app.data.userInfo.userName);
   
  },

  look:function(aa){
    console.log(aa.target.dataset.hi);
    
    wx.setStorageSync('id1', aa.target.dataset.hi);
    
    wx.navigateTo({
      url: '../lawyerSeeMessage/lawyerSeeMessage',
    })
  },
  chageBackgroundColor:function(bb){
    var that = this
    //console.log(bb);
    this.setData({
      code: bb.target.dataset.aa
    });
    var bgColor = this.data.pageBackgroundColor == '#3798fb' ? '#999' : '#3798fb';
    //设置背景颜色数据
    this.setData({
      pageBackgroundColor:bgColor
    });
    console.log(bb.target.dataset.aa);
    wx.request({
      url: 'http://localhost:10001/printer/updateByStatus',
      method: 'GET', // 请求方法
      header: {
        'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken // 响应头，固定写法
      },
      // 请求数据
      data: {
        id: bb.target.dataset.hi
      },
      success: function (res) {
        //console.log(res);
       // this.setData({
      //    code: res.data.zxPrinterManager.printerCode
      //  });
        //console.log(that.data.uCode);
       
       
        wx.request({
          url: 'http://localhost:10001/printer/insertByCode',
          method: 'GET', // 请求方法
          header: {
            'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken // 响应头，固定写法
          },
          // 请求数据
          data: {
            uCode: that.data.uCode,
            pCode: that.data.code
          },
          success: function (res) {
            that.getData()

          }
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