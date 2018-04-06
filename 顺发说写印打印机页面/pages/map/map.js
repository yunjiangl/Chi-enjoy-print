// pages/map/map.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    actionSheetHidden:true,
    actionSheetItems:[
      {bindtap: 'Menu1', txt: '第一个打印机'},
      {bindtap: 'Menu2', txt: '第二个打印机'},
      {bindtap:'Menu3',txt:'第三个打印机'}
    ],
    menu:'',

    markers: [{
      // iconPath: "/resources/others.png",
      id: 0,
      latitude: 23.099994,
      longitude: 113.324520,
      width: 50,
      height: 50
    }],
    polyline: [{
      points: [{
        longitude: 113.3245211,
        latitude: 23.10229
      }, {
        longitude: 113.324520,
        latitude: 23.21229
      }],
      color: "#FF0000DD",
      width: 2,
      dottedLine: true
    }],
    controls: [{
      id: 1,
      // iconPath: '/resources/location.png',
      position: {
        left: 0,
        top: 300 - 50,
        width: 50,
        height: 50
      },
      clickable: true
    }]
  },
  regionchange(e) {
    console.log(e.type)
  },
  markertap(e) {
    console.log(e.markerId)
  },
  controltap(e) {
    console.log(e.controlId)
  },
  //附件打印机
  actionSheetTap:function(){
    this.setData({
      actionSheetHidden:!this.data.actionSheetHidden
    })
  },
  actionSheetbindchange:function(){
    this.setData({
      actionSheetHidden:!this.data.actionSheetHidden
    })
  },
  bindMenu1:function(){
    actionSheetHidden:!this.data.actionSheetHidden
  },
  bindMenu2: function () {
    actionSheetHidden:!this.data.actionSheetHidden
  },
  bindMenu3: function () {
    actionSheetHidden:!this.data.actionSheetHidden
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
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