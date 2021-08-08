## 案例

项目结构：
[![flZRwd.png](https://z3.ax1x.com/2021/08/08/flZRwd.png)](https://imgtu.com/i/flZRwd)

### 需求1：用户列表页面
步骤：
1设计页面userlist.jsp
2环境搭建
	1搭建数据库及表mydb_webuser
	2搭建项目结构
3编程
	1写User类
	2写userlist.jsp页面
	3写UserlistServlet类
		1调用servlet完成查询
		2将查询结果存入req域
		3转发list.jsp
	4写UserService接口和其~impl实现类
		调用dao方法
	5写UserDao接口和其实现类
		1导入配置pro和druid工具类
		2写查询所有用户的方法：findAlluser()
	6为ul.jsp页面填入动态数据


问题：
1数据域，session>request
2el和jstl的结合使用，动态获取数据的参数需要el来写

### 需求2：管理员登陆
步骤：
1设计页面login.jsp
2数据库：
	在上表基础上新增2个字段
3编程
	1写LoginServlet类
		1检查验证码
		2调用service查询用户是否存在
		3信息正确则跳转首页，
		 信息错误则转发回登陆页面
	2service调用dao的方法
	3写dao查询用户的方法：findUserbyUNandPW(name,psw)
	
问题
1虚拟路径的填写，转发不填，其他情况要填
2注重项目结构

### 需求3：新增用户
1设计页面adduser.jsp
2编程
	1写AdduserServlet类
		1接收注册表单信息
		2打包成User对象
		3调用service方法转存到数据库
		4name和email字段空则返回新增页面并提示
		 否则将数据打包成对象存入数据库
	2service调用dao方法
	3写Dao的新增用户的方法：Adduser(user)
	
问题：
1注重dao方法设计合理
2主页表单空转发`''`值，导致非空填值

### 需求4：删除单条用户
1绑定按钮
2编程
	1写DeluserServlet类
		1获取当条信息的用户id
		2调用service
		3返回用户列表页面
	2service调用dao方法
	3写Dao的删除用户方法：Deluser(id)
细节
	删除前弹框防误删
		js弹确认框，确认再跳转Servlet
问题：
	1js绑定方法后跳转失败
	js里`location.href="/url"`是当前页面跳转url。是小写l！

### 需求5：修改单条用户信息
1修改用户页面信息显示
	1绑定按钮，跳转到updateuser.jsp
	2编程
		1写finduserbyidServlet类
			1获取对应id
			2调用service
			3req存入user，转发到updateuser.jsp
		2service调用dao方法
		3写Dao的按id查找用户方法：findUserbyId(id)
2更新用户信息
	1提交表单，跳转到updateuserServlet类
	2写updateuserServlet类
		1调用service
		2重定向到userlist.jsp
	3service调用dao方法
	4写Dao的按id修改用户方法

需求6：删除多条用户信息
步骤
	1收集被选择的用户id
	2写selectedSerlet类
		1获取id列表
		2调用service
		3返回用户列表页面
	3service调用Dao的delUser()方法
细节：
	1最顶选择框控制全选全不选
		js绑定控制子选框
	2删除前弹框防止误删

### 需求7：分页功能
步骤：
	1设计PageBean
		服务器端参数
			查询总数
			总页码
			当前应展示行的列表
		客户端参数
			一页行数
			当前页
	2页数page关联用户列表userlist
		初次进入
			新增page对象，传入每页最大行数
		切换页数后
			传入切换到的页数，获取page对象
		查询limit行数的数据，并打包userlist
	3service与Dao
		1service调用dao的方法
		2Dao写查询限定行数的用户列表方法：findRows()
	4前端分页组件动态绑定

### 需求8：多条件组合查询
步骤：
	1设计查询表单，get，绑定servlet
	2写finduserbyformServlet
		1获取表单数据
		2调用service
		3转发page到userlist.jsp
	3service调用Dao
	4Dao写按表单参数查询用户列表方法：finduserbyform()
问题：
1sql语句要严谨，该空格就空格，该符号就符号，
同时template传入的参数有区分字符串形式和数字形式，要避免数字形式传入成字符串形式无法识别
2userlist的功能复用，要设计好初始全部查询和条件查询的方法结合
