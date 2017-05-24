package com.imooc.singleton;
/*
 * 双重检查锁定实现的懒汉式单例(Double-Check Locking)
 * 使用volatile修饰符：JDK1.5以上
 * 缺点：volatile关键字会屏蔽Java虚拟机所做的一些代码优化，可能会导致系统运行效率降低
 */
public class LazyDCHSingleton {
	// 1、将实例声明为volatile,确保多个线程能够正确处理
	private volatile static LazyDCHSingleton instance = null;
	
	// 2、将构造函数私有化
	private LazyDCHSingleton(){
		
	}
	
	// 3、向外提供公共方法
	public static LazyDCHSingleton getInstance()
	{
		// 第一重判断
		if(instance == null)
		{
			// 锁定代码块
			synchronized (LazyDCHSingleton.class) {
				// 第二重判断
				if(instance == null)
				{
					instance = new LazyDCHSingleton();
				}
			}
		}
		return instance;
	}
	
}
