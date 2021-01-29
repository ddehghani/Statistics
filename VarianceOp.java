import java.util.Collections;
import java.util.ArrayList;

public class VarianceOp extends Operation
{	
	public VarianceOp()
	{
		super("Variance and Standard Deviation");
	}

	public void run()
	{	
		ArrayList<Double> dataList = Util.readFile();
		double sum = 0, counter = 0, mean = 0, variance = 0;
		
		//find the mean
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

		System.out.println("\n Sample Variance (s^2) is: " + variance );
		System.out.println(" And Sample Standard Deviation (s) is: " + Math.sqrt(variance));
	}
}