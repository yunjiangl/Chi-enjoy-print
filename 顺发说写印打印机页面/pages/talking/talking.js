// pages/talking/talking.js
var lodingTime='';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    value:"",
    list:[],
    userTwo: '律师',
    userTwoCode: 'wechat00000000020',
    user: '客户',
    userCode: 'wechat00000000022'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: "与" + (getApp().data.userInfo.userType == 2 ? options.userName : options.attorneyName)+"对话中"
    });
    this.setData({
      userTwo: options.attorneyName,
      userTwoCode: options.attorneyCode,
      user: options.userName,
      userCode: options.userCode
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
    this.msgInterval(lodingTime);
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
    clearInterval(lodingTime);
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
  
  },
  inputBind: function (e) {
    this.setData({
      value: e.detail.value
    })
  },
  msgInterval : function(){
    var that = this;
    lodingTime=setInterval(function () {
      var valueList = that.data.list;
      
      //请求接口获取数据展示
      wx.request({
        url: getApp().data.api + "im/select",
        method: "GET",
        header: {
          'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken
        },
        data: {
          type: getApp().data.userInfo.userType==2?1:2,
          userCode:that.data.userCode,
          code:that.data.userTwoCode
        },
        success: function (res) {
          console.log(res);
          var txts = res.data.data;
          if (txts != null && txts.length > 0) {

            for (var i = 0; i < txts.length; i++) {
              if (txts[i] != 'null' &&  txts[i] != '' && txts[i] != undefined) {
                var obj = new Object;
                obj.name = getApp().data.userInfo.userName;
                obj.value = txts[i];
                obj.type = 'one';
                valueList.push(obj);
              }
            }

            that.setData({
              list: valueList
            });
          }
        }
      })
      
    }, 1000);
  },
  sendBtn: function () {
    console.log(this.data.value);
    if (this.data.value != '' && this.data.value.length>0){
      var valueList = this.data.list;
      var obj = new Object;
      obj.name = getApp().data.userInfo.userName;
      obj.value = this.data.value;
      obj.type = 'two';
      valueList.push(obj);
      //数据传输到后台，后台记录
      wx.request({
        url: getApp().data.api + "im/add",
        method: "GET",
        header: {
          'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken
        },
        data: {
          type: getApp().data.userInfo.userType,
          userCode: this.data.userCode,
          code: this.data.userTwoCode,
          msg: obj.value
        },
        success: function (res) {
          console.log(res)
        }
      });

      this.setData({
        list: valueList,
        value: ''
      });
    }
  }
})