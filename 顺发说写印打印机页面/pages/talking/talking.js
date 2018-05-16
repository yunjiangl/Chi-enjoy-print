// pages/talking/talking.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    value:"",
    list:[],
    userTwo: '律师',
    userTwoCode: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: "与"+this.data.userTwo+"对话中"
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
    // this.msgInterval();
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
  
  },
  inputBind: function (e) {
    this.setData({
      value: e.detail.value
    })
  },
  msgInterval : function(){
    var that = this;
    setInterval(function () {
      var valueList = that.data.list;
      var obj = new Object;
      obj.name = getApp().data.userInfo.userName;
      //请求接口获取数据展示

      obj.value = "hahahahahhahah";
      obj.type = 'one';
      valueList.push(obj);
      that.setData({
        list: valueList
      });
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
      this.setData({
        list: valueList,
        value:''
      });
      //数据传输到后台，后台记录
    }
  }
})