package common;

public class WeiCalc {
	public int wei;
	public int sum;
	public int i;
	public int j;
	public int k;
	
	
	public WeiCalc() {}
	public WeiCalc(int a) {
		this.wei = a;
	}
	
	public void calc( ) {
		for (i = 1; i<=10; i++) {
			for (j =1; j<= 10; j++) {
				for (k =1;k<=10;k++) {
					if(wei == (i*2) + (j*3) + (k*5)) {
						this.i = i;
						this.j = j;
						this.k = k;
					}
				}
			}
		}
	}
	
	public String result () {
		return "("+i+","+j+","+k+")";
	}
	
	
}
