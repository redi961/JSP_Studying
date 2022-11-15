package edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test2 {

	// 객체를 파일에 기록
	public void writeObject(String fname) throws Exception {
		FileOutputStream fos = new FileOutputStream(fname);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for (int i = 10; i<=20; i++) {
		Member m = new Member("홍길동" + i , i);
		oos.writeObject(m);
		}

		oos.close();
		fos.close();
	}
	
	//파일에 저장된 객체를 불러옴
	public void printObject (String fname) throws Exception {
		FileInputStream fis  = new FileInputStream(fname);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		for (int i = 0 ; i <=10 ; i++) {
		Member m = (Member) ois.readObject();
		
		if (m == null) break;
		
		System.out.println("print : " + m);
		
		}
		
		fis.close();
		ois.close();
		
	
	}

	public static void main(String[] args) throws Exception {
		Test2 tt = new Test2();

		//tt.writeObject("testobj.dat");
		tt.printObject("testobj.dat");
		
		System.out.println("Done");
	}

}
