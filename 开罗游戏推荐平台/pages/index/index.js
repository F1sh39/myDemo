// index.js
Page({
  data: {
    item: 0, tab: 0,  //标记顶部导航栏
    tabList: ['全部🎮','美食🍴','运动🏃‍♂️','经营🏡','冒险🥊'],  //游戏分类列表
    typeTab: 0, //标记分类导航栏
    GameList: [{  //[]游戏对象列表，{}游戏对象
      id:0, title: '舌尖上的美食梦',  //游戏id，游戏名
      introduction: '让我们做一家受欢迎的餐厅🍚\n以五星级食堂为名。', //游戏引导句
      mainImg: 'http://www.kairogame.cn/Uploads/Picture/2018-12-05/5c07b2238f4d6.jpg',  //游戏主要大图
      iconImg: 'http://www.kairogame.cn/Uploads/Picture/2018-12-05/5c07ae02a6183.jpg',  //游戏图标
      tag: ['美食🍴','经营🏡'],  isShow: true,  //[]游戏分类，分类页面是否展示
    },{
      id:1, title: '创意蛋糕店',
      introduction: '让我们创造甜品吧🍰',
      mainImg: 'http://kairosoft.net/game/shared/image/gm91/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm91.png',
      tag: ['美食🍴'],  isShow: true,
    },{
      id:2, title: '口袋物语学院2',
      introduction: '体验未经历的青春吧！🎊',
      mainImg: 'http://kairosoft.net/game/shared/image/gm29/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm29.png',
      tag: ['运动🏃‍♂️'],  isShow: true,
    },{
      id:3, title: '游戏开发物语',
      introduction: '所有喜欢游戏的人都值得尝试的作品🎮',
      mainImg: 'http://kairosoft.net/game/shared/image/gm8/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm8.png',
      tag: ['经营🏡'],  isShow: true,
    },{
      id:4, title: '温泉物语2',
      introduction: '梦之小旅馆🍵 充满温泉气',
      mainImg: 'http://kairosoft.net/game/shared/image/gm136/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm136.png',
      tag: ['经营🏡'],  isShow: true,
    },{
      id:5, title: '大航海探险物语',
      introduction: '成为海的男人🚤',
      mainImg: 'http://kairosoft.net/game/shared/image/gm100/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm100.png',
      tag: ['冒险🥊'],  isShow: true,
    },{
      id:6, title: '住宅梦物语',
      introduction: '建造一个受欢迎的公寓🏘',
      mainImg: 'http://kairosoft.net/game/shared/image/gm85/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm85.png',
      tag: ['经营🏡'],  isShow: true,
    },{
      id:7, title: '合战忍者村',
      introduction: '世界已陷入混乱，忍者团结战斗🛡',
      mainImg: 'http://kairosoft.net/game/shared/image/gm70/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm70.png',
      tag: ['冒险🥊'],  isShow: true,
    },{
      id:8, title: '冠军足球物语2',
      introduction: '带领球员，踢进世界杯⚽',
      mainImg: 'http://kairosoft.net/game/shared/image/gm97/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm97.png',
      tag: ['运动🏃‍♂️'],  isShow: true,
    },{
      id:9, title: '冲击，GP大奖赛',
      introduction: '驾驶完美赛车，拿下大奖赛🏎',
      mainImg: 'http://kairosoft.net/game/shared/image/gm132/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm132.png',
      tag: ['运动🏃‍♂️'],  isShow: true,
    },{
      id:10, title: '海鲜寿司街',
      introduction: '驾驶完美赛车，拿下大奖赛🏎',
      mainImg: 'http://kairosoft.net/game/shared/image/gm58/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm58.png',
      tag: ['美食🍴'],  isShow: true,
    },{
      id:11, title: '星之开罗君',
      introduction: '发展开罗文明，保卫美好宇宙🌌',
      mainImg: 'http://kairosoft.net/game/shared/image/gm49/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm49.png',
      tag: ['冒险🥊'],  isShow: true,
    },{
      id:12, title: '邮轮大纪行',
      introduction: '超人气邮轮，环游世界🚢',
      mainImg: 'http://kairosoft.net/game/shared/image/gm40/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm40.png',
      tag: ['经营🏡'],  isShow: true,
    },{
      id:13, title: '箱庭小镇',
      introduction: '创造一个城市，\n每个人都可以幸福地生活🏙',
      mainImg: 'http://kairosoft.net/game/shared/image/gm92/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm92.png',
      tag: ['经营🏡'],  isShow: true,
    },{
      id:14, title: '动画制作物语',
      introduction: '一个通过想象力实现梦想和情感的世界🎞',
      mainImg: 'http://kairosoft.net/game/shared/image/gm129/top.png',
      iconImg: 'http://kairosoft.net/game/shared/app_icon/gm129.png',
      tag: ['经营🏡'],  isShow: true,
    }],
  },
  changeItem: function(e) { //点击切换标签栏
    this.setData({
      item: e.target.dataset.item,
    })
  },
  changeTab: function(e) {  //滑动切换标签栏
    this.setData({
      tab: e.detail.current,
    })
  },
  changeType: function(e){  //切换分类栏
    this.setData({
      typeTab: e.target.dataset.type,
    })
    this.resetTypeGameList(e.target.dataset.type);
  },
  getGame: function(e){ //跳转游戏详细页
    var gameId = this.data.GameList[e.currentTarget.dataset.id].id;
    console.log(gameId); //检查跳转传值是否正确
    wx.navigateTo({
      url: '../games/games?id='+gameId,
    })    
  },
  resetTypeGameList: function(type){  //修改切换分类后游戏的列表，传入tabList的索引
    var nowtag = this.data.tabList[type];
    var glist = this.data.GameList;
    for(var i=0; i<glist.length; ++i){
      var nowgame = glist[i];
      var ngShow = 'GameList['+i+'].isShow';  //对于setData()参数接收 键值对，路径中有变量需用[]号
      if( (nowgame.tag[0] == nowtag) || (type==0) ){
        this.setData({  [ngShow]:true  });
      }else{
        this.setData({  [ngShow]:false });
      }    
    }
  }
})
