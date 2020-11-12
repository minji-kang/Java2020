import java.util.*;

public class ex1_20170154 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Peak Line Number: ");
		int peak = input.nextInt();
		
		for (int i = 1; i <= peak; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
		
		for (int i = 1; i < peak; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(" ");
			for (int j = 1; j <= peak - i; j++)
				System.out.print("*");
			System.out.println();
		}

	}

}
