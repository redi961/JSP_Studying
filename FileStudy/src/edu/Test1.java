package edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {

	public void write (String fname) {
		
		FileOutputStream fos = null;
		try {
		
		fos = new FileOutputStream(fname);
		fos.write("abcdef".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}

	public void printdata (String fname) throws Exception {
		FileInputStream fis = new FileInputStream(fname);
		 
		while(true) {
		// 지정한 파일을 읽어들임
		int r = fis.read();
		// -1 = 데이터의 끝부분
		if ( r == -1) break;
		// 읽어들인 파일의 아스키코드의 int 값의 출력 
		System.out.println("r : " + r + ":" + (char)r);
		}
		
		fis.close();
	}
	
	public static void main(String[] args) {
		Test1 tt = new Test1();
		//tt.write("test.dat");
		try {
		tt.printdata("test.dat");
	}	catch(Exception e ) {
		e.printStackTrace();
		}
	}
}
