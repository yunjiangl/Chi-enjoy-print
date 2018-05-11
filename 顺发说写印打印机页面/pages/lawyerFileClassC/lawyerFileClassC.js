// pages/lawyerFileClassC/lawyerFileClassC.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    items1: [
      { name: 'putong', value: '', checked: 'false' },
    ],
      query: '',
      categoryCode: 'cde',
      page:1,
      pagesize:10,
      time:'',
      fileInfoList: [],
      fileInfo:[],
      fileType:5 ,//根据lawyerFourFileList.js中的fileType定义
      ids:[],
      userType:null,
      userCode:null,
      managerCode:null
    
  },
  getData: function () {
    var that = this;
    console.log(app.data.userInfo.openId);
    var userType = app.data.userInfo.userType;
    var userCode = app.data.userInfo.userCode;
    that.userType = userType;
    if(that.userType==1){
      that.userCode = app.data.userInfo.userCode;
      that.managerCode =0;
    }
    if (that.userType == 2){
      that.managerCode = app.data.userInfo.userCode;
      that.userCode =0;
    }
  //  console.log(that.userCode);
  //  console.log(that.managerCode);
   // console.log(that.userType);
    wx.request({
      url: app.data.api + 'file/m/c/page',
      method: 'GET',
      data: {
        query: that.data.query,
        categoryCode: that.data.categoryCode,
        page: that.data.page,
        pageSize: that.data.pagesize
      },
      success: function (res) {
      //  console.log(res);
       // console.log(that.userCode);
        var list = [];
       // console.log(res.data.data.content[0].uuserCode);
        for (var i = 0; i < res.data.data.content.length; i++) {
         // console.log(res.data.data.content[i].userCode);
          if (that.userCode == res.data.data.content[i].userCode){
            if (res.data.data.content[i].fileNum == null) {
              res.data.data.content[i].fileNum = 0;
            }
            list.push(res.data.data.content[i]);
          }
          if (that.managerCode == res.data.data.content[i].managerCode){
            if (res.data.data.content[i].fileNum == null) {
              res.data.data.content[i].fileNum = 0;
            }
            list.push(res.data.data.content[i]);
          }
        }
        that.setData({
          fileInfoList: list,
          userType: app.data.userInfo.userType,
        })
       // console.log(that.data.fileInfoList);
      }
    })
  },
  radioChange: function (e) {
    var that = this;
    var fileInfo = [];
    //console.log(e.detail.value);
    for (var i in e.detail.value) {
      fileInfo.push(that.data.fileInfoList[e.detail.value[i]])
    }
    this.setData({
      fileInfo: fileInfo
    })
  },
  choiceCustomer: function () {
    var that = this;
    // 把要传递的json对象转换成字符串
    var fileInfo = JSON.stringify(that.data.fileInfo);
    if (that.data.fileInfo <= 0) {
      wx.showModal({
        content: '请选择发送的文件',
        success: function (res) {
          console.log(res.confirm);
        }
      })
    }else{
      wx: wx.navigateTo({
        url: '../choiceCustomer/choiceCustomer?fileInfo=' + fileInfo + "&fileType=" + that.data.fileType,
        success: function (res) { },
        fail: function (res) { },
        complete: function (res) { },
      })
    }
  },
  deleteFile: function(){
    var that=this;
    var ids=[];
    if (that.data.fileInfo<=0){
      wx.showModal({
        content: '请选择删除的文件',
        success: function (res) {
         console.log(res.confirm);
        }
      })
    }else{
      for (var i in that.data.fileInfo){
        console.log(that.data.fileInfo[i].id);
        ids.push(that.data.fileInfo[i].id);
      }
      //console.log(ids[0]);
      that.setData({
        ids: ids
      })
      wx.showModal({
        content: '确定删除选择的文件吗？',
        success: function (res) {
          if(res.confirm){
            wx.request({
              url: app.data.api + 'file/m/deleteFile',
              method: 'DELETE',
              dataType: 'json', 
              header:{
                'content-type': 'application/json'
              },
              data: JSON.stringify(that.data.ids),
              traditional: true ,
              success: function (res) {
                that.getData();
                //that.data.items1.checked=false
              }
            })
          }
        } 
      })
    }
  },
  fasong: function(){
    var that = this;
    var ids = [];
	    var fileInfo = JSON.stringify(that.data.fileInfo);
      console.log(fileInfo);
      console.log(that.data.userCode);
      console.log(that.data.fileType);
    if (that.data.fileInfo <= 0) {
      wx.showModal({
        content: '请选择需要设置的文件',
        success: function (res) {
          console.log(res.confirm);
        }
      })
    } else {
      for (var i in that.data.fileInfo) {
        console.log(that.data.fileInfo[i].id);
        ids.push(that.data.fileInfo[i].id);
      }
      //console.log(ids[0]);
      that.setData({
        ids: ids
      })
      wx.navigateTo({
        // url: '../lawyerSettingCosts/lawyerSettingCosts',
        url: '../lawyerSettingCosts/lawyerSettingCosts?fileInfo=' + fileInfo + '&userCode=' + that.data.userCode + "&fileType=" + that.data.fileType
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.getData();
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