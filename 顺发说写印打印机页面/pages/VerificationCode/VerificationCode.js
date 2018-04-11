// pages/VerificationCode/VerificationCode.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    mobile: '',
    password: '',
    userType: '',
    code: '',
    province: '',
    city: '',
    area: '',
    grad: '',
    name: ''
  },

  phoneInput: function (e) {

    this.setData({
      code: e.detail.value
    })
  },

  // 验证验证码
  login: function () {
    var that = this;
    console.log('验证码：' + that.data.code);

    // 开始服务端请求
    wx.request({
      url: getApp().data.api + 'register/verification', // 请求地址，getApp().data.api为全局变量，值http://123.206.42.162:10001
      method: 'GET', // 请求方法
      header: {
        'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken // 响应头，固定写法
      },
      // 请求数据
      data: {
        mobile: that.data.mobile,
        code: that.data.code,
        type: ''
      },
      success: function (res) {
        console.log(res);

        if (res.data.code == 200) {
          // 验证码正确
          wx.request({
            url: getApp().data.api + 'register/save',
            header: {
              'X-ACCESS-TOKEN': getApp().data.userInfo.accessToken,
              'content-type': 'application/x-www-form-urlencoded;charset=utf-8'
            },
            method: 'POST', // 请求方法
            data: {
              mobile: that.data.mobile,
              code: that.data.code,
              type: that.data.userType,
              password: that.data.password,
              province: that.data.province,
              city: that.data.city,
              area: '11',
              name: that.data.name,
              wechatId: '11',
              age: '11',
              grad: that.data.grad
            },
            success: function (e) {
              console.log(that.data.userType);
              if (that.data.userType == 1) {
                wx.redirectTo({
                  url:'../index/index'
                })
              } else if (that.data.userType == 2) {
                wx.redirectTo({
                  url: '../lawyerIndex/lawyerIndex'
                })
                
              }
              wx.showToast({
                title: '成功',
                icon: 'success',
                duration: 2000
              })
            }
          })
        } else if (res.data.code == 300) {
          console.log(res.data.message);
          wx.showToast({
            title: '验证码错误',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getUserInfo({
      success: function (res) {
        console.log(res);
        that.setData({
          province: res.userInfo.province,
          city: res.userInfo.city,
          area: '',
          grad: res.userInfo.gender,
          name: res.userInfo.nickName
        })
      }
    })

    this.setData({
      mobile: options.mobile,
      password: options.password,
      userType: options.userType
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