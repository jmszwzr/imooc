package com.qyd.thread.test;

public class RunnableTest implements Runnable {

	/**
	 * 实现Runnable接口方式实现多线程
	 * 
	 */
	public void run() {
		System.out.println("RunnableTest.run()...");
	}
	
	public static void main(String[] args) {
		RunnableTest runnableTest = new RunnableTest();
		Thread thread = new Thread(runnableTest);
		thread.start();
	}

}
