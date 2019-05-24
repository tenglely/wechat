# wechat
厨来了 项目
## 基于SSM框架的菜谱教程及分享平台
技术栈：springmvc,spring,mybatis,mysql,Bootstrap,jquery,tomcat


简介：<br>
 该项目面向新手做菜和提高厨艺的用户，为他们提供各种类详细的菜谱教程。同时提供一个便于交流、分享菜品经验的平台。<br>
 项目分为两部分：用户显示端（用户交互、浏览界面），后台管理系统。<br>

用户显示端运行截图<br>
1、	用户端首页<br>
用户端首页：左侧为每日热门（为即时排行榜，根据菜品点击量的高低），其下方为热门讨论（为即时排行榜，根据分享贴的点击量高低），中间的上方为今日新闻，其下方为每日推荐（用户未登陆前是随机菜品推荐，登陆后是根据用户喜好的智能推荐）<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524092830394.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524092905730.png)
<br>2、	菜品大全<br>
点击上方“菜品大全“，进入菜品分类页面，用户可以于此浏览自己喜爱的菜品（菜品为分页显示，开始进入时是按热门菜品显示）<br>
 
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524092937392.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524092945251.png)
<br>3、	菜品详细页
<br>点击某一菜品，进入菜品详细页。用户可以浏览该菜品的制作过程，与用户评论（甚至是通过用户头像点入该用户个人页面进行关注），与发表评论。右侧悬浮按钮为“返回顶部”，“发表评论”
<br>![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093007632.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093012702.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093018883.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>点击悬浮按钮“评论”，用户未登陆不可评论，需跳去登录<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093033841.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>登录成功，方可发表评论<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093122664.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>4、用户交流分享页---“厨分享”
<br>用户交流与分享的页面。用户可浏览他人的分享贴，也可以自己发表分享贴。（右侧悬浮按钮为“返回顶部”，“发表分享贴”）<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093148537.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093202546.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>用户发表分享贴<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093224998.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>分享贴详细页：用户于此页可浏览贴子，发表评论，发表分享贴，点好/坏赞他人贴子，点击用户头像还可进入用户个人页面关注用户<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093249225.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093257714.png)
<br>点击头像进入用户个人页面，可点击”关注”关注用户或取消关注，还可查看他人的关注、评论与发帖，如<br>

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019052409332612.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>点击其评论可看到其评论的菜品/贴子<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093338742.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>点击其贴子，可查看贴子内容<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019052409335184.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>5、“我的”个人设置页面
<br>用户可于此登录账号，注册账号,修改个人信息，查看”我的关注”,”我的评论”,”我的分享贴”
<br>用户登录<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093404335.png)
<br>用户注册新账户<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093419871.png)
<br>“我的关注”，用户可查看自己关注的用户，点击所关注用户头像可以查看该用户个人页面，用户也可于此直接取消用户关注<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093432220.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>“我的评论”，查看自己所发表的评论或删除该评论，点击评论了查看所评论的菜品/贴子的详细内容<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093443407.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>“我的分享贴”，用户可查看自己所发表的贴子，点击可进入该贴的详细页<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093457144.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>后台管理系统运行截图
<br>1、	登录界面
<br>仅限管理员登陆
<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093519927.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>2、后台首页
<br>首页顶部展示当前菜品数，用户数量，用户评论数。
<br>左边图表实时显示用户月增长数与平均每日增长数
<br>右边图表实时显示小程序日活跃数与日评论数
（下方图表为测试数据模拟）<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093538185.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>3、	添加菜品与菜品制作步骤<br>
点击左侧添加菜品，进入添加菜品加菜品与菜品制作步骤界面，添完菜品信息，点击下方“确定并进行步骤添加”进入添加菜品制作步骤界面，点击下方“确认并结束”进入菜品信息管理界面确认添加成功。
<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019052409355562.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>添加菜品制作步骤界面。添加步骤信息完毕，点击下方“继续添加下一步”开始添加下一步步骤，点击下方“结束”结束对此菜品制作步骤的添加，进入菜品信息管理界面
<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093612428.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>4、菜品信息管理<br>
<br>点击左侧菜品信息管理，进入菜品信息管理界面，该页面分页显示当前菜品数据，可于此进行“步骤编辑”，修改菜品，删除菜品，查询菜品。
<br>a.查询菜品：查询全部，根据菜品编号查询，根据菜品名查询，根据菜系查询，根据标签查询，根据点击量查询（降序）
<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093637171.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>b.修改菜品：点击修改按钮，进入菜品修改界面，进行修改<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093648890.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>c.编辑步骤:点击“编辑步骤”按钮，进入该菜品步骤浏览界面
<br>可以对某一步骤进行修改，删除，与添加新步骤<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093700832.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>c.1.点击“修改”，对该步骤进行修改<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093712498.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>c.2.点击“添加新步骤”,添加该菜品新的制作步骤<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093803867.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>5、用户信息管理
<br>点击左侧“用户信息管理”，进入用户信息管理页面。
<br>此页分页显示用户信息，于此可进行用户查询，删除/批量删除，修改权限
<br>a.查询方式：根据用户名查询，根据用户性别查询，根据用户状态查询
<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093845169.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>b.修改用户状态
<br>yes:允许用户发言/评论
<br>no: 禁止用户发言/评论<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093859641.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>6、用户评论管理
<br>点击左侧“用户评论管理”进入页面。此页分页显示用户评论（降序），可于此页查进行查询，删除/批量删除
<br>a.查询：按时间最新查询，根据用户编号查询，根据评论类型查询，根据评论类型编号查询<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093922208.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>7、分享贴信息管理
<br>点击左侧“分享贴信息管理”进入此页面。此页分页显示当前项目贴子信息，可于此页进行查询，浏览，删除/批量删除操作
<br>a.查询:根据点击量高低查询，根据时间最新查询，根据贴子编号查询
<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093944791.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>b.点击浏览，可于此查看小程序端显示详情（内容+用户评论）<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524093957748.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>8、关键词屏蔽<br>
<br>此页实时显示对用户贴子/评论的关键词月屏蔽数，和每日24时实时屏蔽数，还可于此添加需屏蔽的关键词，查看当前会屏蔽的关键词<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524094023562.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>a.	添加需屏蔽关键词<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524094036670.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>b.	查看当前会屏蔽的关键词<br>
以下皆为项目内会屏蔽成“*”的敏感词汇（仅用于测试模拟）<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524094101314.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>9、管理员操作
<br>点击页面顶部右上角，进入管理员界面
<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524094121803.png)
<br>管理员分为超级管理员与普通管理员。超级管理员可添加与删除普通管理员，所有管理员皆可修改个人新消息<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524094135305.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>a.	超级管理员添加普通管理员<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524094146519.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
<br>b.管理员修改个人信息<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524094202783.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RlbmdfaXNfYV9saXR0bGViaXJk,size_16,color_FFFFFF,t_70)
