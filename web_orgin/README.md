## 登陆项目
### 需求
+ 一个html网页，form表单输入username和password值，post请求方式提交
+ Druid数据库连接池技术，连接mysql，操作mydb数据库下的mydb_user表
+ JDBCTemplate技术操作sql
+ Tomcat作为服务器应用，Servlet处理表单数据
### 项目结构
[![WaF6Ld.png](https://z3.ax1x.com/2021/07/21/WaF6Ld.png)](https://imgtu.com/i/WaF6Ld)
### 分析
+ 表单action对应一个servlet实现类
+ Dao包操作数据库
+ servlet实现类通过Dao包下的类进行数据库连接操作
+ servlet实现类继承HttpServlet类，重写doPost方法对form请求数据进行处理
+ 可使用JavaBean进行数据封装成类
### 出现的问题
+ User类成员变量 与 form表单的name属性 及数据表的字段名 没对应上
  - 解决：尽量全部统一成同一名称，以数据库字段名为准
+ getResourceAsStream()的空指针异常  
  -  `class.getClassLoader().getResourceAsStream(String name)`  
      默认从classpath中找文件(文件放在resources目录下)，name不能带“/”，否则会抛空指针
  - [讲解文章](https://blog.csdn.net/feeltouch/article/details/83796764)
+ form提交中文乱码
  - 解决：将HttpServletRequest的字符集设置为网页的字符集`req.setCharacterEncoding("utf-8")`
+ JavaBean转变失败
  - 需要注意JavaBean属性与成员变量的区别，属性操作成员变量
  - 成员变量尽量与form的name值相同

