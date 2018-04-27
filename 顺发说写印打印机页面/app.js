//app.js
App({
  data: {
    api: 'http://127.0.0.1:10001/',
    userInfo: null,
    urlWechatLogin:"wechat/login",
    urlLogin: 'login',
    userCode:'wechat00000000007',//登录成功后，存储用户code
    urlLogout: 'logout',
    urlForGetPasswordCode: 'forgetpassword/code',
    urlForGetPasswordVerification: 'forgetpassword/verification',
    urlForGetPasswordSave: 'forgetpassword/save',
    urlUserInfo:'user/details/info',//获取用户信息
    urlUserDetails:'user/details',//根据用户获取用户信息
    urlUserUpdate:'user/update',//修改用户信息
    urlUserAttorneyUpdate:'user/attorney/update',//修改律师用户
    urlUploadUserimg:'upload/file/userimg'//上传认证图片
   
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
        wx.login({
          success: function (loginres) {
            wx.request({
              url: that.data.api + 'wechat/login',
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
              success: function (data) {
                console.log(data.data);
                // 如果用户刚刚使用微信登录
                if (data.data.data.userStatus == 1) {
                  wx.redirectTo({
                    url: './register'
                  })
                 
                } else {
                  // 判断用户类型

                  if (data.data.data.userType == 2) {
                    //跳转到律师首页
                    wx.redirectTo({
                      url: './lawyerIndex'
                    })
                   
                  } else if (data.data.data.userType == 1) {
                    //跳转到普通用户首页
                    wx.redirectTo({
                      url: './index'
                    })
                    
                  }
                }

                // 为全局变量赋值
                that.data.userInfo.userCode = data.data.data.userCode;
                that.data.userInfo.userType = data.data.data.userType;
                that.data.userInfo.accessToken = data.data.data.accessToken;
              }
            })

          }
        })
      }
    })
  }
})