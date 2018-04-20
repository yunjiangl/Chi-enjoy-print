// pages/forgetPassword/forgetPassword.js
var interval;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    yanzhengma: '',
    mobile: '', 
    date: '请选择日期',
    fun_id: 2,
    time: '获取验证码', //倒计时 
    currentTime: 6
  },
  getCode: function (options) {
    var that = this;
    var currentTime = that.data.currentTime
    interval = setInterval(function () {
      currentTime--;
      that.setData({
        time: currentTime + 's'
      });
      console.log(currentTime);
      if (currentTime == 0) {
        clearInterval(interval)
        that.setData({
          time: '重新发送',
          currentTime: 6,
          disabled: false
        });
      }
    }, 1000);
  },
  yanzhengmaInput: function (e) {
    console.log(e)
    this.setData({
      yanzhengma: e.detail.value
    })
  },
  mobileInput: function (e) {
    console.log(e)
    this.setData({
      mobile: e.detail.value
    })
  },
  changeName: function () {
    this.getCode();
    var that = this
    that.setData({
      disabled: true
    })
    wx.request({
      url: 'http://123.206.42.162:10001/forgetpassword/code',
      header: {
        'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken,
      },
      date: {},
      method: 'POST',
      success: function (res) {
        console.log(res);
        
      }
    })
  },

  nextbtn: function () {
    if (this.data.mobile.length == 0) {
      wx.showToast({
        title: '手机号不能为空',
        icon: 'loading',
        duration: 1000
      });
    } else if (this.data.yanzhengma.length == 0) {
      wx.showToast({
        title: '验证码不能为空',
        icon: 'loading',
        duration: 1000
      });
    }else{
      wx.navigateTo({
        url: '../resetPassword/resetPassword',
        success: function (res) { },
        fail: function (res) { },
        complete: function (res) { },
      });
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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