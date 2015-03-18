package ter.tom;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RomanNumberConverter rnc = new RomanNumberConverter();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Enter some roman number: ");
            String romanNumber = scanner.nextLine();

            if (romanNumber.toLowerCase().equals("exit")) break;
            else {
                int number = rnc.convertRomanToInteger(romanNumber);

                if (number == -1) System.out.println("Invalid roman number!");
                else
                    System.out.printf("Your roman number is: %d", number);

                System.out.print("\n\n");
            }
        }

        scanner.close();
    }
	
}

