package com.imooc.singleton;

/*
 * IoDH模式(Initialization On Demand Holder)
 * 综合饿汉模式和懒汉模式的优点(推荐使用)
 */
public class IoDHSingleton {
	// 1、将构造函数私有化，不允许外部直接创建对象
	private IoDHSingleton(){
		
	}
	
	// 2、创建私有静态内部类，在内部类中创建唯一实例
	private static class HolderClass{
		private final static IoDHSingleton instance = new IoDHSingleton();
	}
	
	// 3.向外提供公共方法
	public static IoDHSingleton getInstance()
	{
		return HolderClass.instance;
	}
}
