import java.util.Scanner;

public class CompSciQ2D091014 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		byte[] bloodBags = new byte[8];
		byte[] bloodPatients = new byte[8];
		
		//ON, OP, AN, AP, BN, BP, ABN, ABP
		//0,  1,  2,  3,  4,  5,  6,   7
		for (byte i = 0; i < 8; i++) {
			System.out.println("Enter the next amount of bloodbags [" + i + "]");
			bloodBags[i] = in.nextByte();
		}
		for (byte i = 0; i < 8; i++) {
			System.out.println("Enter the next amoutn of blood patients [" + i + "]");
			bloodPatients[i] = in.nextByte();
		}
		
		
		
	}

}
