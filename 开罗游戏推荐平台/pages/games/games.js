// pages/games/games.js
var app = getApp();
Page({
	data: {
		userInfo: { avatarUrl: '',  nickName: '', },	//{}用户信息
		Game: {	//{}当前游戏信息
			id: -1,	title: '',	//游戏id，游戏标题
			iconImg: '',	//游戏图标
			gameImgs: [],	//[]游戏详细图列表
			introduction: '',	//游戏介绍-大段
			itd_open: false,	//游戏介绍是否展开
			star: -1,	//亮星数量
			starImg: ['','','','',''],	//[]星星图片列表
			comments: [],	//[]评论对象列表，{}评论对象，{headimg头像，nickname用户名，commentText评论文本}
			haveComment: false,	//是否有评论
		},
		GameList: [{	//[]游戏对象列表，{}游戏对象
			id:0, title:'舌尖上的美食梦', //游戏id，游戏标题
			iconImg: 'http://www.kairogame.cn/Uploads/Picture/2018-12-05/5c07ae02a6183.jpg',	//游戏图标
			gameImgs: ['http://www.kairogame.cn/Uploads/Picture/2018-12-05/5c07ae19bc667.jpg', //[]游戏详细图列表
				'http://www.kairogame.cn/Uploads/Picture/2018-12-05/5c07ae24d3c32.jpg', 
				'http://www.kairogame.cn/Uploads/Picture/2018-12-05/5c07ae25049f9.jpg', 
				'http://www.kairogame.cn/Uploads/Picture/2018-12-05/5c07ae2534100.jpg', 
				'http://www.kairogame.cn/Uploads/Picture/2018-12-05/5c07ae2561f8c.jpg',],		//↓ ↓ ↓游戏介绍-大段
			introduction: '煎炒烹炸焖溜熬炖，柴米油盐中传承灿烂文明。 川鲁粤苏浙闽湘徽，一日三餐里展现广袤中华。 《舌尖上的美食梦》为各位玩家营造了一个中华美食乐园，玩家在游戏中经营一家中餐馆，研究食谱、烹饪技术和探索各种食材，建立自己的五星级技术团队，努力挖掘新鲜美食，探索中华美食文化。 游戏里汇集了多达20个传统菜系的近百道著名中华美食和同样丰富的食材。由此衍生出的超多美食组合足够玩家充分放飞想象，领略真正的中华美食文化。',
			comments: [],	//[]评论对象列表，{}评论对象
		},{
			id:1, title:'创意糕点铺', 
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm91.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm91/img_05.png', 
				'http://kairosoft.net/game/shared/image/gm91/img_01.png', 
				'http://kairosoft.net/game/shared/image/gm91/img_02.png',  
				'http://kairosoft.net/game/shared/image/gm91/img_03.png',  
				'http://kairosoft.net/game/shared/image/gm91/img_04.png',],
			introduction: '《创意蛋糕店》的游戏中，玩家需要经营一家属于自己的甜品店。亲自下厨，制作独属于自己的特色甜品，玩家需要不断的制作甜品提高食材的属性，并且摸索各种类型蛋糕的配方。玩家在享受烘焙甜品的快乐时，同时需要为自己甜品店的发展贡献出力，培养员工、更换进货区域获取品质更高的食材，让自己的甜品店良好的发展下去。只有制作出一级棒的蛋糕才能在大赛上斩获冠军，为了让自己制作的蛋糕变得人人都爱而加油吧！',
			comments: [],
		},{
			id:2, title:'口袋学院物语2', 
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm29.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm29/img_07.png',
				'http://kairosoft.net/game/shared/image/gm29/img_03.png',
				'http://kairosoft.net/game/shared/image/gm29/img_02.png',
				'http://kairosoft.net/game/shared/image/gm29/img_01.png',
				'http://kairosoft.net/game/shared/image/gm29/img_05.png',
				'http://kairosoft.net/game/shared/image/gm29/img_04.png',
			],
			introduction: '《口袋学院物语2》一款经营学校的模拟游戏。玩家需要合理建立各种设施、提高教师水平，以培养出德智体美全方面优秀的学生为目标，最后打造名门学院。游戏十分贴合现实的日本学校教育，学校除了会举办一些球队邀请赛、艺术欣赏课及课题挑战之外，在校的学生也可以参加校外演出、培育动物等课外活动，这才是真正的学习啊! 赶快来《口袋学院物语2》中，体验你未经历的青春吧！',
			comments: [],
		},{
			id:3, title:'游戏开发物语', 
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm8.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm8/img_07.png',
				'http://kairosoft.net/game/shared/image/gm8/img_05.png',
				'http://kairosoft.net/game/shared/image/gm8/img_04.png',
				'http://kairosoft.net/game/shared/image/gm8/img_02.png',
			],
			introduction: '经营游戏公司，达成百万人气。 这是大幅强化后的升级版，新增了在自己公司内部开发游戏机的功能以及转职系统。 找寻优秀职员并对他们进行培养吧！培养公司职员后，可开发的游戏种类和内容会变多。 探寻人气组合，在新型主机上进行发售吧！ 不仅如此，程序员和音乐制作等与游戏相关的职业系统也将登场。 争取成为游戏界的霸者吧',
			comments: [],
		},{
			id:4, title:'温泉物语2', 
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm136.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm136/img_06.png',
				'http://kairosoft.net/game/shared/image/gm136/img_01.png',
				'http://kairosoft.net/game/shared/image/gm136/img_04.png',
				'http://kairosoft.net/game/shared/image/gm136/img_03.png',
				'http://kairosoft.net/game/shared/image/gm136/img_05.png',
			],
			introduction: '非凡温泉造就嫩滑肌肤，这是一款打造舒适温泉旅馆的游戏。 自由配置小卖部、食堂和游戏室等各种设施来打造人气旅馆吧。还能种植梅树和八仙花等植物来挑战一下优美的日式庭园。以指南书榜首为目标，成为能够吸引偶像、小说家以及其他贵宾的温泉之乡吧。 最重要的是真诚待客和用心服务的精神',
			comments: [],
		},{
			id:5, title:'大航海探险物语', 
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm100.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm100/img_08.png',
				'http://kairosoft.net/game/shared/image/gm100/img_07.png',
				'http://kairosoft.net/game/shared/image/gm100/img_04.png',
				'http://kairosoft.net/game/shared/image/gm100/img_03.png',
			],
			introduction: '三年前的那天... 怀着梦想、浪漫和一点焦虑，我决定成为传奇的海盗。我们在酒吧里找到了一个同伴，在一家军火商店里找了一把刀。 在国王给我的一艘大帆船上... 现在，这是航行的开始！！当我们继续航行时，我们从未见过的怪物和邪恶的海盗阻止了我们前进。 然而，在与勇敢的同伴们一起努力，我们终于赢了，我们成功地赢得了许多宝藏。当战斗中的食物被给予同伴时，我们惊人的力量都进化成强大的大海盗。',
			comments: [],
		},{
			id:6, title:'住宅梦物语',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm85.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm85/img_08.png',
				'http://kairosoft.net/game/shared/image/gm85/img_01.png',
				'http://kairosoft.net/game/shared/image/gm85/img_02.png',
				'http://kairosoft.net/game/shared/image/gm85/img_05.png',
				'http://kairosoft.net/game/shared/image/gm85/img_07.png',
			],
			introduction: '《住宅梦物语》不是简单的放置装饰类游戏,既沿袭了开罗游戏经典的模拟经营玩法，还添加了养成特色。 游戏中玩家掌握绝对的主动权，决定募集来的租客居住在公寓的哪个房间，帮助他们选择喜欢的职业，应对花样的挑战，助力他们达成就职、结婚、生子等人生重要目标。 偷偷告诉你，还可以把最爱的家人和最好的朋友都安排到温馨的公寓里，每天醒来最好的朋友就在身边，喜欢的人就在对面！',
			comments: [],
		},{
			id:7, title:'合战忍者村',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm70.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm70/img_05.png',
				'http://kairosoft.net/game/shared/image/gm70/img_01.png',
				'http://kairosoft.net/game/shared/image/gm70/img_03.png',
				'http://kairosoft.net/game/shared/image/gm70/img_02.png',
			],
			introduction: '《合战忍者村物语》是一款日式风格的模拟经营手游。玩家可以在游戏中感受日本颇负盛名的忍者文化。游戏为玩家们提供了数十个不同属性的人物，玩家可以自由选择和搭配。一边经营自己的村庄，一边招募自己心仪的忍者。与其他忍者部族进行战斗，最终击败敌人，一统天下 ！',
			comments: [],
		},{
			id:8, title:'冠军足球物语2',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm97.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm97/img_07.png',
				'http://kairosoft.net/game/shared/image/gm97/img_01.png',
				'http://kairosoft.net/game/shared/image/gm97/img_04.png',
				'http://kairosoft.net/game/shared/image/gm97/img_05.png',
				'http://kairosoft.net/game/shared/image/gm97/img_03.png',	
			],
			introduction: '《冠军足球物语2》不仅是一款模拟经营游戏。玩家作为球队经理经营梦之足球队。通过对足球选手的挖掘和培养，去成为世界豪门球队，站到世界顶峰。 除了经营梦之队，游戏还增加了许多球队和要素，包括球员特殊技能、比赛犯规、雨中比赛和雪中比赛等。玩家还可以和朋友一起互动，进行联机对战。 《冠2》更是一款像素系列足球经营游戏，虽然它看似小巧，但是内容却非常丰富，对于现实足球队所遇到的事情都能面面俱到。游戏中我们要作为经理人和教练两个职位，除了培养球员、锻炼队伍之外，还需要寻找合适的赞助商、比赛挑战等等，让玩家们能亲自体验经营一家足球俱乐部的辛苦与满足。',
			comments: [],
		},{
			id:'9', title: '冲击，GP大奖赛',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm132.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm132/img_06.png',
				'http://kairosoft.net/game/shared/image/gm132/img_01.png',
				'http://kairosoft.net/game/shared/image/gm132/img_02.png',
				'http://kairosoft.net/game/shared/image/gm132/img_03.png',
				'http://kairosoft.net/game/shared/image/gm132/img_05.png',
				'http://kairosoft.net/game/shared/image/gm132/img_04.png',	
			],
			introduction: '《冲击，GP大奖赛》让你在像素赛车的世界自由冲刺，用最快的速度来赢取冠军，成为世界上最有名的赛车经理，车队的构建需要你去完成，现在就来试试吧！ 开罗《冲击，GP大奖赛》需要用你的特色来经营你所梦寐以求的车队吧！成为车队老板，通过培养车手以及拉拢赞助商来称霸大奖赛。玩家们还能进行赛车的制造，对赛车进行改进，随意强化部件并自由进行组装！',
			comments: [],
		},{
			id:10, title: '海鲜寿司街',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm58.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm58/img_05.png',
				'http://kairosoft.net/game/shared/image/gm58/img_02.png',
				'http://kairosoft.net/game/shared/image/gm58/img_04.png',
				'http://kairosoft.net/game/shared/image/gm58/img_03.png',	
			],
			introduction: '《海鲜寿司街》是一款还原回转寿司店铺内容的经营模拟类游戏。在这款模拟经营游戏中，你需要经营管理自己的寿司店，修建回转座席，招募寿司师傅并尝试研发组合出各种美味的料理。游戏需要合理规划店内格局，招聘并培育料理人才，宣传店铺吸引食客，自主研发品牌寿司，目标成为称霸各种竞赛、评级名列前茅的优秀寿司店。《海鲜寿司街》有着很高的游戏自由度，真实还原超过50种食材，玩家可以通过自有组合食材创作自己的风味寿司料理，并依靠这些美味的寿司参与竞赛赢取奖励，打造品牌寿司店。',
			comments: [],
		},{
			id:11, title: '星之开罗君',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm49.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm49/img_07.png',
				'http://kairosoft.net/game/shared/image/gm49/img_01.png',
				'http://kairosoft.net/game/shared/image/gm49/img_02.png',
				'http://kairosoft.net/game/shared/image/gm49/img_03.png',	
				'http://kairosoft.net/game/shared/image/gm49/img_05.png',
			],
			introduction: '《星之开罗君》是一款以拓荒星球为主题的模拟经营游戏。通过量产名为开罗君的机器人，辗转于各个星球间。作为宇宙的警备队，在充实开罗君居所的同时，到各个星球展开巡视以确保行星的安全。随着宇宙信赖度和友好度的提升，前往新的星球。最终找出并打败邪恶的幕后黑手歪罗王，去实现各地的和平吧。',
			comments: [],
		},{
			id:12, title: '邮轮大纪行',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm40.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm40/img_07.png',
				'http://kairosoft.net/game/shared/image/gm40/img_03.png',
				'http://kairosoft.net/game/shared/image/gm40/img_04.png',
				'http://kairosoft.net/game/shared/image/gm40/img_02.png',	
				'http://kairosoft.net/game/shared/image/gm40/img_01.png',
			],
			introduction: '《邮轮大纪行》是一款开罗游戏推出的模拟经营玩法手游。游戏中，玩家通过建造客房、气泡按摩浴缸、俱乐部、餐厅等设施并举办人气环游旅行，而顾客的满意度会根据设施之间的契合度以及道具而不断上升!如果能令每半年来一次的审查人员满意的话就能获得五角星。说不定还可以邀请到名人前来做客哟！自由设计船上的布局，打造一艘奢华亮丽的客轮。邀请世界名人吧!向着世界各国首脑都为之赞叹的五星级大游轮进发!',
			comments: [],
		},{
			id:13, title: '箱庭小镇',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm92.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm92/img_07.png',
				'http://kairosoft.net/game/shared/image/gm92/img_01.png',
				'http://kairosoft.net/game/shared/image/gm92/img_03.png',
				'http://kairosoft.net/game/shared/image/gm92/img_05.png',	
				'http://kairosoft.net/game/shared/image/gm92/img_06.png',
			],
			introduction: '《箱庭小镇》作为一款像素类模拟经营游戏，简单的游戏操作，刚开始也会有非常详细的新手教程，模拟经营类的游戏，主要考验的是头脑的策略能力，而动手方面只需一根手指，便能轻松玩转全场，在其中，我们可以自由的搭建住宅或者商店，不断的扩展土地，打造出属于自己的商业街，与此同时，土地价格也会随之增长，小小市民们在你这座小城中生活，更有趣的是还能购买萌宠和交通工具哟。',
			comments: [],
		},{
			id:14, title: '动画制作物语',
			iconImg: 'http://kairosoft.net/game/shared/app_icon/gm129.png',
			gameImgs: ['http://kairosoft.net/game/shared/image/gm129/img_04.png',
				'http://kairosoft.net/game/shared/image/gm129/img_01.png',
				'http://kairosoft.net/game/shared/image/gm129/img_02.png',
				'http://kairosoft.net/game/shared/image/gm129/img_03.png',	
				'http://kairosoft.net/game/shared/image/gm129/img_05.png',
			],
			introduction: '《动画制作物语》是一款经营动画工作室的模拟经营类游戏。在游戏中，玩家需要制作人气动漫，主要目标是制作人气动漫，培育自己的主人公。选择脸部和身体的造型后便可拥有独创的主人公角色！不断让角色在动画中出场，争取在“人气动画排名”的“最想成为恋人排名”和“最受儿童欢迎排名”中获得好成绩吧。跟随动画制作物语，为工作室带来荣耀!',
			comments: [],
		}],
	},
	onLoad: function (options) {	//获取处理跳转页面的传值，传入值(options)为页面传值
		this.data.Game.id = options.id;	//获取跳转页面传入的游戏id
		if(app.globalData.userInfo){  //登陆st
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
		}	//登陆end
	},
	onReady: function(){	//加载页面内容，并检查
		this.setGame(this.data.Game.id);
		this.setStar(this.data.Game.star);
		this.setComment();
		console.log(this.data.Game);	//检查是否加载正确游戏内容
		console.log(this.data.userInfo.nickName);	//检查登陆情况
		console.log(this.data.Game.comments);	//检查评论板块是否填装
	},
	setGame: function(x){	//加载游戏介绍内容
		var game = this.data.GameList[x];
		this.setData({		
			'Game.id': x,
			'Game.title': game.title,
			'Game.iconImg': game.iconImg,
			'Game.gameImgs': game.gameImgs,	//浅拷贝
			'Game.introduction': '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+game.introduction.slice(0,35?35:11)+'...🔽',
			'Game.comments': game.comments,
		})
	},
	getUserInfo: function(e){	//获取登陆信息
    if(e.detail.userInfo){
      this.setData({
        userInfo: e.detail.userInfo
      })
		}
		app.globalData.userInfo = this.data.userInfo;	//反向存储于公共数据中
  },
	setComment: function(){	//加载评论列表模块
		if(this.data.Game.comments.length>0){
			this.setData({
				'Game.haveComment': true,
			})
		}
	},
	downFile: function(){	//下载应用处理	1应用登记 2下载
		//1登记
		var temp = {
			id:-1, title: '',
			iconImg: '',
		}
		temp.id = this.data.Game.id;
		temp.title = this.data.Game.title;
		temp.iconImg = this.data.Game.iconImg;
		app.globalData.downfileList.push(temp);
		console.log(app.globalData.downfileList);
		//2下载
		wx.showLoading({
			title: '下载中...',
			//mask: true,	//原本应关闭所有按键，但本小程序无法正常下载，由此取消关闭按键功能
		})
		wx.downloadFile({
			url: '',	//此处无法直接引用外网资源，需配置相关服务器资源的地址
			success: res => {
				wx.hideLoading();
				console.log('下载成功');
			}
		})
	},
	clickImg: function(e){	//放大图片
		var index = e.currentTarget.dataset.id;
		wx.previewImage({
			urls: this.data.Game.gameImgs, //需要预览的图片http链接列表，注意是数组
			current: this.data.Game.gameImgs[index], // 当前显示图片的http链接
		})	
	},
	itd_fold: function(){	//文字介绍缩放
		var e = this.data.Game;
		if(e.itd_open){	
			this.setData({
				'Game.introduction': '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+this.data.GameList[e.id].introduction.slice(0,35?35:11)+'...'+'🔽',
			})		
		}else{
			this.setData({
				'Game.introduction': '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+this.data.GameList[e.id].introduction+'\n🔼',
			})
		}
		e.itd_open = !e.itd_open;
	},
	getStar: function(e){	//打星
		var index = e.currentTarget.dataset.id;
		this.setStar(index);
	},
	setStar: function(star){	//显示星星数
		var i = 0;	//0-4分为5颗星，-1为默认无星
		var tempImg = [];
		for(; i<=star; i++){	//先打实星
				tempImg[i] = 'http://www.shejiye.com/uploadfile/icon/2017/0203/shejiyeiconyhdzmteuzl1.png';
		}
		for(; i<=4; i++){
				tempImg[i] = 'http://www.shejiye.com/uploadfile/icon/2017/0203/shejiyeiconcueogvm2ttd.png';
		}
		this.setData({
			'Game.starImg': tempImg,
		})
	},
	commentSubmit: function(e){	//表单提交，并更新评论列表板块
		console.log(e.detail.value);
		this.data.GameList[this.data.Game.id].comments.push(e.detail.value);
		this.setData({
			'Game.comments': this.data.GameList[this.data.Game.id].comments,
		})
		console.log(this.data.Game.comments);
		this.setComment();	//开放评论区
	}
})