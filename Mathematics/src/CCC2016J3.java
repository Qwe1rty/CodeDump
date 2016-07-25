import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Caleb Tiger Choi
 * Richmond Hill High School (058100924)
 * Junior Division
 * Question J3
 */

public class CCC2016J3 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		for (int i = input.length(); i > 1; i--)
			for (int j = 0; j + i <= input.length(); j++)
				if (isPalindrome(input.substring(j, i + j))) {
					System.out.println(i);
					System.exit(0);
				}
		System.out.println(1);
	}
	
	public static boolean isPalindrome(String s) {
		return (s.equals(new StringBuilder(s).reverse().toString()));
	}
}
