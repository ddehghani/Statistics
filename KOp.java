import java.util.ArrayList;

public class KOp extends Operation
{	
	public KOp()
	{
		super("Proportion of Observations Given K value");
	}

	public void run()
	{	
		ArrayList<Double> dataList = Util.readFile();
		double sum = 0, counter = 0, mean = 0, variance = 0;

		//find mean
		for (double data : dataList)
		{
			sum += data;
			counter++;
		}
		mean = sum / counter;

		//find variation
		for (double data : dataList)
		{
			variance += (data-mean) * (data-mean);
		}
		variance /= (counter-1);

		System.out.print("Enter the K value: ");
		double k = Util.readDouble();
		counter = 0;

		for (double data : dataList)
		{
			double z = (data - mean) / Math.sqrt(variance);
			if ( (z < k) && ( z > (-1 * k) ) )
				counter++;
		}
		System.out.println("\n Proportion of observations captured within " + k + " standard deviation is: " + (counter/dataList.size()) );
		if (k > 1)
			System.out.println(" Chebyshev’s Rule: at least 1-(1/k^2) or " + (1-(1/(k*k))) + " of samples are within " + k + " standard deviation!");
		if ( Math.abs(k - 1.0)  < 0.0001 )
			System.out.println(" Empirical Rule: approximately 0.68 of observations are within 1 standard deviation!");
		if ( Math.abs(k - 2.0)  < 0.0001 )
			System.out.println(" Empirical Rule: approximately 0.95 of observations are within 2 standard deviation!");
		if ( Math.abs(k - 3.0)  < 0.0001 )
			System.out.println(" Empirical Rule: approximately 0.997 of observations are within 3 standard deviation!");
	}
}