import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CCC2011S2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int length = Integer.parseInt(br.readLine());
		String[] studentTest = new String[length];
		String[] answerKey = new String[length];
		int correct = 0;
		
		for (int i = 0; i < length; i++) {
			studentTest[i] = br.readLine();
		}
		for (int i = 0; i < length; i++) {
			answerKey[i] = br.readLine();
		}
		
		for (int i = 0; i < length; i++) {
			if (studentTest[i].equals(answerKey[i])) correct++;
		}
		
		System.out.println(correct);
		
		
		
	}

}
