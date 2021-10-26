## 案例

### 项目结构：  

[![flZRwd.png](https://z3.ax1x.com/2021/08/08/flZRwd.png)](https://imgtu.com/i/flZRwd)

### 需求1：用户列表页面
+ 步骤：
    1. 设计页面userlist.jsp
    2. 环境搭建
        1. 搭建数据库及表mydb_webuser
        2. 搭建项目结构
    3. 编程
        1. 写User类
        2. 写userlist.jsp页面
        3. 写UserlistServlet类
            1. 调用servlet完成查询
            2. 将查询结果存入req域
            3. 转发list.jsp
        4. 写UserService接口和其~impl实现类  
            1. 调用dao方法
        5. 写UserDao接口和其实现类
            1. 导入配置pro和druid工具类
            2. 写查询所有用户的方法：`findAlluser()`
        6. 为ul.jsp页面填入动态数据
+ 问题：
    - 数据域，session>request
    - el和jstl的结合使用，动态获取数据的参数需要el来写

### 需求2：管理员登陆
+ 步骤：
    1. 设计页面login.jsp
    2. 数据库：  
        在上表基础上新增2个字段
    3. 编程
        1. 写LoginServlet类
            1. 检查验证码
            2. 调用service查询用户是否存在
            3. 信息正确则跳转首页，信息错误则转发回登陆页面
        2. service调用dao的方法
        3. 写dao查询用户的方法：`findUserbyUNandPW(name,psw)`
+ 问题
    - 虚拟路径的填写，转发不填，其他情况要填
    - 注重项目结构

### 需求3：新增用户
+ 步骤：
    1. 设计页面adduser.jsp
    2. 编程
        1. 写AdduserServlet类
            1. 接收注册表单信息
            2. 打包成User对象
            3. 调用service方法转存到数据库
            4. name和email字段空则返回新增页面并提示，否则将数据打包成对象存入数据库
        2.service调用dao方法
        3. 写Dao的新增用户的方法：Adduser(user)	
+ 问题：
    - 注重dao方法设计合理
    - 主页表单空转发`''`值，导致非空填值

### 需求4：删除单条用户
+ 步骤：
    1. 绑定按钮
    2. 编程
        1. 写DeluserServlet类
            1. 获取当条信息的用户id
            2. 调用service
            3. 返回用户列表页面
        2. service调用dao方法
        3. 写Dao的删除用户方法：Deluser(id)
+ 细节
	- 删除前弹框防误删  
		js弹确认框，确认再跳转Servlet
+ 问题：
	- js绑定方法后跳转失败  
	    js里`location.href="/url"`是当前页面跳转url。是小写l！

### 需求5：修改单条用户信息
+ 步骤
    1. 修改用户页面信息显示
        1. 绑定按钮，跳转到updateuser.jsp
        2. 编程
            1. 写finduserbyidServlet类
                1. 获取对应id
                2. 调用service
                3. req存入user，转发到updateuser.jsp
            2. service调用dao方法
            3. 写Dao的按id查找用户方法：findUserbyId(id)
    2. 更新用户信息
        1. 提交表单，跳转到updateuserServlet类
        2. 写updateuserServlet类
            1. 调用service
            2. 重定向到userlist.jsp
        3. service调用dao方法
        4. 写Dao的按id修改用户方法

### 需求6：删除多条用户信息
+ 步骤
	1. 收集被选择的用户id
	2. 写selectedSerlet类
		1. 获取id列表
		2. 调用service
		3. 返回用户列表页面
	3. service调用Dao的delUser()方法
+ 细节：
	- 最顶选择框控制全选全不选  
		js绑定控制子选框
	- 删除前弹框防止误删

### 需求7：分页功能
+ 步骤：
	1. 设计PageBean
		- 服务器端参数
			- 查询总数
			- 总页码
			- 当前应展示行的列表
		- 客户端参数
			- 一页行数
			- 当前页
	2. 页数page关联用户列表userlist
		1. 初次进入  
			新增page对象，传入每页最大行数
		2. 切换页数后  
			传入切换到的页数，获取page对象
		3. 查询limit行数的数据，并打包userlist
	3. service与Dao
		1. service调用dao的方法
		2. Dao写查询限定行数的用户列表方法：findRows()
	4. 前端分页组件动态绑定

### 需求8：多条件组合查询
+ 步骤：
	1. 设计查询表单，get，绑定servlet
	2. 写finduserbyformServlet
		1获取表单数据
		2调用service
		3转发page到userlist.jsp
	3. service调用Dao
	4. Dao写按表单参数查询用户列表方法：finduserbyform()
+ 问题：
    - sql语句要严谨，该空格就空格，该符号就符号，  
        同时template传入的参数有区分字符串形式和数字形式，要避免数字形式传入成字符串形式无法识别
    - userlist的功能复用，要设计好初始全部查询和条件查询的方法结合
