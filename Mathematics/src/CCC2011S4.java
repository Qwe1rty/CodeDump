import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CCC2011S4 {

	public static int[] blood;
	public static int[] patient;
	public static int total = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] sblood = br.readLine().split(" ");
		String[] spatient = br.readLine().split(" ");
		
		blood = new int[sblood.length];
		patient = new int[spatient.length];
		
		for (int i = 0; i < sblood.length; i++) {
			blood[i] = Integer.parseInt(sblood[i]);
			patient[i] = Integer.parseInt(spatient[i]);
		}
		
		// O-
		give(0, 0);
		
		// O+
		give(1, 1);
		give(0, 1);
		
		// A-
		give(2, 2);
		give(0, 2);
		
		// A+
		give(3, 3);
		give(2, 3);
		give(1, 3);
		give(0, 3);
		
		// B-
		give(4, 4);
		give(0, 4);
		
		// B+
		give(5, 5);
		give(4, 5);
		give(1, 5);
		give(0, 5);
		
		// AB-
		give(6, 6);
		give(4, 6);
		give(2, 6);
		give(0, 6);
		
		// AB+
		give(7, 7);
		give(6, 7);
		give(5, 7);
		give(4, 7);
		give(3, 7);
		give(2, 7);
		give(1, 7);
		give(0, 7);

		System.out.println(total);
		
//7063760 5274514 7215794 8547008 8315323 9012855 8221829 9214873
//8701697 4489464 3234778 9447869 4195557 8313374 3912568 1552104
//42209474
		
	}

	public static void give(int bindex, int pindex) {
		if (blood[bindex] >= patient[pindex]) {
			blood[bindex] = blood[bindex]- patient[pindex];
			total += patient[pindex];
			patient[pindex] = 0;
		} else if (blood[bindex] < patient[pindex]) {
			patient[pindex] = patient[pindex] - blood[bindex];
			total += blood[bindex];
			blood[bindex] = 0;
		}
	}
}
