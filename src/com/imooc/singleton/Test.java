package com.imooc.singleton;

public class Test {
	public static void main(String[] args) {
		// 饿汉模式
		EagerSingleton s1 = EagerSingleton.getInstance();
		EagerSingleton s2 = EagerSingleton.getInstance();
		System.out.println("饿汉模式：" + (s1==s2));
		
		// 懒汉模式
		LazySingleton s3 = LazySingleton.getInstance();
		LazySingleton s4 = LazySingleton.getInstance();
		System.out.println("懒汉模式：" + (s3==s4));
		
		// IoDH(Initialization On Demand Holder)(推荐)
		IoDHSingleton s5 = IoDHSingleton.getInstance();
		IoDHSingleton s6 = IoDHSingleton.getInstance();
		System.out.println("IoDH：" + (s5==s6));
		
		// 双重检查锁定实现的懒汉式单例(DCH)
		LazyDCHSingleton s7 =LazyDCHSingleton.getInstance();
		LazyDCHSingleton s8 =LazyDCHSingleton.getInstance();
		System.out.println("DCH：" + (s7==s8));
	}
}
