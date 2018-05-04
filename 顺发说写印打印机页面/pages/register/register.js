Page({

  app: getApp(),

  data: {
    items1: [
      { name: '1', value: '普通会员', checked: 'true' },
      { name: '2', value: '律师' },
    ],
    items2: [
      { checked: 'true' },
    ],
    info: {
      mobile: '',
      userType: ''
    }
  },

  radioChange: function (e) {
    this.setData({
      info: {
        userType: e.detail.value
      }
    })
  },

  checkboxChange: function (e) {
    // console.log('checkbox发生change事件，携带value值为：', e.detail.value)
  },

  formBindsubmit: function (e) {
     console.log(e);
    var that = this;
    if (e.detail.value.phone == false){
      wx.showToast({
        title: '手机号不能为空',
        icon: 'none',
        duration: 1000
      })
      
    } else if (e.detail.value.password == false && e.detail.value.restPassword == false){
      wx.showToast({
        title: '密码不能为空',
        icon: 'none',
        duration: 1000
      })
    } else if (e.detail.value.restPassword != e.detail.value.password){
      
      wx.showToast({
        title: '两次输入密码不一致',
        icon: 'none',
        duration: 1000
      })
    }else{

      // 开始请求服务器
      wx.request({
        url: getApp().data.api + 'register/code', // 请求地址，getApp().data.api为全局变量，值http://123.206.42.162:10001
        method: 'GET', // 请求方法
        header: {
          'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken // 响应头，固定写法
        },

        // 请求数据
        data: {
          mobile: e.detail.value.phone
        },

        // 请求成功回调函数
        success: function (data) {
          wx.navigateTo({
            // 跳转验证验证码页面
            url: '../VerificationCode/VerificationCode?mobile=' + e.detail.value.phone + '&userType=' + that.data.info.userType + '&password=' + e.detail.value.restPassword,
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        }
      })

    }
    
  },

  login: function () {
    wx.navigateTo({
      url: '../vip-login/vip-login',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  xieyi: function () {
    wx.navigateTo({
      url: '../yhxy/yhxy',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  }
})
