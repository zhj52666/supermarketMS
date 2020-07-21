# 超市管理系统

#### 介绍
大学校内超市管理系统，实现收银台，商品分类管理，商品库存管理，商品管理，营收统计等功能

#### 软件架构
![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/102858_b76cc608_5371991.png "屏幕截图.png")

#### 使用说明

1.  项目导入eclipse
2.  配置tomcat+jdk
3.  sql 导入 修改config 下配置文件

# 1 系统需求描述

## 1.1 系统开发目的

本系统是基于B/S架构的武汉理工大学校内超市管理系统，为了解决超市对雇员，对商品的管理，提高工作效率而开发，本系统具有收银记录出纳的功能，会记录超市的流水，还有销售统计功能，可以分类查询某时间端某具体产品的收益，售出情况，还有对商品进行分类管理，系统可以管理分类，增加分类，修改分类信息，删除分类，可以对商品库存进行管理，实现对商品的模糊查询，分类查询，按生产日期查询，并能对商品进行添加库存，还可以新建商品，修改商品属性，删除商品，此外还有过滤器对访问权限的管理，只有登录系统才可以访问系统页面。

## 1.2 系统需求分析

登录功能：登录系统才可以对我们的各类信息进行操作，增加登录权限验证，没有登录到系统，无权访问其他页面。

分类管理功能：我们需要对产品进行分类管理，在分类管理中我们可以新增分类也可以修改删除分类。

商品库存管理：商品是我们系统的核心，我们需要对商品进行查询，默认显示所有商品的信息，我们还可以通过商品名字模糊搜索，可以根据分类搜索，可以更据更据生产日期范围进行搜索，他们之间可以进行有效的组合，我们还可以增加某商品的库存，可以新建商品，可以编辑商品信息。

收银台功能：我们可以更据商品编号和购买数量进行记录，可以输入收款计算找零。

销售统计功能：对收银台记录的流水进行归类统计，依托商品进行统计，可以分类查询，可以更据时间段查询统计，记录商品销售数量，单价，总收入，总的盈利。

# 2 系统设计与实现

## 2.1 功能模块设计

登录功能：登录系统才可以对使用其他功能。

分类管理功能：我们需要对产品进行分类管理，在分类管理中我们可以新增分类也可以修改删除分类。分类对应商品的分类。

商品库存管理：商品进行查询，通过商品名字模糊搜索，可以根据分类搜索，可以更据更据生产日期范围进行搜索，他们之间可以进行有效的组合，可以增加某商品的库存，可以新建商品，可以编辑商品信息。录入这些商品的信息，我们可以在收银台记录出纳。

收银台功能：我们可以更据商品编号和购买数量进行销售记录，还可以输入收款计算找零。

销售统计功能：对收银台记录的流水进行归类统计，依托商品进行统计，可以分类查询，可以更据时间段查询统计商品销售数量，单价，总收入，总盈利，如图2-1。

 

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/102927_22bf6c8f_5371991.png "屏幕截图.png")

图2-1 系统功能图

## 2.2 类和数据库表设计

### 2.2.1 类设计

本项目中为了实现2.1中的模块功能，我们设计了四个实体类，分别是用户类，商品类，分类类，销售记录类，商品是属于分类下的，在销售记录中记录售出商品的信息，如图2-2。

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/102938_cf3a55e5_5371991.png "屏幕截图.png")

图2-2 UML类图

2.2.2 数据库表设计

本系统一共设计四张数据表分别是user用户信息表，记录用户名和密码，category分类信息表，记录商品的分类，推荐等级，product商品信息表，记录分类编号，商品名称，生产日期，厂家，进价，售价，库存，售出，进货时间等信息，还有销售记录，记录每一次收银台的销售情况，最后方便统计，该表有商品编号，数量，收入，利润，销售时间等信息，数据库概要设计如图2-4，数据库详细设计如图2-5

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103001_644f743f_5371991.png "屏幕截图.png")

图2-4数据库概要设计

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103019_35ef7624_5371991.png "屏幕截图.png")

图2-5 数据库详细设计

## 2.3 系统实现

代码结构，如图2-6

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103030_7b0c1ab6_5371991.png "屏幕截图.png")

图2-6 项目代码结构

# 3系统测试

登录功能测试，登录输入有问题，会返回前端错误消息，增强用户体验。如图3-1

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103123_2d3dc027_5371991.png "屏幕截图.png")

首页展示功能测试，如图3-2

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103137_a8de0861_5371991.png "屏幕截图.png")

图3-2 首页展示功能

收银台功能测试，点击提交录入交易信息显示价格，商品信息，完成更改库存，记录交易的操作，如图3-3

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103146_2745a0cc_5371991.png "屏幕截图.png")

图3-3 收银台功能

分类信息管理功能测试，包含对分类信息的增加，编辑，删除功能，如图3-4

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103232_8478a257_5371991.png "屏幕截图.png")

图3-4 分类信息管理功能

商品库存管理功能测试，包含对商品信息的增加，删出，修改，查询入口，对商品库存的增加，如图3-5

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103250_f10daae7_5371991.png "屏幕截图.png")

图3-5 商品信息管理功能

销售统计功能测试，如图3-6

![输入图片说明](https://images.gitee.com/uploads/images/2020/0721/103332_c9d6642f_5371991.png "屏幕截图.png")

图3-6 销售统计功能功能