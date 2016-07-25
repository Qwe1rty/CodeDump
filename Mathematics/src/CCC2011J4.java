import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CCC2011J4 {

	static ArrayList<Point> list = new ArrayList<Point>();

	public static void main(String[] args) throws IOException {

		list.add(new Point(0, -1));
		list.add(new Point(0, -2));
		list.add(new Point(0, -3));
		list.add(new Point(1, -3));
		list.add(new Point(2, -3));
		list.add(new Point(3, -3));
		list.add(new Point(3, -4));
		list.add(new Point(3, -5));
		list.add(new Point(4, -5));
		list.add(new Point(5, -5));
		list.add(new Point(5, -4));
		list.add(new Point(5, -3));
		list.add(new Point(6, -3));
		list.add(new Point(7, -3));
		list.add(new Point(7, -4));
		list.add(new Point(7, -5));
		list.add(new Point(7, -6));
		list.add(new Point(7, -7));
		list.add(new Point(6, -7));
		list.add(new Point(5, -7));
		list.add(new Point(4, -7));
		list.add(new Point(3, -7));
		list.add(new Point(2, -7));
		list.add(new Point(1, -7));
		list.add(new Point(0, -7));
		list.add(new Point(-1, -7));
		list.add(new Point(-1, -6));
		list.add(new Point(-1, -5));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Point clocation = new Point(-1, -5);
		boolean isIntercept = false;

		while (true) {
			isIntercept = false;
			Point nlocation = new Point(clocation.x, clocation.y);
			String[] input = br.readLine().split(" ");

			if (input[0].equals("q")) {
				Thread.currentThread().interrupt();
				return;
			}

			for (int moves = 0; moves < Integer.parseInt(input[1]); moves++) {

				if (input[0].equals("u")) nlocation.y = nlocation.y + 1;
				else if (input[0].equals("d")) nlocation.y = nlocation.y - 1;
				else if (input[0].equals("r")) nlocation.x = nlocation.x + 1;
				else if (input[0].equals("l")) nlocation.x = nlocation.x - 1;
				

				for (int i = 0; i < list.size(); i++) {
					if (nlocation.equals(list.get(i))) isIntercept = true;
				}
				
				list.add(new Point(nlocation.x, nlocation.y));
				
				if (isIntercept) break;

			}
			
			if (input[0].equals("u")) System.out.print(clocation.x + " " + (clocation.y + Integer.parseInt(input[1])));
			else if (input[0].equals("d")) System.out.print(clocation.x + " " + (clocation.y - Integer.parseInt(input[1])));
			else if (input[0].equals("r")) System.out.print((clocation.x + Integer.parseInt(input[1])) + " " + clocation.y);
			else if (input[0].equals("l")) System.out.print((clocation.x - Integer.parseInt(input[1])) + " " + clocation.y);
			
			if (isIntercept) {
				System.out.println(" DANGER");
				Thread.currentThread().interrupt();
				return;
			}
			else System.out.println(" safe");
			
			clocation = nlocation;

		}
	}

}
