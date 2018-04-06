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
  login: function () {
    wx.navigateTo({
      url: '../login/login',
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
