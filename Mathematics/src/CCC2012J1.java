import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CCC2012J1 {

	public static void main(String[] args) throws Exception {
		// Driver speed limit question
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the speed limit:");
		short speedLimit = Short.parseShort(br.readLine());
		System.out.println("Enter the speed of the driver:");
		short driverSpeed = Short.parseShort(br.readLine());
		if (driverSpeed <= speedLimit) System.out.println("Congratulations, you are within the speed limit!");
		else {
			short speedDifference = (short) (driverSpeed - speedLimit);
			if (speedDifference > 0 && speedDifference <= 20) System.out.println("You are speeding and your fine is $100");
			else if (speedDifference > 20 && speedDifference <= 30) System.out.println("You are speeding and your fine is $275");
			else System.out.println("You are speeding and your fine is $500");
		}
	}

}
