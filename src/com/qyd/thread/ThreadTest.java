package com.qyd.thread;

public class ThreadTest extends Thread{
	/**
	 * Thread多线程
	 * 1、继承Thread类
	 * 2、重写run()方法
	 */
	public void run()
	{
		System.out.println("MyThread.run()");
	}
	
	public static void main(String[] args) {
		ThreadTest myThread1 = new ThreadTest();
		ThreadTest myThread2 = new ThreadTest();
		myThread1.start();
		myThread2.start();
	}
}
