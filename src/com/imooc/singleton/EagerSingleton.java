package com.imooc.singleton;

/*
 * 饿汉模式
 * 在程序启动时即被创建
 * 特点：加载类时比较慢，运行时获取对象比较快，线程安全
 */
public class EagerSingleton {
	
	// 1、构造函数私有化
	private EagerSingleton(){
		
	}
	
	// 2、创建类的唯一示例 私有、静态
	private static EagerSingleton instance = new EagerSingleton();
	
	// 3、提供外部调用的公共方法
	public static EagerSingleton getInstance()
	{
		return instance;
	}
	
}
