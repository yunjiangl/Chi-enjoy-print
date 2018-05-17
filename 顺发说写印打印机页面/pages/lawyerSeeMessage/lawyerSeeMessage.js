// pages/lawyerSeeMessage/lawyerSeeMessage.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id1:'',
    news:'',
    code: null,
    uCode: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'id1',
      success: function (res) {
        // success
       console.log(res);

       wx.request({
         url: 'http://localhost:10001/user/codeSelect',
         method: 'GET', // 请求方法
         header: {
           'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken // 响应头，固定写法
         },
         // 请求数据
         data: {
           code: res.data
         },
         success: function (res) {
           that.setData({
             news: res.data
           })
           console.log(res);
           if (res.data.length != 0) {
             that.setData({
               uCode: res.data.userCode
             })
           }

          console.log(res);
         }
       })
      }
    })
  },
  getData: function () {
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

        console.log(res);
        that.setData({
          newsSelect: res.data
        })
        if (res.data.length != 0) {
          that.setData({
            uCode: res.data[0].userCode
          })
        }
      }
    })
  },
  chageBackgroundColor: function (bb) {
    var that = this
    //console.log(bb);
    this.setData({
      code: bb.target.dataset.aa
    });
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
        //console.log(res.data.zxPrinterManager.printerCode);
        //console.log(that.data.uCode);
        //console.log(that.data.code);
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
            wx.navigateTo({    //保留当前页面，跳转到应用内的某个页面（最多打开5个页面，之后按钮就没有响应的）
              url: "/pages/lawyerMessageNotify/lawyerMessageNotify"
            })

          }
        })
        
        

      }
    })
  },
  newsReject: function(cc){
    var that = this
    
    wx.request({
      url: 'http://localhost:10001/printer/updateByStatus2',
      method: 'GET', // 请求方法
      header: {
        'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken // 响应头，固定写法
      },
      // 请求数据
      data: {
        id: cc.target.dataset.hi
      },
      success: function (res) {
        //console.log(res.data.zxPrinterManager.printerCode);
        
        wx.navigateTo({    //保留当前页面，跳转到应用内的某个页面（最多打开5个页面，之后按钮就没有响应的）
          url: "/pages/lawyerMessageNotify/lawyerMessageNotify"
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