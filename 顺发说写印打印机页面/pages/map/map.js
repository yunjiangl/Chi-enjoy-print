
Page({
  data: {
    scale: 14,

    markPoints: [],
    markers: [],

    controls: [{
      id: 1,
      iconPath: '../images/jian.png',
      position: {
        left: 320,
        top: 100 - 50,
        width: 20,
        height: 20
      },
      clickable: true
    },
    {
      id: 2,
      iconPath: '../images/jia.png',
      position: {
        left: 340,
        top: 100 - 50,
        width: 20,
        height: 20
      },
      clickable: true
    }
    ],
    circles: []

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

  onLoad: function () {
    var _this = this;

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

          url: 'http://123.206.42.162:10001/printer/nearby',
          header: {
            'X-ACCESS-TOKEN': null,
          },
          data: {
            longitude: a,
            latitude: b
          },
          method: 'GET',
          success: function (aa) {
            //var that=this;
            //console.log(aa);
            //markers解决
            var _mapMarkers = [],
                _markPoints = [];
            for (var i = 0; i < aa.data.data.length; i++) {

              _markPoints.push({
                latitude: aa.data.data[i].longitude,
                longitude: aa.data.data[i].latitude
              });
              
              _mapMarkers.push({
                id: i+1,
                latitude: aa.data.data[i].longitude,
                longitude: aa.data.data[i].latitude,
                title: aa.data.data[i].name,
                width: 40,
                height: 40,
                iconPath: "../images/my.png"
              })

            }

            console.log(_mapMarkers)

            _this.setData({
              latitude: res.latitude,
              longitude: res.longitude,
              markers: _mapMarkers,
              markPoints: _markPoints,
              

            })

            console.log(_this.data.markers)

            
            
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

  onReady: function(e){
    this.mapCtx = wx.createMapContext('map')
  }


})