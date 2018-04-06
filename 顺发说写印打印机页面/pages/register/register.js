Page({
  data: {
    items1: [
      { name: 'putong', value: '普通会员', checked: 'true' },
      { name: 'lvshi', value: '律师' },
    ],
    items2: [
      { checked: 'true' },
    ]
  },
  radioChange: function (e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value)
  },
  checkboxChange: function (e) {
    console.log('checkbox发生change事件，携带value值为：', e.detail.value)
  },
  PhoneNext: function () {
    wx.navigateTo({
      url: '../VerificationCode/VerificationCode',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
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
