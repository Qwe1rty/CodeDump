import java.util.ArrayList;
import java.util.Scanner;


public class CCC2014S3 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int trials = in.nextInt();
		String[] output = new String[trials];
		for (int i = 0; i< trials; i++) {
			int numTrucks = in.nextInt();
			ArrayList<Integer> trucks = new ArrayList<Integer>();
			for (int j = 0; j < numTrucks; j++) {
				trucks.add(in.nextInt());
			}
			output[i] = calculate(trucks);
		}

		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}

	}

	public static String calculate(ArrayList<Integer> trucks) {
		ArrayList<Integer> branch = new ArrayList<Integer>();
		int truckNeeded = 1;
		for (;;) {
			if ((trucks.size() == 0) && (branch.size() == 0)) {
				break;
			} else if ((trucks.size() > 0) &&(trucks.get(trucks.size() - 1) == truckNeeded)) {
				trucks.remove(trucks.size() - 1);
				truckNeeded++;
			} else if ((branch.size() > 0) && (truckNeeded == (branch.get(branch.size() - 1)))) {
				branch.remove(branch.size() - 1);
				truckNeeded++;
			} else if ((branch.size() == 0) || (trucks.get(trucks.size() - 1) < branch.get(branch.size() - 1))) {
				branch.add(trucks.get(trucks.size() - 1));
				trucks.remove(trucks.size() - 1);
			} else return "N";
		}
		return "Y";
	}

}
