package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Collections;

//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\

public class algorithm_assignment {
	public static String[] removeElement1(String[] arr, String item) {
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		list.remove(item);
		return list.toArray(String[]::new);
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		list.add("런던");
		list.add("로마");
		list.add("방콕");
		list.add("북경");
		list.add("도쿄");
		list.add("서울");
		list.add(1, "LA");

		// sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩
		System.out.println("collection.sort()::");
//	    Collections.sort(list);
		for (String city : list)
			System.out.println(city);

		String cities[] = new String[0];
		cities = list.toArray(cities);
		

		System.out.println("정렬후::");
		for (String city : cities)
			System.out.println(city);

		for (int i = 0; i < cities.length; i++) {
			for (int j = i + 1; j < cities.length; j++) {
				if (cities[i].compareTo(cities[j]) > 0) {
					String temp = cities[i];
					cities[i] = cities[j];
					cities[j] = temp;
				}
			}
		}
//		cities = Arrays.stream(cities).distinct().toArray(String[]::new);

		for (String city : cities)
			System.out.println(city);

		// 중복제거
		System.out.println("중복제거::");
		int m = 0, n = 1;
				

		ArrayList<String> lst = new ArrayList<String>(Arrays.asList(cities));
		
		for (int i = 0; i < lst.size(); i++) {
			for (int j = 0; j < lst.size(); j++) {
				if(i==j) {}else if (lst.get(j).equals(lst.get(i))) {
					lst.remove(j);
				}
			}
		}
		
		for (String city : lst)			
			System.out.println(city);

	}
}

//https://mommoo.tistory.com/32 JAVA - ArrayList에서 배열로, 배열에서 ArrayList로
