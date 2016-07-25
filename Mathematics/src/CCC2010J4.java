import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CCC2010J4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tempstorage = br.readLine().split(" ");
		short[] numArray = new short[tempstorage.length];
		for (byte i = 0; i < tempstorage.length; i++) {
			numArray[i] = Short.parseShort(tempstorage[i]);
		}
	}

}
