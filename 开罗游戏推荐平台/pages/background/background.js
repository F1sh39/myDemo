// pages/background/background.js
var app = getApp();
Page({
  data: {
    userInfo: { avatarUrl: '',  nickName: '', },
    //{}用户信息：用户头像，用户名
  },
  onLoad: function(){ //获取用户信息
    if(app.globalData.userInfo){  //调用app.js的数据和功能需在头部 `var app = getApp();`
      this.setData({
        userInfo: app.globalData.userInfo,
      })
    }else{
      app.userInfoReadyCallback = res => {
        getApp().globalData.userInfo = res.userInfo;
        this.setData({
          userInfo: res.userInfo,
        })
      }
    }
  },
  getUserInfo: function(e){ //获取授权
    if(e.detail.userInfo){
      this.setData({
        userInfo: e.detail.userInfo
      })
    }
    app.globalData.userInfo = this.data.userInfo; //反向存储于公共数据中
  },
  goDown: function(e){  //跳转mydown页面
    wx.navigateTo({
      url: '../background/mydown',  //本处跳转页面需要在app.json的pages中注册
    })
  },
})