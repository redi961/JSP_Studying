package edu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test3 {

		public void copyFile(String sourceName, String destName) throws Exception {
			FileInputStream fis = new FileInputStream(sourceName);
			FileOutputStream fos = new FileOutputStream(destName);

			int r;
			while((r = fis.read()) != -1) {
				fos.write(r);
			}
			
			fos.close();
			fis.close();
		}
		
		//RunAs 에서 기록한 경로가 String args에 저장됨 -> 배열형식으로 불러와서 사용가능함
		public static void main(String[] args) throws Exception {
			
			Test3 tt = new Test3();
			
			//tt.copyFile("testobj.dat", "dest.dat");
			tt.copyFile(args[0], args[1]);
			
			System.out.println("done");
		}
}
