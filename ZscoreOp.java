import java.util.Collections;
import java.util.ArrayList;

public class ZscoreOp extends Operation
{	
	public ZscoreOp()
	{
		super("Z score");
	}

	public void run()
	{	
		ArrayList<Double> dataList = Util.readFile();
		double sum = 0, counter = 0, mean = 0, variance = 0, value = 0;

		System.out.print("Enter the value for which you want the z-score: ");
		value = Util.readDouble();

		//find the mean
		for (double data : dataList)
		{
			sum += data;
			counter++;
		}
		mean = sum / counter;

		//calculate variance
		for (double data : dataList)
		{
			variance += (data-mean) * (data-mean);
		}
		variance /= (counter-1);

		System.out.println("\n The z-score for the value "+ value +" is: " + ( (value - mean) / Math.sqrt(variance) ) );
	}
}