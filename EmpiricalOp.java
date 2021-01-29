import java.util.Scanner;
import java.util.ArrayList;

public class EmpiricalOp extends Operation
{	
	public EmpiricalOp()
	{
		super("Empirical rule(for NORMAL distribution only)");
	}

	public void run()
	{
		Scanner userInput = new Scanner(System.in);
		double sum = 0, counter = 0, mean = 0, variance = 0, std = 0;
		double[] firstRange = new double[2];
		double[] secondRange = new double[2];   
		double[] thirdRange = new double[2];
		double firstProp = 0, secondProp = 0, thirdProp = 0;

		System.out.println("Have the mean and standard deviation been provided ? y/n");
		
		String choice = userInput.nextLine();
		if(choice.equalsIgnoreCase("y"))
		{	
			System.out.println("Enter the mean: ");
			mean = Util.readDouble();
			System.out.println("Enter the std: ");
			std = Util.readDouble();
		} 
		else if(choice.equalsIgnoreCase("n"))
		{
			ArrayList<Double> dataList = Util.readFile();
			for (double data : dataList)
			{
				sum += data;
				counter++;
			}
			mean = sum / counter;
			//calculate variation
			for (double data : dataList)
			{
				variance += (data-mean) * (data-mean);
			}
			variance /= (counter-1);
			std = Math.sqrt(variance);

			firstRange[0] = mean - std*1;
			firstRange[1] = mean + std*1;
			secondRange[0] = mean - std*2;
			secondRange[1] = mean + std*2;
			thirdRange[0] = mean - std*3;
			thirdRange[1] = mean + std*3;



			for (double elements : dataList)
			{
				if(elements >= firstRange[0] && elements <= firstRange[1])
				{
					firstProp++;
				}
				if(elements  >= secondRange[0] && elements <= secondRange[1])
				{
					secondProp++;
				}
				if(elements >= thirdRange[0] && elements <= thirdRange[1])
				{
					thirdProp++;
				}
			}

			firstProp = firstProp/dataList.size();
			secondProp = secondProp/dataList.size();
			thirdProp = thirdProp/dataList.size();

			
		}
		else
		{
			System.out.println("invalid input. Default data is shown.");
		}
			

		System.out.println("\nthe range of numbers 1 standard deviation from the mean is " + 
			"("+firstRange[0] + " , " + firstRange[1] +"), " + "\n the actual proportion should be 0.68 " +
			"the actual proportion is " + firstProp);
		System.out.println("\nthe range of numbers 2 standard deviations from the mean is " + 
			"("+secondRange[0] + " , " + secondRange[1] +"), " + "\n the actual proportion should be 0.95 " +
			"the actual proportion is " + secondProp);
		System.out.println("\nthe range of numbers 3 standard deviations from the mean is " + 
			"("+thirdRange[0] + " , " + thirdRange[1] +"), " + "\n the actual proportion should be 0.997 " +
			"the actual proportion is " + thirdProp);


		System.out.println("remember, if it is greater than 3 stds from the mean, it is weird af");	
	}
}
