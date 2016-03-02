import java.util.Scanner;

public class SalesTaxAndAmount {

	public static void main(String[] args) {

		String customerNumber;
		String customerName;
		double salesAmount, taxRate;
		String taxCode;

		Scanner keyboard = new Scanner(System.in);

		System.out.print( "Customer Number? :" );
		customerNumber = keyboard.next();

		System.out.print( "Customer Name?  :" );
		customerName = keyboard.next();

		System.out.print( "Sales Amount? :" );
		salesAmount = keyboard.nextDouble();

		System.out.print( "Tax Code (NRM, NPF, or BIZ)?  :" );
		taxCode = keyboard.next();

		if (taxCode.equalsIgnoreCase("NRM"))
			taxRate = 0.06;
		else if (taxCode.equalsIgnoreCase("NPF"))
			taxRate = 0.0;
		else if (taxCode.equalsIgnoreCase("BIZ"))
			taxRate = 0.045;
		else {
			taxRate = -1;
		}

		if (taxRate >= 0.0) {
			System.out.println(customerNumber + " " + customerName);

			System.out.println("Sales Amout: $" + salesAmount);
			if (taxRate > 0.0)
				System.out.println("Sales Tax Amount: $" + salesAmount*taxRate);
			System.out.println("Total Amount: $" + salesAmount*(1+taxRate));
		}
		else
			System.out.println("Invalid Tax Code. Bye");

			keyboard.close();

	}

}
