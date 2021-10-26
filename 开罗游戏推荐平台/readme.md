# 开罗游戏推荐
### 项目介绍  
练手微信小程序前端开发项目。  
设计时了解市场前端设计出色的应用和网站，如taptap，微信游戏等  
实现中注重可拓展性和交互性  
- 可拓展性：在wxml上设计组件模板，在js上添加对应数据，实现模板与数据的对接；大量使用scroll-view组件，页面拥有无限拓展性
- 交互性：绑定多数可触碰的组件，拥有页面跳转，介绍图放大，打分，写评论等交互
#### 产品预览图
- 左图为好游推荐页面，中图为游戏分类页面，右图为游戏详情页面

[![55oEGV.png](https://z3.ax1x.com/2021/10/26/55oEGV.png)](https://imgtu.com/i/55oEGV)
#### 产品功能图
[![55hZBn.png](https://z3.ax1x.com/2021/10/26/55hZBn.png)](https://imgtu.com/i/55hZBn)
#### 产品活动图
[![55o5iq.png](https://z3.ax1x.com/2021/10/26/55o5iq.png)](https://imgtu.com/i/55o5iq)
#### 数据结构(字典)
##### 全局界面
+ globalData

|name|type|default|remark|
|-|-|-|-|
|userInfo|object|null|授权后获取的用户信息|
|downfileList|array|-|点击了下载的简略游戏对象列表|
+ simpleGame(简略游戏对象)

|name|type|default|remark|
|-|-|-|-|
|id|int|-|游戏id|
|title|string|-|游戏名|
|iconImg|string|-|游戏图标url|

+ index(游戏推荐与游戏分类界面)

|name|type|default|remark|
|-|-|-|-|
|item|int|0|顶部导航栏页数|
|tab|int|0|顶部导航栏页数|
|tabList|array|-|游戏分类列表参数|
|typeTab|int|0|分类导航栏页数|
|GameList|array|-|游戏对象列表|

+ introduceGame(推荐游戏对象)

|name|type|default|remark|
|-|-|-|-|
|id|int|-|游戏id|
|title|string|-|游戏名|
|introduction|string|-|游戏推荐语句|
|mainImg|string|-|游戏主要大图url|
|iconImg|string|-|游戏图标url|
|tag|array|-|游戏分类标签|
|isShow|boolean|false|分类页面是否展示|

+ userInfo(用户信息)

|name|type|default|remark|
|-|-|-|-|
|avatarUrl|string|-|用户头像url|
|nickName|string|-|用户名|

+ game(游戏详细页)

|name|type|default|remark|
|-|-|-|-|
|userInfo|object|-|用户信息|
|Game|object|-|当前游戏信息对象|
|GameList|array|-|详细游戏对象列表|

+ 当前游戏信息对象

|name|type|default|remark|
|-|-|-|-|
|id|int|-|游戏id|
|title|string|-|游戏名|
|iconImg|string|-|游戏图标url|
|gameImgs|array|-|游戏详细图列表|
|introduction|string|-|游戏介绍|
|itd_open|boolean|false|游戏介绍是否展开|
|star|int|-1|打星数量|
|starImg|array|-|星星图片列表|
|comments|array|-|评论对象列表
|haveComment|boolean|false|是否有评论|

+ 评论对象

|name|type|default|remark|
|-|-|-|-|
|headimg|string|-|用户头像url|
|nickName|string|-|用户名|
|commentText|string|-|评论文本|

+ 详细游戏对象

|name|type|default|remark|
|-|-|-|-|
|id|int|-|游戏id|
|title|string|-|游戏名|
|iconImg|string|-|游戏图标url|
|gameImgs|array|-|游戏详细图列表|
|introduction|string|-|游戏介绍|
|comments|array|-|评论对象列表

#### 改进方向
+ 数据结构设计  
    页面数据结构重复设计，应设计得更合理
+ 后端的实现  
    搭建数据库并启动服务器连接
+ 更多的功能：  
    面向游戏开发者，评论回复，游戏社区等面向搭建游戏社区的点子
