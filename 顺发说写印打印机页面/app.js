//app.js
App({
  data: {
    api: 'http://123.206.42.162:10001/',
    userInfo: {
      accessToken: null, // 登录之后系统返回的X-ACCESS-TOKEN
      userType: null,// 用户类型，1为普通用户，2为律师用户
    },
    urlWechatLogin: "wechat/login",
    urlLogin: 'login',
    userCode: 'wechat00000000000',//登录成功后，存储用户code
    urlLogout: 'logout',
    urlForGetPasswordCode: 'forgetpassword/code',
    urlForGetPasswordVerification: 'forgetpassword/verification',
    urlForGetPasswordSave: 'forgetpassword/save',
    urlUserInfo: 'user/details/info',//获取用户信息
    urlUserDetails: 'user/details',//根据用户获取用户信息
    urlUserUpdate: 'user/update',//修改用户信息
    urlUserAttorneyUpdate: 'user/attorney/update',//修改律师用户
    urlUploadUserimg: 'upload/file/userimg',//上传认证图片
    urlDictionaryAList: 'dictionary/a/list', // a文件分类
    urlFileMAPage: 'file/m/a/page',//a文件分页
    urlOrderSave: 'order/save',//保存订单信息
    urlDomainList: 'dictionary/domain/list',//律师领域
    urlPrinterNearby: 'printer/nearby', // 附近的打印机
    urlPrinterAttorney: "printer/attorney", // 打印机关联律师
  },

  // 微信登录
  wxLogin: function (res, loginres) {
    var that = this;
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
        console.log(data);
        that.LoginRes(data)
      }
    })
  },
  // 登录success之后的操作
  LoginRes: function (data) {
    var that = this
    if (data.data.code == 300) {
      console.log("登录失败")
      wx.redirectTo({
        url: '../vip-login/vip-login'
      })
    } else if (data.data.code == 200) {
      // 如果用户刚刚使用微信登录
      if (data.data.data.userStatus == 1) {
        wx.redirectTo({
          url: '../register/register'
        })

      } else {
        // 判断用户类型

        if (data.data.data.userType == 2) {
          console.log("我是律师")
          //跳转到律师首页
          wx.redirectTo({
            url: "../lawyerIndex/lawyerIndex"
          })


        } else if (data.data.data.userType == 1) {
          //跳转到普通用户首页
          wx.redirectTo({
            url: '../CustomerIndex/CustomerIndex'
          })

        }
      }
      // 为全局变量赋值
      that.data.userCode = data.data.data.userCode;
      that.data.userInfo.userType = data.data.data.userType;
      that.data.userInfo.accessToken = data.data.data.accessToken;
    }
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
            that.wxLogin(res, loginres)
          }
        })
      }
    })
  }
})