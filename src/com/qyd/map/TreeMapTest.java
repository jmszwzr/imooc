package com.qyd.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: qyd
 * @date: 2017-6-16下午8:52:48
 * @descript: 对TreeMap的Key或者value进行排序
 * http://sundful.iteye.com/blog/2145441
 * 
 * 
 * 		Map是键值对的集合接口，它的实现类主要包括：HashMap、TreeMap、Hashtable以及LinkedHashMap等。
 * 
 * 		TreeMap：基于红黑树(Red-Black tree)的NavigableMap实现，该映射根据其键的自然顺序进行排序，
 * 或者根据创建映射时提供的Comparator进行排序，具体取决于使用的构造方法。
 * 
 * 		HashMap的值没有顺序的，它是按照key的HashCode来实现的，对于这个无序的HashMap，我们要怎么来实现排序呢？
 * 参照TreeMap的value排序
 * 
 * 		Map.Entry返回Collections视图。
 */
public class TreeMapTest {
	public static void main(String[] args) {
		// TreeMap key排序
		//TreeMapKeySort();
		
		// TreeMap key的默认排序方式
		//TreeMapDefaultKeySort();
		
		// TreeMap value排序
		TreeMapValueSort();
	}
	
	
	/*
	 * TreeMap Key排序
	 * 
	 * TreeMap默认是升序的，如果我们需要改变排序方式，则需要使用比较器：Comparator。
	 * Comparator可以对集合对象或者数组进行排序的比较器接口，实现该接口的
	 * public compare(T o1,T o2)方法即可实现排序，如下：
	 */
	private static void TreeMapKeySort()
	{
		Map<String, String> map = new TreeMap<String, String>(new Comparator<String>(){
			public int compare(String obj1,String obj2){
				// 降序排序
				//return obj2.compareTo(obj1);
				// 升序排序
				return obj1.compareTo(obj2);
			}
		});
		map.put("b", "ccccc");
		map.put("d", "aaaaa");
		map.put("c", "bbbbb");
		map.put("a", "ddddd");
		
//		map.put("b", "bbbbb");
//		map.put("d", "ddddd");
//		map.put("c", "ccccc");
//		map.put("a", "aaaaa");
		
		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext())
		{
			String key = iter.next();
			System.out.println(key + ":" + map.get(key));
		}
	}
	
	/*
	 * TreeMap key默认排序方式：升序
	 */
	private static void TreeMapDefaultKeySort()
	{
		Map<String, String> map = new TreeMap<String, String>();
		
		map.put("b", "qwer");
		map.put("d", "asdf");
		map.put("a", "zxcv");
		map.put("c", "poiu");
		
		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext())
		{
			String key = iter.next();
			System.out.println(key + ":" + map.get(key));
		}
	}
	
	/*
	 * TreeMap value排序
	 * 借助于Collections的sort(List<T> list,Comparator<? super T> c)方法，
	 * 该方法根据指定比较器产生的顺序对指定列表进行排序。
	 * 但有一个前提条件，那就是所有的元素都必须能够根据所提供的比较器来进行比较，如下：
	 */
	private static void TreeMapValueSort()
	{
		Map<String, String> map = new TreeMap<String, String>();
		
//		map.put("a", "ddddd");
//		map.put("c", "bbbbb");
//		map.put("d", "aaaaa");
//		map.put("b", "ccccc");
		
		map.put("b", "qwer");
		map.put("d", "asdf");
		map.put("a", "zxcv");
		map.put("c", "poiu");
		map.put("e", "poau");
		
		// 这里讲map.entrySet()转换成list
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
		
		// 然后通过比较器来实现排序
		Collections.sort(list,new Comparator<Map.Entry<String, String>>(){
			// 升序排序
			public int compare(Entry<String, String> o1,Entry<String,String> o2)
			{
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Map.Entry<String, String> mapping : list)
		{
			System.out.println(mapping.getKey() + ":" + mapping.getValue());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
