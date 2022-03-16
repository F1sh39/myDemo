+ Spring整体环境搭建
	- 步骤
		1. 创建工程
		2. 创建包结构(controller、service、dao、domain、utils)
		3. 导入需要的jar包(坐标)
		4. 搭建数据库环境(Test库)
		5. 设计好静态页面(静态资源的导入)
		6. 创建POJO类(User，Role)
		7. 设置配置文件
			- applicationContext.xml
			- spring-mvc.xml
			- jdbc.properties
			- log4j.properties
	- 遇到的问题：
		* 静态资源加载失败问题   
			[静态资源加载问题](https://segmentfault.com/a/1190000015956038)
		* 配置文件对应名称应拼写正确，方可对应

+ 业务1：角色列表的展示
	- 需求：
		* 侧边栏的管理角色入口点击跳转到角色列表页面(role-list.jsp)
		* 页面显示查找sys_role表的所有信息
	- 步骤：
		1. 侧边栏设管理角色入口跳转角色列表Controller
		2. 角色列表Controller，绑定跳转路径，设置list()调用RoleService，完成后跳转角色列表页面
		3. 创建RoleService，设置list()调用RoleDao
		4. 创建RoleDao，设置findAll()调用JdbcTemplate查询sys_role表
		5. Spring容器配置RoleController，RoleService，RoleDao依赖注入
		6. 设置role-list.jsp显示数据效果

+ 业务2： 角色添加
	- 需求：
		* 角色列表页面中的角色列表附近的新增按钮，点击跳转到角色新增页面(user-add.jsp)
		* 页面表单提交角色信息，存储到sys_role表，重定向回角色列表页面
	- 步骤：
		1. 新增按钮绑定跳转role-add.jsp
		2. 表单接收数据
		3. 提交表单数据到角色添加Controller
		4. 角色添加Controller绑定跳转路径，设置save(Role)，接收数据封装Role对象，调用RoleService，完成后跳转角色列表查询控制器
		5. RoleService设置add(Role)调用RoleDao
		6. RoleDao，设置add(Role)调用JdbcTemplate存储到sys_role表
		7. web.xml设置乱码拦截器，使中文数据能正确传输
	- 遇到的问题：
		* 数据回应时返回的字符串跳转Controller被视图解析器匹配拼接路径  
			字符串前缀写`redirect:`或`forword:`忽略视图解析器
		* 中文数据传输  
			设置乱码拦截器

+ 业务3：用户列表展示
	- 需求：
		* 侧边栏的管理用户入口，点击跳转到用户列表界面(user-list.jsp)
		* 页面展示用户所有信息
	- 步骤：
		1. 侧边栏设管理用户入口跳转用户列表Controller
		2. 用户列表Controller，绑定跳转路径，设置list()调用UserService，完成后跳转用户列表页面
		3. 创建UserService，设置list()调用UserDao和RoleDao
		4. 1创建UserDao，设置findAll()调用JdbcTemplate查询sys_user表  
			2回填User对象的roleList数据。RoleDao设置findRoleById(id)，联合查询sys_user_role和sys_role表
		5. Spring容器配置UserController，UserService，，UserDao，RoleDao依赖注入
		6. 设置user-list.jsp显示数据效果
	- 遇到的问题：
		* 一人多个角色的情况  
			User设roleList来存储多个角色的数据  
			多表查询获取一人多个角色的信息

+ 业务4：用户添加
	- 需求：
		* 用户列表的新增按钮跳转用户新增页面(user-add.jsp)
		* 页面表单提交用户信息，存储到sys_role和sys_user_role表，重定向回角色列表页面
	- 步骤：
		1. 新增按钮绑定跳转页面准备Controller
		2. 页面准备Controller绑定跳转路径，获取roleList，完成后跳转到user-add.jsp
		2. 表单接收数据
		3. 提交表单数据到保存用户Controller
		4. 保存用户Controller绑定跳转路径，设置save(User，roleIdList)，接收数据封装User对象和roleId集合，调用UserService，完成后跳转用户列表Controller
		5. UserService设置save(User，roleIdList)调用UserDao
		6. UserDao，设置saveUser(User)，saveUserRoleRel(userid,roleIdList)，findIdByUsername(username)调用JdbcTemplate存储到sys_user和sys_user_role表
	- 遇到的问题：
		* role集合需要存储到user_role关系表  
			新增用户后获取数据库新赋的id，再去存储role集合

+ 业务5：用户删除
	- 需求：
		* 点击某行用户删除按钮，友好提示确认删除，传递userId
		* sys_role和sys_user_role表删除该用户信息，重定向回角色列表页面
	- 步骤：
		1. 删除按钮设置友好提示，再跳转用户删除信息Controller
		2. 用户删除Controller绑定跳转路径，设置del(userId)，调用UserService，完成后跳转用户列表Controller
		3. UserService设置del(userId)调用UserDao
		4. UserDao设置delUser(userId)，delUserRoleRel(userId)调用JdbcTemplate删除sys_user和sys_user_role表
	- 遇到的问题：
		* 先删UserRole关系表的，再删User表  
			User有外键约束在关系表中，需先删除
		* 应友好提示是否确认删除，以免误删
+ 业务6：管理员权限拦截
	- 需求：
		* 使用任意页面功能需要已验证的管理员身份
		* 拦截器实现管理员权限拦截访问，未登陆跳转到登陆页面，登陆后放行访问
	- 步骤：
	  	1. 创建拦截器，实现preHandle()方法，若session存有管理员信息就放行，否则就跳转登陆页面
	  	2. spring-mvc.xml配置拦截器，拦截所有Controller资源，放行登陆页面(login.jsp)
	  	3. 登陆页面表单接收数据
	  	4. 提交表单数据到登陆Controller，设置login(user)，调用UserService，若返回的user不为空，则存储管理员信息，跳转首页，若返回的user为空，则重回登陆页面
	  	5. UserService设置login(user)调用UserDao，捕抓查询为空的异常
	  	6. UserDao设置findUserByNameAndPsw(user),调用JdbcTemplate查询sys_user表，抛出查询为空的异常
	- 遇到的问题：
		* 需额外放行登陆页面
		* 当表单信息JdbcTemplate查询为null有异常，页面会500错误
