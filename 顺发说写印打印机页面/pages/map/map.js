var app = getApp()
Page({
  data: {
    scale: 14,
    markPoints: [],
    markers: [],
    controls: [
    ],
    circles: [],
    showView: true,
    // imgUrl: '../images/triangle_01.png'
    val: null,
    blackmoney: null,
    colormoney: null,
    costs: false,
    lat: null,
    lon: null,
    flag:true,

  },

  //点击显示
  change: function () {
    // imgUrl:false;
    // imgUrl:'../images/triangle_02.png'
    var that = this;
    that.setData({
      showView: (!that.data.showView)
    })
  },

  /*// 显示所有经纬度
  includePoints: function () {
    var _this = this;
    console.log(_this.data.markPoints);
    _this.setData({
      scale: 0
    })
    this.mapCtx.includePoints({
      padding: [10],
      points: _this.data.markPoints
    })
  },*/
  onLoad: function (options) {
    //点击显示
    showView: (options.showView == "true" ? true : false)
    var _this = this;
    if (!(Object.prototype.toString.call(options.costs) === '[object Undefined]')) {
      _this.setData({
        costs: options.costs
      })
    }
    if (!(Object.prototype.toString.call(options.printCode) === '[object Undefined]')) {
      wx.getSystemInfo({
        success: function (res) {
          //设置map高度，根据当前设备宽高满屏显示
          _this.setData({
            view: {
              Height: res.windowHeight
            }
          })
        }
      })

      wx.getLocation({
        type: 'wgs84', // 默认为 wgs84 返回 gps 坐标，gcj02 返回可用于 wx.openLocation 的坐标
        success: function (res) {
          var a = res.latitude;
          var b = res.longitude;
          wx.request({
            url: app.data.api + app.data.urlPrinterInfo + options.printCode,
            header: {
              'X-ACCESS-TOKEN': app.data.userInfo.accessToken,
            },
            method: 'GET',
            success: function (aa) {
              console.log(aa)
              //var that=this;
              console.log(aa.data.data);
              _this.setData({
                lat: a + 0.05519,
                lon: b + 0.0162,
                val: aa.data.data
              });
              //markers解决
              var _mapMarkers = [],
                _markPoints = [];
                _markPoints.push({
                  latitude: aa.data.data.longitude,
                  longitude: aa.data.data.latitude
                });

                _mapMarkers.push({
                  id: 1,
                  latitude: aa.data.data.longitude,
                  longitude: aa.data.data.latitude,
                  title: aa.data.data.name,
                  width: 40,
                  height: 40,
                  iconPath: "../images/my.png"
                })

              // console.log(_mapMarkers)
              _this.setData({
                latitude: res.latitude,
                longitude: res.longitude,
                markers: _mapMarkers,
                markPoints: _markPoints,
              })
            }
          })
        }
      })
     
      _this.setData({
        flag: false
      })
      return 
    }else {
      _this.setData({
        flag: true
      })
    }
    wx.getSystemInfo({
      success: function (res) {
        //设置map高度，根据当前设备宽高满屏显示
        _this.setData({
          view: {
            Height: res.windowHeight
          }
        })
      }
    })

    wx.getLocation({
      type: 'wgs84', // 默认为 wgs84 返回 gps 坐标，gcj02 返回可用于 wx.openLocation 的坐标
      success: function (res) {
        var a = res.latitude;
        var b = res.longitude;
        console.log(a);
        console.log(b);
        wx.request({
          url: app.data.api+'printer/nearby',
          header: {
            'X-ACCESS-TOKEN': app.data.userInfo.accessToken,
          },
          data: {
            longitude: b,
            latitude: a
          },
          method: 'GET',
          success: function (aa) {
            //var that=this;
            console.log(aa.data.data);
            _this.setData({
              lat: a + 0.05519,
              lon: b + 0.0162,
              val: aa.data.data
            });
            //markers解决
            var _mapMarkers = [],
              _markPoints = [];
            for (var i = 0; i < aa.data.data.length; i++) {
              _markPoints.push({
                latitude: aa.data.data[i].longitude,
                longitude: aa.data.data[i].latitude
              });

              _mapMarkers.push({
                id: i + 1,
                latitude: aa.data.data[i].longitude,
                longitude: aa.data.data[i].latitude,
                title: aa.data.data[i].name,
                width: 40,
                height: 40,
                iconPath: "../images/my.png"
              })

            }

            // console.log(_mapMarkers)

            _this.setData({
              latitude: res.latitude,
              longitude: res.longitude,
              markers: _mapMarkers,
              markPoints: _markPoints,


            })

            //console.log(_this.data.markers)



          }
        })

        wx.request({

          url: app.data.api+'dictionary/get',
          header: {
            'X-ACCESS-TOKEN': app.data.userInfo.accessToken,
          },
          data: {
            code: 'paper_colour_black'
          },
          method: 'GET',
          success: function (bb) {
            console.log(bb);
            _this.setData({
              blackmoney: bb.data.value
            })
          }
        })

        wx.request({

          url: app.data.api+'dictionary/get',
          header: {
            'X-ACCESS-TOKEN': app.data.userInfo.accessToken,
          },
          data: {
            code: 'paper_colour_colours'
          },
          method: 'GET',
          success: function (cc) {
            // console.log(cc);
            _this.setData({
              colormoney: cc.data.value
            })
          }
        })



      }

    })

  },

  regionchange(e) {
    console.log("regionchange===" + e.type)
  },



  //点击缩放按钮动态请求数据
  controltap(e) {
    var that = this;
    console.log("scale===" + this.data.scale)
    if (e.controlId === 1) {
      // if (this.data.scale === 13) {
      that.setData({
        scale: --this.data.scale
      })
      // }
    } else {
      //  if (this.data.scale !== 13) {
      that.setData({
        scale: ++this.data.scale
      })
      // }
    }


  },

  onReady: function (e) {
    this.mapCtx = wx.createMapContext('map')
  },
  getVal: function (e) {
    var that = this
    var pages = getCurrentPages();
    var prevPage = pages[pages.length - 2]; // 上一个页面
    if (that.data.costs) {
      that.data.costs = false
      prevPage.setData({
        printerAddress: e.currentTarget.dataset.vallist.name,
        order: {
          customerCode: prevPage.data.order.customerCode,// 客户code
          attorneyCode: prevPage.data.order.attorneyCode, // 律师code
          printerCode: e.currentTarget.dataset.vallist.code, // 打印机code
          fileCodes: prevPage.data.order.fileCodes, // 文件code(多个文件中间用英文逗号分隔)
          paperType: prevPage.data.order.paperType, // 纸张类型
          printerNum: prevPage.data.order.printerNum, // 打印数量
          paperColcor: prevPage.data.order.paperColcor, // 纸张颜色
          paperUsage: prevPage.data.order.paperUsage, // 纸张使用
          serviceAmout: prevPage.data.order.serviceAmout, // 服务费
          fileType: prevPage.data.order.fileType,// 文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)
        }
      })
      wx.navigateBack();
    }
  }


})