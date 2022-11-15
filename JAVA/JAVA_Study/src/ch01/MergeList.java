package ch01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeList {

	public static String[] removeElement(String[] arr, String item) {
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		list.remove(item);
		return list.toArray(String[]::new);
	}

	public static String[] removea(String[] lst) {
		int cnt = lst.length;
		for (int i = 0; i < cnt; i++) {
			int j = i + 1;
			while (j < cnt) {
				if ((lst[i].compareTo(lst[j])) == 0) {
					lst = removeElement(lst, lst[j]);
					cnt--;
//					System.out.println("j" + j + "count" + cnt);
				} else
					j++;
			}
		}
		return lst;
	}

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("서울");
		list1.add("북경");
		list1.add("상해");
		list1.add("서울");
		list1.add("도쿄");
		list1.add("서울");
		list1.add("뉴욕");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("런던");
		list2.add("로마");
		list2.add("방콕");
		list2.add("북경");
		list2.add("도쿄");
		list2.add("서울");
		list2.add("서울");
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

		String[] lst1 = new String[0];
		lst1 = list1.toArray(lst1);
		String[] lst2 = new String[0];
		lst2 = list2.toArray(lst2);

		lst1 = removea(lst1);
		lst2 = removea(lst2);

		for (String city : list2)
			System.out.print(city + " ");
		System.out.println("");
		System.out.println("제거후");

		for (String city : lst1)
			System.out.print(city + " ");
		System.out.println("");
		for (String city : lst2)
			System.out.print(city + " ");

		String[] lst3 = new String[10];

		System.out.println("");

		int i = 0, j = 0, k = 0;

		while (i < lst1.length && j < lst2.length) {
			if (lst1[i].compareTo(lst2[j]) < 0) {
				lst3[k] = lst1[i];
				i++; k++;
			} else if (lst1[i].compareTo(lst2[j]) > 0) {
				lst3[k] = lst2[j];
				j++; k++;
			} else if (lst1[i].compareTo(lst2[j]) == 0) {
				lst3[k] = lst1[i];
				i++; j++; k++;
			}

		}
		
		
		
		
		
		while (i < lst1.length) {
			lst3[k] = lst1[i];
			i++; k++;
		}
		while (j < lst2.length) {
			lst3[k] = lst2[j];
			j++; k++;
		}
		for (String city : lst3)
			System.out.print(city + " ");
		

		ArrayList<String> list3 = new ArrayList<String>();
		
		System.out.println();
		System.out.println("merge:: ");
		for (String city : list3)
			System.out.print(city + " ");

		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		// 구현 부분
		
		while(iter1.hasNext())
			System.out.print(iter1.next()+" ");
		System.out.println("");
		while(iter2.hasNext())
			System.out.print(iter2.next()+" ");
		

		

	}
}