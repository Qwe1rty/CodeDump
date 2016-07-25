import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Caleb Tiger Choi
 * Richmond Hill High School (058100924)
 * Junior Division
 * Question J4
 */

public class CCC2016J4 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(":");
		int[] time = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};

		for (int i = 0; i < 12; i++)
			if (time[0] < 7 || (time[0] >= 10 && time[0] < 15) || time[0] >= 19)
				time = addtime(time, 10);
			else time = addtime(time, 20);
		System.out.println(convert(time));
	}
	
	public static String convert(int[] i) {
		String s = "";
		if (i[0] < 10) s += "0";
		s += String.valueOf(i[0]);
		s += ":";
		if (i[1] == 0) s += "00";
		else s += String.valueOf(i[1]);
		return s;
	}
	
	public static int[] addtime(int[] i, int minutes) {
		i[0] += minutes / 60;
		i[1] += minutes % 60;
		if (i[1] >= 60) {
			i[0]++;
			i[1] -= 60;
		}
		i[0] = i[0] % 24;
		return i;
	}
}
