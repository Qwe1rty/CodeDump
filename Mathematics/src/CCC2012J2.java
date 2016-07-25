import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CCC2012J2 {

	public static void main(String[] args) throws Exception {
		//Fish rising/diving/whatev thing
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		short[] depthReadings = new short[4];
		for (byte i = 0; i < 4; i++) {
			depthReadings[i] = Short.parseShort(br.readLine());
		}
		if (depthReadings[0] < depthReadings[1] && depthReadings[1] < depthReadings[2] && depthReadings[2] < depthReadings[3])
			System.out.println("Fish Rising");
		else if (depthReadings[0] > depthReadings[1] && depthReadings[1] > depthReadings[2] && depthReadings[2] > depthReadings[3])
			System.out.println("Fish Diving");
		else if (depthReadings[0] == depthReadings[1] && depthReadings[2] == depthReadings[3] && depthReadings[1] == depthReadings[2])
			System.out.println("Constant Depth");
		else System.out.println("No Fish");
	
	}

}
