package common;

public class NumberOfCase {
	private int input_num;

	public NumberOfCase() {
	}

	public NumberOfCase(int input_num) {
		this.input_num = input_num;
	}

	public static void main(String[] args) {
		int num=31;
	

		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				for (int j2 = 1; j2 <= 10; j2++) {
					if (num == ((i * 2) + (j * 3) + (j2 * 5))) {					
						System.out.print("(" + i + "," + j + "," + j2 + ")");
					}
				}
			}
		}

	}
}
