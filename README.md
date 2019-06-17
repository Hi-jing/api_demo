#   Servlet接收ajax请求返回json数据案例（可前后端分离)

## 前言

案例主要面向刚入门JavaWeb，还没有接触SpringMVC、Spring等框架技术的学生。展示如何用Servlet作为Controller层去实现接口API、并用JQuery异步请求和渲染数据，进行前后端分离。技术主要有JQuery、Servlet、Mysql、Gson；Gson是谷歌开源的Json解析库，可以方便的将Java对象转换成Json字符串，也可以方便的将Json字符串转换成Java对象。

项目代码（包含文档）地址：https://github.com/QQ2505728250/api_demo

### 接口API简介
#### 1、简单介绍

API接口，就是负责一个程序和其他软件的沟通，本质上是预先定义的函数。
每个接口的设计一般包含请求URL、请求方式、请求入参，响应数据这几个必需项。

#### 2、前后端分离形式

![](https://user-gold-cdn.xitu.io/2019/6/17/16b630ab41fff2ad?w=554&h=326&f=png&s=47598)

### 接口API规范（建议，以本案例简单说明）

#### 1、http请求方式

get（获取）、post（新增）、put（修改）和delete（删除）

#### 2、返回数据格式（一般包括三个字段）

- 失败情况(状态码、提示信息)

![](https://user-gold-cdn.xitu.io/2019/6/17/16b631367ea008f5?w=262&h=132&f=png&s=2570)


- 成功情况(状态码、提示信息,数据对象)

![](https://user-gold-cdn.xitu.io/2019/6/17/16b6313e52f72bc8?w=251&h=144&f=png&s=3515)
#### 3、主要工具类介绍（个人封装好的，可直接使用）

- GsonUtil工具类：把数据对象转成json字符串由HttpServletResponse返回或是处理HttpServletRequest请求中的数据转成对象
  
  #####  ①object2Json方法：

![](https://user-gold-cdn.xitu.io/2019/6/17/16b631421342a684?w=554&h=204&f=png&s=55449)

#####   	②json2Object方法

![](https://user-gold-cdn.xitu.io/2019/6/17/16b6314372915b8d?w=554&h=78&f=png&s=26462)
- ServletUtil工具类（配合GsonUtil工具类使用）：取出流中的数据，并返回json字符串或是向浏览器响应返回json数据
  
  ##### ①readJsonString方法

![](https://user-gold-cdn.xitu.io/2019/6/17/16b631465fdedfb5?w=554&h=229&f=png&s=54420)

#####  	 ②responseData方法

![](https://user-gold-cdn.xitu.io/2019/6/17/16b63147635eca47?w=553&h=114&f=png&s=41050)
- common.js：处理表单序列化为json字符串、获得访问根目录、获取地址路径中的指定参数值
  
#### 4、PC端（接口实现与联调）

- 列表查询接口

  ##### ① Servlet层实现列表查询接口

![](https://user-gold-cdn.xitu.io/2019/6/17/16b6314a494de44b?w=554&h=108&f=png&s=43827)

#####   	② 页面层ajax请求并数据渲染

![](https://user-gold-cdn.xitu.io/2019/6/17/16b6314c75530fe6?w=554&h=292&f=png&s=68885)
- 新增保存接口
  
  ##### ①表单POST异步提交数据

![](https://user-gold-cdn.xitu.io/2019/6/17/16b6314e42b13f38?w=554&h=311&f=png&s=79084)

#####   	②读取数据转成对象保存

![](https://user-gold-cdn.xitu.io/2019/6/17/16b6314f5b468206?w=553&h=125&f=png&s=54082)
- 详情接口
  
  ##### ①获取url中参数请求并渲染

![](https://user-gold-cdn.xitu.io/2019/6/17/16b63150b27d5e75?w=554&h=131&f=png&s=54016)
![](https://user-gold-cdn.xitu.io/2019/6/17/16b6315231487c3e?w=554&h=220&f=png&s=49999)

- 删除接口

![](https://user-gold-cdn.xitu.io/2019/6/17/16b631568d2f8684?w=554&h=114&f=png&s=51865)



为了方便浏览学习，本文内容以文章形式发布到专业知识分享小程序，微信扫一扫直接阅读
专业知识分享小程序：面向高校学生、老师、以及在职中的校友，以专业为基础，针对性地给在校大学生传授知识，职业方向指引，学习资源共享、学习规划。
会陆续发布与专业相关的知识或一些求职经验等。欢迎加入，一起学习，一起成长！
致歉：可能专业知识分享小程序中图片看不清楚，无法放大，目前正在修复组件中...


![](https://user-gold-cdn.xitu.io/2019/6/17/16b631593a21eddd?w=271&h=272&f=png&s=72120)
