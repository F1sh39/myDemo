// app.js
App({
	globalData:{
		userInfo: null,	//授权后获取的用户信息
		downfileList: [],	//点击了下载的游戏对象列表
										//游戏对象：{id-游戏ID，title-游戏名，iconImg-游戏图标}
	},
	onLaunch: function(e){	//小程序启动时检查是否授权
		wx.getSetting({
			success: res=> {
				if (res.authSetting['scope.address.userInfo']){
					wx.getUserInfo({
						success: res=> {
							this.globalData.userInfo = res.userInfo;
						}
					})
				}
			}
		})
		
		wx.getUserInfo({
			success: res => {
				this.globalData.userInfo = res.userInfo;
				if(this.userInfoReadyCallback){
					this.userInfoReadyCallback(res);
				}
			}
		})
	},
})