## 本项目实现的最终作用是基于JSP在线洗衣店管理系统
## 分为3个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 员工管理
 - 收益查询
 - 注销会员
 - 洗涤价格管理
 - 管理员登录
 - 衣服洗涤记录管理
### 第2个角色为员工角色，实现了如下功能：
 - 员工登录
 - 管理衣服洗涤记录
 - 衣服洗涤记录
### 第3个角色为用户角色，实现了如下功能：
 - 会员登录&注册
 - 修改个人信息
 - 充值余额
 - 提交订单
 - 选择干洗的衣服
## 数据库设计如下：
# 数据库设计文档

**数据库名：** cleaner

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [admin](#admin) | 管理员表 |
| [card](#card) |  |
| [cloth](#cloth) |  |
| [orders](#orders) | 订单信息表 |
| [user](#user) | 用户表 |

**表名：** <a id="admin">admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | AdminID |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | state |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 状态  |
|  5   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |

**表名：** <a id="card">card</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | CardID |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | userid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  3   | Balance |   double   | 256 |   0    |    Y     |  N   |   NULL    |   |
|  4   | isUsed |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="cloth">cloth</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ClothID |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | userid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  3   | orderid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 订单ID  |
|  4   | C_type |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | price |   double   | 11 |   0    |    Y     |  N   |   NULL    | 价格  |
|  6   | C_number |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="orders">orders</a>

**说明：** 订单信息表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | OrederID |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | userid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  3   | dataTime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | Cost |   double   | 23 |   0    |    Y     |  N   |   NULL    |   |
|  5   | isDetermined |   int   | 10 |   0    |    Y     |  N   |   NULL    | 0代表已洗涤，1代表未洗涤  |
|  6   | details |   varchar   | 8000 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="user">user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | UserId |   int   | 10 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  5   | address |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 地址  |
|  6   | isMember |   int   | 10 |   0    |    Y     |  N   |   NULL    | 1是会员，0是非会员  |

**运行不出来可以微信 javape 我的公众号：源码码头**
