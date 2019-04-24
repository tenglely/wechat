package com.wechat.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wechat.bean.Greens;
import com.wechat.bean.GreensExample;
import com.wechat.bean.GreensExample.Criteria;
import com.wechat.bean.Step;
import com.wechat.bean.User;
import com.wechat.dao.GreensMapper;
import com.wechat.dao.StepMapper;
import com.wechat.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class testAddUser {
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	GreensMapper greensMapper;
	
	@Autowired
	StepMapper stepMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testUpdateGreensq(){
		GreensMapper mapper=sqlSession.getMapper(GreensMapper.class);
		for(int i=4734;i<=4813;i++){
			Greens greens=mapper.selectByPrimaryKey(i);
			Greens greens2 =mapper.selectByPrimaryKey(4813);
			//System.out.println(greens2.getGneed());
			greens.setGneed(greens2.getGneed());
			System.out.println(greens);
			mapper.updateByPrimaryKey(greens);
		}
	}
	
//	@Test
//	public void testAddGreensq(){
//		GreensMapper mapper=sqlSession.getMapper(GreensMapper.class);
//		for(int i=1;i<=10;i++){
//			Greens greens=new Greens();
//			greens.setGname("汤粥"+i);
//			greens.setGstyle("其他");
//			greens.setGlabel("汤粥");
//			greens.setGcover("1231.jpg");
//			greens.setGwriter("system");
//			greens.setGneed("<p>材料</p><p>主料：圆白菜200克，番茄80克，黄瓜60克，</p><p>辅料：青椒30克，洋葱（白皮）30克，</p><p>调料：色拉油15克，盐2克，柠檬汁20克，蜂蜜10克</p><p>做法</p><p>1.把所有准备好的材料（圆白菜、番茄、小黄瓜、青椒、洋葱）分别洗净，包心菜、番茄切片，青椒、洋葱切环片。</p><p>2.把切好的材料混拌匀，放在盘子中，备用。</p><p>3.最后，把所有的调味料（色拉油、盐、柠檬汁、蜂蜜）混合，搅拌均匀，淋在蔬菜上就可以了。</p><p><br/></p>");
//			greens.setGhits((int)(Math.random()*2019)+1);
//			Date currentTime = new Date();
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String dateString = formatter.format(currentTime);
//			greens.setGdate(dateString);
//			System.out.println(greens);
//			mapper.insert(greens);
//		}
//		System.out.println("添加成功");
//	}
	
//	@Test
//	public void testUpdateGreensGlabel(){
//		GreensExample greensExample=new GreensExample();
//		Criteria criteria=greensExample.createCriteria();
//		criteria.andGstyleEqualTo("苏菜");
//		List<Greens> list=greensMapper.selectByExample(greensExample);
//		GreensMapper mapper=sqlSession.getMapper(GreensMapper.class);
//		for(int i=0;i<list.size();i++){
//			Greens greens=list.get(i);
//			int n=(int)(Math.random()*4);
//			if(n==0)
//				greens.setGlabel(greens.getGlabel()+" 淮扬菜");
//			if(n==1)
//				greens.setGlabel(greens.getGlabel()+" 苏锡菜");
//			if(n==2)
//				greens.setGlabel(greens.getGlabel()+" 金陵菜");
//			if(n==3)
//				greens.setGlabel(greens.getGlabel()+" 徐海菜");
//			System.out.println(greens);
//			greensMapper.updateByPrimaryKey(greens);
//		}
//		System.out.println("修改完成");
//	}
	
	
	
//	@Test
//	public void testAddStep(){
//		System.out.println(stepMapper);
//		System.out.println("ds");
//		StepMapper mapper=sqlSession.getMapper(StepMapper.class);
//		//int num=(int) greensMapper.countByExample(null);
//		//System.out.println(num);
//			for(int j=4734;j<=4813;j++){
//				Step step=new Step();
//				step.setGid(j);
//				step.setStep(5);
//				step.setTiming(0);
//				step.setSdescribe("待起锅前，放入剩余的葱段及辣椒，略煮即可起锅。");
//				step.setVoice("空");
//				step.setSphoto("step05.jpg");
//				System.out.println(step);
//				stepMapper.insert(step);
//			}
//		System.out.println("插入成功");
//	}
	
	
//	@Test
//	public void testAddGreens(){
//		System.out.println(greensMapper);
//		GreensMapper mapper=sqlSession.getMapper(GreensMapper.class);
//		List<String> list=new ArrayList<>();
//		list.add("早餐");
//		list.add("午餐");
//		list.add("晚餐");
//		list.add("宵夜");
//		list.add("鲁菜");
//		list.add("川菜");
//		list.add("粤菜");
//		list.add("苏菜");
//		list.add("闽菜");
//		list.add("浙菜");
//		list.add("湘菜");
//		list.add("徽菜");
//		list.add("养生");
//		List<String> s=new ArrayList<>();
//		List<String> c=new ArrayList<>();
//		s.add("蛋类");
//		s.add("猪肉");
//		s.add("鸡肉");
//		s.add("羊肉");
//		s.add("饺子");
//		s.add("水饺");
//		s.add("蛋类 汤");
//		s.add("猪肉 汤");
//		s.add("鸡肉 汤");
//		s.add("羊肉 汤");
//		s.add("虾");
//		s.add("蟹");
//		s.add("鳙鱼");
//		s.add("鲫鱼");
//		s.add("鲤鱼");
//		s.add("带鱼");
//		s.add("鳙鱼  汤");
//		s.add("鲫鱼 汤");
//		s.add("鲤鱼 汤");
//		s.add("带鱼 汤");
//		s.add("鱿鱼");
//		s.add("鱿鱼 汤");
//		s.add("猪脚");
//		s.add("牛肉");
//		s.add("粥");
//		s.add("面条");
//		s.add("排骨");
//		s.add("牛腩");
//		
//		c.add("娃娃菜");
//		c.add("生菜");
//		c.add("波菜");
//		c.add("紫菜");
//		c.add("冬瓜");
//		c.add("南瓜");
//		c.add("萝卜");
//		c.add("菠萝");
//		c.add("辣椒");
//		c.add("茄子");
//		c.add("豆腐");
//		c.add("豆芽");
//		
//		for(int i=0;i<list.size();i++){
//			
//			for(int j=0;j<s.size();j++){
//				Greens greens=new Greens();
//				greens.setGstyle(list.get(i));
//				greens.setGlabel(s.get(j));
//				greens.setGname("菜品用例a"+i+"_"+j);
//				greens.setGcover("1231.jpg");
//				greens.setGwriter("system");
//				greens.setGneed("<p>材料</p><p>主料：圆白菜200克，番茄80克，黄瓜60克，</p><p>辅料：青椒30克，洋葱（白皮）30克，</p><p>调料：色拉油15克，盐2克，柠檬汁20克，蜂蜜10克</p><p>做法</p><p>1.把所有准备好的材料（圆白菜、番茄、小黄瓜、青椒、洋葱）分别洗净，包心菜、番茄切片，青椒、洋葱切环片。</p><p>2.把切好的材料混拌匀，放在盘子中，备用。</p><p>3.最后，把所有的调味料（色拉油、盐、柠檬汁、蜂蜜）混合，搅拌均匀，淋在蔬菜上就可以了。</p><p><br/></p>");
//				greens.setGhits((int)(Math.random()*2019)+1);
//				Date currentTime = new Date();
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				String dateString = formatter.format(currentTime);
//				greens.setGdate(dateString);
//				System.out.println(greens);
//				mapper.insert(greens);
//			}
//			for(int k=0;k<s.size();k++){
//				for(int a=0;a<c.size();a++){
//					Greens greens=new Greens();
//					greens.setGstyle(list.get(i));
//					greens.setGlabel(s.get(k)+" "+c.get(a));
//					greens.setGname("菜品用例b"+i+"_"+k+"_"+a);
//					greens.setGcover("1231.jpg");
//					greens.setGwriter("system");
//					greens.setGneed("<p>材料</p><p>主料：圆白菜200克，番茄80克，黄瓜60克，</p><p>辅料：青椒30克，洋葱（白皮）30克，</p><p>调料：色拉油15克，盐2克，柠檬汁20克，蜂蜜10克</p><p>做法</p><p>1.把所有准备好的材料（圆白菜、番茄、小黄瓜、青椒、洋葱）分别洗净，包心菜、番茄切片，青椒、洋葱切环片。</p><p>2.把切好的材料混拌匀，放在盘子中，备用。</p><p>3.最后，把所有的调味料（色拉油、盐、柠檬汁、蜂蜜）混合，搅拌均匀，淋在蔬菜上就可以了。</p><p><br/></p>");
//					greens.setGhits((int)(Math.random()*2019)+1);
//					Date currentTime = new Date();
//					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					String dateString = formatter.format(currentTime);
//					greens.setGdate(dateString);
//					System.out.println(greens);
//					mapper.insert(greens);
//				}
//			}
//		}
//		
//		
//		
////		String q=null;
////		for(int i=0;i<1000;i++){
////			String gname="菜品用例"+i;
////			Greens greens=new Greens();
////			greens.setGname(gname);
////			int d = (int)(Math.random()*list.size());
////			greens.setGstyle(list.get(d));
////			int ss=(int)(Math.random()*s.size());
////			int cc=(int)(Math.random()*c.size());
////			int n=(int)(Math.random()*2);
////			if(n==0)
////				q=s.get(ss);
////			else
////				q=s.get(ss)+" "+c.get(cc);
////				System.out.println(q);
////		}
//	}
//	
//	@Test
//	public void testAddUser(){
//		System.out.println(userMapper);
//		UserMapper mapper=sqlSession.getMapper(UserMapper.class);
//		for(int i=0;i<1000;i++){
//			String uname="用户"+UUID.randomUUID().toString().substring(0, 5)+i;
//			User user=new User();
//			user.setUname(uname);
//			//随机性别
//			int d = (int)(Math.random()*2);
//			System.out.println(d);
//			user.setGender(d);
//			//随机用户图片
//			int a = (int)(Math.random()*2);
//			if(a==0)
//				user.setPurl("user01.jpg");
//			else
//				user.setPurl("user02.jpg");
//			user.setUclass("用户");
//			user.setOpenid(UUID.randomUUID().toString().substring(0, 8));
//			user.setState("yes");
//			mapper.insertSelective(user);
//		}
//		System.out.println("批量增加完成");
//	}
}
