//app.js
var countNum = 1;
App({
  data: {
    //api: 'http://127.0.0.1:10001/',
    api: 'http://127.0.0.1:10001/',
    userInfo: {
      accessToken: null, // 登录之后系统返回的X-ACCESS-TOKEN
      userType: 2,// 用户类型，1为普通用户，2为律师用户（），
      isLock: null,//1,律师认证通过，3为律师认证未通过和正在审核中
      userCode: null,
      openId: null,
      userName: null
    },
    count: 0,
    count: 0,
    urlWechatLogin: "wechat/login",
    urlLogin: 'login',
    //userCode: 'wechat00000000000',//登录成功后，存储用户code
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
    urlOrderList: "order/list", // 订单列表
    urlPrinterAll: 'printer/all',//所有打印机
    urlPrinterMy: 'printer/my',//所有打印机
    urlPrinterFind: 'printer/find/',//物主打印机
    urlPrinterApply: 'printer/apply/',//加入申请
    urlPrinterInfo: 'printer/info/',//打印机详情
    urlPrinterOut: 'printer/out/',//打印机详情
    urlUploadFileE: 'upload/file/e', // 用户上传照片  
    urlDictionaryGet: 'dictionary/get',//获取字典信息
    urlOrderPrinter: 'order/printer/',// 打印订单文件
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
    if (data.data.code != 200) {
      console.log("登录失败")
      countNum = countNum + 1;
      if (countNum == 4) {
        wx.redirectTo({
          url: '../vip-login/vip-login'
        })
      } else {
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
    } else if (data.data.code == 200) {
      //先赋值openId
      that.data.userInfo.openId = data.data.data.openId;
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
    
    // 为全局变量赋值
    console.log(data.data.data);
    that.data.userCode = data.data.data.userCode;
    that.data.userInfo.userType = data.data.data.userType;
    that.data.userInfo.isLock = data.data.data.isLock;
    that.data.userInfo.accessToken = data.data.data.accessToken;
    that.data.userInfo.userCode = data.data.data.userCode;
    that.data.userInfo.userCode = data.data.data.userCode;
    that.data.userInfo.userName = data.data.data.nickName;
    }
  },

  onLaunch: function () {

    var that = this;

    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []

    logs.unshift(Date.now())

    wx.setStorageSync('logs', logs)

    wx.login({
      success: function (res) {
        console.log(res);
        wx.getUserInfo({
          success: function (loginres) {
            that.wxLogin(res, loginres);
          }
        })
      }
    })
  },
  //支付调用接口
  payAction: function (orderCode, openId) {
    var that = this;
    wx.request({
      url: that.data.api + 'pay/account',
      data: {
        code: orderCode,
        openId: openId
      },
      method: 'GET',
      header: {
        "X-ACCESS-TOKEN": that.data.userInfo.accessToken
      },
      success: function (data) {
        console.log(data);
        wx.requestPayment({
          timeStamp: data.data.data.timeStamp,
          nonceStr: data.data.data.nonceStr,
          package: data.data.data.package,
          signType: data.data.data.signType,
          paySign: data.data.data.paySign,
          success: function (response) {
            console.log(response);
          },
          fail: function (response) {
            console.log(response);
          },
          complete: function (response) {
            console.log(response);
            var status = 4;
            if (response.errMsg == 'requestPayment:ok') {
              status = 5;
            }
            wx.request({
              url: that.data.api + 'pay/manual/callback',
              data: {
                code: orderCode,
                status: status,
                prepayId: data.data.data.payCode,
                error: response.errMsg
              },
              method: 'POST',
              header: {
                "content-type": "application/x-www-form-urlencoded",
                "X-ACCESS-TOKEN": that.data.userInfo.accessToken
              },
              success: function (res) {
                console.log(res);
              }
            })
          }
        })
      }
    })
  },

  //判断登录状态
  loginCheck: function (res) {
    var that = this

    if (res.data.code == 400 || res.data.code == 600) {
      wx.getUserInfo({
        success: function (res) {
          // console.log(res);
          wx.login({
            success: function (loginres) {
              that.wxLogin(res, loginres)
            }
          })
        }
      });
    }
  }
})