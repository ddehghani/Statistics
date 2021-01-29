import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class Statistics
{	
	public static void main(String[] args)
	{	
		Locale.setDefault(new Locale("en", "US"));
		ArrayList<Operation> ops = Util.loadOps();
		Scanner in = new Scanner(System.in);

		int userChoice = 1;
		//main loop
		while (userChoice != 0)
		{	
			Util.showMenu(ops);
			userChoice = in.nextInt();
			in.nextLine();

			for (Operation op : ops)
			{
				if (op.getOpNumber() == userChoice)
				{	
					Util.clearScreen();
					op.run();
					System.out.println("\nPress enter to go back to menu ... ");
					in.nextLine();
				}
			}
		}
	}
}