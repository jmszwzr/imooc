package com.imooc.singleton;

/*
 * 懒汉式模式
 * 在对象被用到的时候创建
 * 特点：加载类时比较快，运行时获取对象比较慢，线程不安全
 */
public class LazySingleton {
	
	// 1、创建类的唯一实例
	private static LazySingleton instance = null;
	// 2、将构造函数私有化
	private LazySingleton(){
		
	}
	
	// 3、向外提供公共方法
	public static LazySingleton getInstance()
	{
		// 懒汉式单例之所以不安全，就在于如果程序处在多线程的运行环境下
		// ThreadA经过if条件后进入到if代码里面去，此时CPU切换到ThreadB线程也运行到if条件
		// 但是ThreadB也符合条件，此时实例均未创建，所以在多线程运行时
		// 还是有可能创建多个实例的，和我们的需要相差
		if(instance == null)
		{ 
			instance = new LazySingleton();
		}
		return instance;
	}
}
