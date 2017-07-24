package com.qyd.reflet;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * @TypeName: TestReflect
 * @Description: 
 * 
 * 		1、从测试环境：jdk1.7
 * 		2、引入的jar包
 * 			1）junit-4.12.jar
 * 			2）hamcrest-all-1.1.jar
 * 
 * 		Java反射机制详解：http://www.cnblogs.com/lzq198754/p/5780331.html
 * 
 * @author: qyd
 * @date: 2017-7-24 下午3:36:56
 */
public class TestReflect implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Test
	/*
	 * 1、通过一个对象获得完整的包名和类名
	 */
	public void Demo1()
	{
		TestReflect reflect = new TestReflect();
		System.out.println(reflect.getClass().getName());
	}
	
	@Test
	/*
	 * 2、实例化Class类对象
	 */
	public void Demo2() throws ClassNotFoundException
	{
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		
		// 一般采用这种形式
		class1 = Class.forName("com.qyd.reflet.TestReflect");
		class2 = new TestReflect().getClass();
		class3 = TestReflect.class;
		
		System.out.println("类名称1：" + class1.getName());
		System.out.println("类名称2：" + class2.getName());
		System.out.println("类名称3：" + class3.getName());
		
	}
	
	@Test
	/*
	 * 3、获取一个对象的父类与实现的接口
	 * 
	 * 注：需要此类实现一个接口，比如Serializable
	 */
	public void Demo3() throws ClassNotFoundException
	{
		Class<?> cla = Class.forName("com.qyd.reflet.TestReflect");
		// 获得父类(父类是：java.lang.Object)
		Class<?> parentClass = cla.getSuperclass();
		System.out.println("cla的父类为：" + parentClass.getName());
		
		// 获取所有的接口
		Class<?> interfaces[] = cla.getInterfaces();
		System.out.println("cla实现的接口有：");
		for(int i = 0; i < interfaces.length; i++)
		{
			System.out.println((i + 1) + ": " + interfaces[i].getName());
		}

		// 打印结果
		// cla实现的接口有：
		// 1: java.io.Serializable
	}
	
	
	
	@Test
	/*
	 * 4、通过反射机制实例化一个类的对象
	 */
	public void Demo4() throws Exception
	{
		Class<?> class1 = null;
		class1 = Class.forName("com.qyd.reflet.User");
		
		// 第一种方法
		User user = (User) class1.newInstance();
		user.setName("静美书斋");
		user.setAge(18);
		System.out.println(user);
		// 结果为：User [age=18, name=静美书斋]
		
		
		// 第二种方法
		// 获得全部的构造函数，使用构造函数赋值
		Constructor<?> cons[] = class1.getConstructors();
		// 查看每个构造方法需要的参数(只输出有参构造函数的属性)
		for(int i = 0; i < cons.length; i++)
		{
			System.out.print("cons[" + i + "](");
			Class<?> claszzs[] = cons[i].getParameterTypes();
			for(int j = 0; j < claszzs.length; j++)
			{
				if(j == (claszzs.length - 1))
				{
					System.out.print(claszzs[j].getName());
				}else
				{
					System.out.print(claszzs[j].getName() + ",");
				}
			}
			System.out.println(")");
		}
		
		// 打印结果：
		// cons[0](int,java.lang.String)
		// cons[1](java.lang.String)
		// cons[2]()
		
		user = (User) cons[0].newInstance(18,"Adam");
		System.out.println("cons[0]：" + user);
		// 结果 cons[0]：User [age=18, name=Adam]
		
		user = (User) cons[1].newInstance("Jack");
		System.out.println("cons[1]：" + user);
		// 结果 cons[1]：User [age=0, name=Jack]
	}
	
	
	@Test
	/*
	 * 5、获取你某个类的全部属性
	 * 
	 * 注：需要此类实现一个接口，比如Serializable
	 */
	public void Demo5() throws ClassNotFoundException
	{
		Class<?> clazz = Class.forName("com.qyd.reflet.TestReflect");
		System.out.println("=============== 本类属性 ===============");
		// 获取本类的全部属性
		Field[] fields = clazz.getDeclaredFields();
		for(int i = 0; i < fields.length; i++)
		{
			// 权限修饰符
			int mo = fields[i].getModifiers();
			String priv = Modifier.toString(mo);
			System.out.println(priv);
			// 属性类型
			Class<?> type = fields[i].getType();
			System.out.println(priv + " " + type.getName() + " " + fields[i].getName() + ";");
			// 打印结果：
			// private static final
			// private static final long serialVersionUID;
		}
		
		System.out.println("============== 实现的接口或者父类的属性 ==============");
		// 取得实现的接口或者父类的属性
		Field[] fields1 = clazz.getFields();
		for(int j = 0; j < fields1.length; j++)
		{
			// 获得权限修饰符
			int mo = fields1[j].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = fields1[j].getType();
			System.out.println(priv + " " + type.getName() + " " + fields1[j].getName() + ";");
		}
		
		
		
	}
	
	
	
	
	
	
}



/*
 * 4-1：用户实体类
 */
class User
{
	private int age;
	private String name;
	
	public User() {
		super();
	}
	public User(String name) {
		super();
		this.name = name;
	}
	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}
	
}



