import java.util.ArrayList;

public class MeanOp extends Operation
{	
	public MeanOp()
	{
		super("Sample Mean (X bar)");
	}

	public void run()
	{
		ArrayList<Double> dataList = Util.readFile();
		double sum = 0, counter = 0;
		for (double data : dataList)
		{
			sum += data;
			counter++;
		}
		System.out.println("\n Sample Mean (X bar) is: " + sum + " / " + counter + " = "+ (sum/counter) );
	}
}