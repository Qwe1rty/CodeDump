
public class CCC2015J5 {

	public static void main(String[] args) {

		System.out.println(f(8, 4, 1));
		System.out.println(f(6, 2, 1));
		System.out.println(f(20, 1, 1));
		System.out.println(f(250, 130, 1));

	}

	public static int f(int pies, int people, int taken) {
		if (people == pies || people == 1) {
			return 1;
		} 
		int total = 0;
		for (int i = taken; i <= pies/people; i++) {
			total += f(pies - i, people - 1, i);
		}
		return total;
	}

}

