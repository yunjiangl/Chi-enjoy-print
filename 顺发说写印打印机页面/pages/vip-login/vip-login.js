
//获取应用实例
var app = getApp()
//var api = 'http://47.94.103.214:10001/wechat/login'
Page({
  data: {
    phone: '',
    password: '',
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
    if (this.data.phone.length == 0) {
      wx.showToast({
        title: '用户名不能为空',
        icon: 'loading',
        duration: 1000
      });
    } else if (this.data.password.length == 0) {
      wx.showToast({
        title: '密码不能为空',
        icon: 'loading',
        duration: 1000
      });
    } else {
      // 这里修改成跳转的页面  
      wx.request({
        url: getApp().data.api + getApp().data.urlLogin, // 后台对该方法没有实现
        data: {
          mobile: this.data.phone,
          pwd: this.data.password,
        },
        method: 'GET',
        header: {
          "X-ACCESS-TOKEN": getApp().data.userInfo.accessToken
        },
        success: function (response) {
          // console.log(response.data.data);
          
          app.LoginRes(response)
          
        },
       fail: function (res) { 
         console.log(res);
       },
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
      success: function (res) {
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  weiLogin: function () {
    wx.getUserInfo({
      success: function (res) {
        wx.login({
          success: function (loginres) {
            app.wxLogin(res, loginres)
          }
        })
      }
    })
  }
});
