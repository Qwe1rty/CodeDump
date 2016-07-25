import java.util.Scanner;


public class RecusionFactorial {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println(factorial(in.nextInt()));

	}

	public static int factorial(int n) {
			if (n <= 1) return 1;
			else return n * factorial(n-1);

	}
}
