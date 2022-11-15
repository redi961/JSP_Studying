package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;


public class ObjectArraySort {
	

	public static void main(String[] args) {
		
		class Fruit{
			private String name;
			private int price;
			
			public Fruit() {			
			}
			
			public Fruit(String name,int price) {
				this.name=name;
				this.price=price;		
			}
			
			public int compareTo(Fruit obj1,Fruit obj2) {
				if(obj1.name == obj2.name) {
					if(obj1.price < obj2.price) return -1;
					else if(obj1.price < obj2.price) return 1;
					else return 0;
				}else if(obj1.name.compareTo(obj2.name) < 0) return -1;
				else return 1;
			}
			
		}
//		String[] s = { "sort", "string", "array" };
//		Arrays.sort(s);
//		Arrays.sort(s, Comparator.naturalOrder());
//		Arrays.sort(s, Comparator.reverseOrder()); 
		
		/*
		Arrays.sort(s, new Comparator<String>() {
		    @Override
		    public int compare(String o1, String o2) {
		        return o2.compareTo(o1);            // 내림차순으로 정렬
		    }
		});
		*/
//		s = Arrays.stream(s).sorted().toArray(String[]::new);	
//		s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
//		Collections.sort(Arrays.asList(s));
		Fruit[] arr = {
		        new Fruit("사과", 200),
		        new Fruit("키위", 500),
		        new Fruit("수박", 890),
		        new Fruit("오렌지", 200),
		        new Fruit("바나나", 50),
		        new Fruit("수박", 880),
		        new Fruit("체리", 10)
		};		
		
	    System.out.println();
	    System.out.println("정렬전::");
	    for ( Fruit city: arr)
	    	System.out.print(" " + city.name + city.price);
//		Arrays.sort(arr);

	//구현 - 정렬
	    System.out.println();
	    
	    
	    
	    Fruit f = new Fruit("",0);
	    f=arr[1];
	    

	    for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int k = f.compareTo(arr[i], arr[j]);
				if(k<0) {
					f=arr[i];
					arr[i]=arr[j];
					arr[j]=f;
				}
			}
		}

	    
	    System.out.println("정렬후::");	 
	    for ( Fruit city: arr)
	    	System.out.print(" " + city.name + city.price);

		ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
		ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
		lst2.add(new Fruit("복숭아", 200));
		lst2.add(new Fruit("포도", 300));
		lst2.add(new Fruit("참외", 100));
		lst2.add(new Fruit("딸기", 50));
		lst2.add(new Fruit("블루베리", 500));
		lst2.add(new Fruit("구지뽕", 300));
		System.out.println();
		System.out.println("새로운 리스트2::");
	    for ( Fruit city: lst2)
	    	System.out.print(" " + city);
//	    Arrays.sort(lst2);
	    //Collections.sort(lst2);
		System.out.println();
		System.out.println("새로운 리스트2::");
	    for ( Fruit city: lst2)
	    	System.out.print(" " + city);
	    
	    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();
		
		Iterator<Fruit> iter1 = lst1.iterator();
		Iterator<Fruit> iter2 = lst2.iterator();
		
	//구현- merge를 iterator 사용

		System.out.println();
	    System.out.println("merge:: ");
	    for ( Fruit city: lst3)
	    	System.out.print(city+ " ");
	    Fruit newFruit = new Fruit("참외", 100);
	    //binary search - Comparator를 사용한 구현
	    

	    System.out.println();
//	    if (Collections.binarySearch(lst3, newFruit, cc) < 0)
//			System.out.println("조회결과 없다");
//	    else System.out.println("조회 결과 "+ newFruit);
//	    
		}

}
