//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    phone: '',
    password: ''
  },
  onPullDownRefresh: function () { //下拉刷新
    wx.showNavigationBarLoading();
    setTimeout(function () {
      wx.hideNavigationBarLoading();
      wx.stopPullDownRefresh();
    }, 1000);
  },
  // 获取输入账号  
  phoneInput: function (e) {
    this.setData({
      phone: e.detail.value
    })
  },

  // 获取输入密码  
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },

  // 登录  
  login: function () {
    if (this.data.phone.length == 0 || this.data.password.length == 0) {
      wx.showToast({
        title: '用户名和密码不能为空',
        icon: 'loading',
        duration: 1000
      })
    } else {
      // 这里修改成跳转的页面  
      wx.navigateTo({
        url: '',
        success: function (res) { },
        fail: function (res) { },
        complete: function (res) { },
      })
    }
  },
  //注册
  zhuce: function () {
    wx.navigateTo({
      url: '../register/register',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  //忘记密码
  forget: function () {
    wx.navigateTo({
      url: '../forgetPassword/forgetPassword',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  }
})
