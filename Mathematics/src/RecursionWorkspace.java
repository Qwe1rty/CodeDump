import java.util.Scanner;


public class RecursionWorkspace {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
//		System.out.println(count7(in.nextInt()));
		System.out.println(count8(in.nextInt()));

	}

	public static int count7(int n) {
		if ((n % 10) == 7 && n >= 10) {
			return 1 + count7(n/10);
		} else if (!((n % 10) == 7) && n >= 10) {
			return count7(n/10);
		} else if ((n < 10) && (n == 7)) {
			return 1;
		} else {
			return 0;
		}

	}

	public static int count8(int n) {
		if (n < 10 && n == 8) {
			return 1;
		} else if (n < 10 && !(n == 8)) {
			return 0;
		} else if ((n >= 10) && (n % 10 == 8)) {
			if (count8(n/10) == 1 || count8(n/10) == 2) return 2 + count8(n/10);
			else return 1 + count8(n/10);
		} else if ((n >= 10) && !(n % 10 == 8)) {
			return count8(n/10);
		} else return 0;
	}

}
