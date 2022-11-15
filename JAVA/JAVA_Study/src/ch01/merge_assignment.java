package ch01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class merge_assignment {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("서울");
		list1.add("북경");
		list1.add("상해");
		list1.add("방콕");
		list1.add("서울");
		list1.add("도쿄");
		list1.add("뉴욕");
		list1.add("LA");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("런던");
		list2.add("로마");
		list2.add("방콕");
		list2.add("북경");
		list2.add("도쿄");
		list2.add("서울");
		list2.add(1, "LA");

		//
		System.out.println("collection.sort()::");
		Collections.sort(list1);
		System.out.println("list1::");
		for (String city : list1)
			System.out.print(city + " ");
		System.out.println();
		System.out.println("list2::");
		Collections.sort(list2);
		for (String city : list2)
			System.out.print(city + " ");
		
		
		ArrayList<String> list3 = new ArrayList<String>();

		Iterator<String> iter1 = list1.iterator();
		// iter1 값이 있으면 1 없으면 0 다음
//		while (iter1.hasNext()) {
//			String obj = (String) iter1.next();
//			list3.add(obj);
//		}
//
		Iterator<String> iter2 = list2.iterator();
//		while (iter2.hasNext()) {
//			String obj = (String) iter2.next();
//			list3.add(obj);
//		}
		
		
		
		Collections.sort(list3);
		System.out.println();
		System.out.println("sort Z:: ");
		for (String city : list3)
			System.out.print(city + " ");
		

		Iterator<String> it = list3.iterator();
		
		
		String[] st3=new String[10];				
		
		
		String st1 = iter1.next();
		String st2 = iter2.next();
		System.out.println("st1 = "+st1);
		
		
		int i = 0, j = 0, k = 0;
		
		while(iter1.hasNext() && iter2.hasNext()) {
			if(st1.compareTo(st2)<0) {
		
				
				
			}
			
		}
		
		
		
		System.out.println("");

//		while (it.hasNext()) {          
//			int count = 0;
//			//str == it의 다음값
//			
//			String str = it.next();    
//			for (int i = 0; i < list3.size(); i++) {
//				if (list3.get(i) == str) {
//					System.out.println(list3.get(i) +" : "+str+" "+count);
//					count++;
//				}
//			}            
//			if (count >= 2) {				
//				
//				it.remove();
//			}
//			count = 0;
//		}
		
		
		Collections.sort(list3);
		System.out.println();
		System.out.println("merge:: ");
		for (String city : list3)
			System.out.print(city + " ");

	}
}