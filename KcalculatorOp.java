import java.util.ArrayList;

public class KcalculatorOp extends Operation
{	
	public KcalculatorOp()
	{
		super("Proportion of Observations Given Range");
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

		System.out.print("Enter the lower bound of the range: ");
		double low = Util.readDouble();
		System.out.print("Enter the higher bound of the range: ");
		double high = Util.readDouble();
		counter = 0;
		for (double data : dataList)
		{
			if ( (data < high) && ( data > low ) )
				counter++;
		}

		double lowz = (low - mean) / Math.sqrt(variance), highz = (high - mean) / Math.sqrt(variance);
		System.out.println("\n Proportion of observations captured within the specified range is: " + (counter/dataList.size()) );

		if ( ( Math.abs(highz + lowz)  < 0.0001 ) && ( highz > 1) )
		{
			System.out.println(" Equvalant K value is: " + highz);
			System.out.println(" Chebyshev’s Rule: at least 1-(1/k^2) or " + (1-(1/(highz*highz))) + " of samples are within " + highz + " standard deviation!");
		}

		if ( Math.abs(highz - 1.0)  < 0.0001 )
			System.out.println(" Empirical Rule: approximately 0.68 of observations are within 1 standard deviation!");
		if ( Math.abs(highz - 2.0)  < 0.0001 )
			System.out.println(" Empirical Rule: approximately 0.95 of observations are within 2 standard deviation!");
		if ( Math.abs(highz - 3.0)  < 0.0001 )
			System.out.println(" Empirical Rule: approximately 0.997 of observations are within 3 standard deviation!");
	}
}