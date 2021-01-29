import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Util
{	
	public static ArrayList<Double> readFile()
	{
		Scanner userInput = new Scanner(System.in);
		ArrayList<Double> dataList = new ArrayList<Double>();
		System.out.print("Enter text file name without extension: ");
		String fileName = userInput.nextLine() + ".txt";
		try
		{
			Scanner fileInput = new Scanner(new File(fileName));
			while (fileInput.hasNextLine())
			{
				String s = fileInput.nextLine() + " "; //to make sure last if happens
				String currentNumber = "";
				boolean aNumberExists = false;
				for (int i=0; i<s.length(); i++)
				{	
					if (((int) s.charAt(i) <= 57) && ((int) s.charAt(i) >= 48) ) // 0-9
					{	
						aNumberExists = true;
						currentNumber += s.charAt(i);
					}
					else if ( (int)s.charAt(i) == 46) // . 
					{
						currentNumber += ".";
					}
					else if (aNumberExists) // neither a number nor . 
					{
						dataList.add(Double.parseDouble(currentNumber));
						currentNumber = "";
						aNumberExists = false;
					}
				}
			}
		}

		catch (Exception e)
		{
			System.out.println("File not found!");
		}

		return dataList;
	}

	public static double readDouble()
	{
		Scanner userInput = new Scanner(System.in);
		if (userInput.hasNextDouble())
		{
			return userInput.nextDouble();
		}
		else
		{
			System.out.println("Invalid Input!");
			return 0;
		}
	}

	public static void showMenu(ArrayList<Operation> ops)
	{
		clearScreen();
		System.out.println("Math 2565 is made easy! How can I help you today?\n");
		for (Operation o : ops)
		{
			System.out.println(" " + o.getOpNumber() + ". " + o.getName());
		}
		System.out.println(" 0. Exit");
		System.out.print("\nEnter any number from the menu: ");
	}

	public static ArrayList<Operation> loadOps()
	{	
		ArrayList<Operation> ops = new ArrayList<Operation>();
		ops.add(new MeanOp());
		ops.add(new MedianOp());
		ops.add(new TrimMeanOp());
		ops.add(new ModeOp());
		ops.add(new RangeOp());
		ops.add(new VarianceOp());
		ops.add(new QuartileOp());
		ops.add(new FiveNumOp());
		ops.add(new ZscoreOp());
		ops.add(new PercentileOp());
		ops.add(new KOp());
		ops.add(new KcalculatorOp());
		ops.add(new EmpiricalOp());
		ops.add(new ROp());

		return ops;
	}

	public static void clearScreen() 
	{  
    	System.out.print("\033[H\033[2J");  
    	System.out.flush();  
   	}

   	/* old readFile(). uncomment if something goes wrong
   	public static ArrayList<Double> readFile()
	{
		Scanner userInput = new Scanner(System.in);
		ArrayList<Double> dataList = new ArrayList<Double>();
		System.out.print("Enter text file name without extension: ");
		String fileName = userInput.nextLine() + ".txt";

		try
		{
			Scanner fileInput = new Scanner(new File(fileName));
			while (fileInput.hasNext())
			{
				if (fileInput.hasNextDouble())
					dataList.add(fileInput.nextDouble());
				else
					fileInput.next();
			}
		}
		catch (Exception e)
		{
			System.out.println("File not found!");
		}

		return dataList;
	}*/

}