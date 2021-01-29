import java.util.ArrayList;
import java.util.Collections;

public class TrimMeanOp extends Operation
{	
	public TrimMeanOp()
	{
		super("Trimmed Mean");
	}

	public void run()
	{
		ArrayList<Double> dataList = Util.readFile();
		Collections.sort(dataList);
		//read p
		System.out.print("Enter P in % : ");
		double p = Util.readDouble();

		//trim
		int trimNum = (int)  (p * dataList.size() / 100.0) ;
		for (int i=0; i < trimNum; i++)
		{
			dataList.remove(0);
			dataList.remove(dataList.size()-1);
		}

		double sum = 0, counter = 0;
		for (double data : dataList)
		{
			sum += data;
			counter++;
		}

		System.out.println("\n Trimmed Sample Mean (with P = " + p + "%) is: " + (sum/counter) );
	}
}