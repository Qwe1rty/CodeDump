import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CCC2011S1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] text = new String[Integer.parseInt(br.readLine())];
		int t = 0;
		int s = 0;
		
		for (int i = 0; i < text.length; i++) text[i] = br.readLine().toLowerCase();
		
		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < text[i].length() - 1; j++) {
				if (text[i].substring(j, j + 1).equals("t")) t++;
				else if (text[i].substring(j, j + 1).equals("s")) s++;
			}
		}
		
		if (t > s) System.out.println("English");
		else System.out.println("French");
		
	}

}
