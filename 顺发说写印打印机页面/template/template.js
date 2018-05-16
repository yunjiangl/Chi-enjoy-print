//初始化数据
function tabbarinit(userType) {
  
  if (userType == 1) {
    return [
      {
        "pagePath": "../CustomerIndex/CustomerIndex",
        "text": "打印文件",
        "iconPath": "../images/icon/1.png",
        "selectedIconPath": "../images/file.png"
      },
      {
        "pagePath": "../upfilelist/upfilelist",
        "text": "上传列表",
        "iconPath": "../images/icon/2.png",
        "selectedIconPath": "../images/uplist.png"
      },
      {
        "pagePath": "../historyConsultant/historyConsultant",
        "text": "历史咨询",
        "iconPath": "../images/Historical.png",
        "selectedIconPath": "../images/icon/3.png"
      },
      {
        "pagePath": "../printOrders/printOrders",
        "text": "打印订单",
        "iconPath": "../images/order.png",
        "selectedIconPath": "../images/icon/4.png"
      },
      {
        "pagePath": "../personalCenter/personalCenter",
        "text": "个人中心",
        "iconPath": "../images/person.png",
        "selectedIconPath": "../images/icon/5.png"
      }
    ]
  } else if (userType == 2) {
   // console.log("测试" + userType);
    return [
      {
        "pagePath": "../lawyerIndex/lawyerIndex",
        "text": "打印文件",
        "iconPath": "../images/icon/1.png",
        "selectedIconPath": "../images/file.png"
      },
      {
        "pagePath": "../upfilelist/upfilelist",
        "text": "上传列表",
        "iconPath": "../images/icon/2.png",
        "selectedIconPath": "../images/uplist.png"
      },
      {
        "pagePath": "../historyConsultant/historyConsultant",
        "text": "历史咨询",
        "iconPath": "../images/Historical.png",
        "selectedIconPath": "../images/icon/3.png"
      },
      {
        "pagePath": "../printOrders/printOrders",
        "text": "打印订单",
        "iconPath": "../images/order.png",
        "selectedIconPath": "../images/icon/4.png"
      },
      {
        "pagePath": "../lawyerpersonData/lawyerpersonData",
        "text": "个人中心",
        "iconPath": "../images/person.png",
        "selectedIconPath": "../images/icon/5.png"
      }
    ]
  }

}
//tabbar 主入口
function tabbarmain(bindName = "tabdata", id, target, userType) {
  console.log("初始化导航栏数据")
  var that = target;
  var bindData = {};
  var otabbar = tabbarinit(userType);
  otabbar[id]['iconPath'] = otabbar[id]['selectedIconPath']//换当前的icon
  otabbar[id]['current'] = 1;
  bindData[bindName] = otabbar
  that.setData({ bindData });
}

module.exports = {
  tabbar: tabbarmain
}