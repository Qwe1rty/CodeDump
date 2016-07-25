import java.util.Arrays;

public class CompSciQ1 {

	public static void main(String[] args) {
		short[] ballsucks = {12093, 3198, 1233, 30987, 22348, 9907};
		String[] bellsucks = new String[ballsucks.length];
		Arrays.sort(ballsucks);
		for (byte i = 0; i < ballsucks.length; i++) {
			bellsucks[i] = Integer.toHexString(ballsucks[i]).toUpperCase();
			System.out.println(bellsucks[i]);
		}
		
	}

}
