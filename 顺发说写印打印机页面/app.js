//app.js
App({
  data: {
    api: 'http://123.206.42.162:10001/',
    userInfo: null,
    urlWechatLogin:"wechat/login",
    urlLogin: 'login',
    urlLogout: 'logout',
    urlForGetPasswordCode: 'forgetpassword/code',
    urlForGetPasswordVerification: 'forgetpassword/verification',
    urlForGetPasswordSave: 'forgetpassword/save',
    urlUserInfo:'user/details/info',//获取用户信息
    urlUserDetails:'user/details',//根据用户获取用户信息
    urlUserUpdate:'user/update',
    urlUserAttorneyUpdate:'user/attorney/update'
  },

  onLaunch: function () {

    var that = this;

    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []

    logs.unshift(Date.now())

    wx.setStorageSync('logs', logs)

    wx.getUserInfo({
      success: function (res) {
        // console.log(res);
        wx.getUserInfo({
          success: function (res) {
            wx.login({
              success: function (loginres) {
                wx.request({
                  url: that.data.api + that.data.urlWechatLogin,
                  data: {
                    appId: '',
                    code: loginres.code,
                    iv: res.iv,
                    encryptedData: res.encryptedData
                  },
                  method: 'GET',
                  header: {
                    //'content-type': 'X-ACCESS-TOKEN'
                  },
                  success: function (response) {

                    console.log("1");
                    console.log(response);
                    console.log("2");
                    console.log(response.data.code);
                    console.log("3");
                    console.log(response.data.data);
                    console.log("4");
                    console.log(response.data.data.userType);
                    // 如果用户刚刚使用微信登录

                    if (response.data.code == 200) {
                        // 判断用户类型

                      if (response.data.data.userType == 2) {
                          //跳转到律师首页
                          wx.redirectTo({
                            url: '../lawyerIndex/lawyerIndex'
                          })

                      } else if (response.data.data.userType == 1) {

                        console.log("5");
                          //跳转到普通用户首页
                          wx.redirectTo({
                            url: '../lawyerIndex/lawyerIndex'
                          })

                        }
                      }

                      // 为全局变量赋值
                      that.data.userInfo = response.data.data;
                      console.log(that.data.userInfo);
                    }
                })

              }
            })
          }
        })  
      }
    })
  }
})