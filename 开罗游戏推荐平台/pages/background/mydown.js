// pages/background/mydown.js
var app = getApp();
Page({
	data: {
		downfileList: [],//点击了下载的游戏对象列表
		//游戏对象：{id-游戏ID，title-游戏名，iconImg-游戏图标}
	},
	onLoad: function(){	//获取已下载游戏列表
		this.setData({
			downfileList: app.globalData.downfileList,
		})
	},
	getGame: function(e){	//跳转游戏详细页
		var gameId = this.data.downfileList[e.currentTarget.dataset.id].id;
    wx.navigateTo({
      url: '../games/games?id='+gameId,
    })
  },
})