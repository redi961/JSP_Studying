package InnerClass;

interface verify {
	boolean check(int n);
}

public class Test03 {

	public static void main(String[] args) {
		
		verify isEven = (n) -> (n % 2) == 0;
		System.out.println(isEven.check(10));
		
		verify isPositive = (n) -> n >= 0;
		System.out.println(isPositive.check(-5));
		
		}
}
