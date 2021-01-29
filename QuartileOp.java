import java.util.Collections;
import java.util.ArrayList;

public class QuartileOp extends Operation
{	
	public QuartileOp()
	{
		super("Quartiles and Interquartile Range (Q3-Q1)");
	}

	public void run()
	{
		ArrayList<Double> dataList = Util.readFile();
		Collections.sort(dataList);
		double q1 = 0, q2 =0, q3 = 0;
		
		if (dataList.size() % 4 == 0)
		{
			q1 = (dataList.get(dataList.size() / 4) + dataList.get( (dataList.size() / 4) - 1) ) / 2.0;
			q3 = (dataList.get(dataList.size() * 3 / 4) + dataList.get( (dataList.size() * 3 / 4) - 1) ) / 2.0;

		}
		else
		{
			q1 = dataList.get( (int) (dataList.size() / 4.0) );
			q3 = dataList.get( (int) (dataList.size() * 3.0 / 4.0) );
		}

		if ((dataList.size() % 2) == 0)
			q2 = (dataList.get(dataList.size()/2) + dataList.get( (dataList.size()/2) - 1 ) )/2 ;
		else
			q2 = dataList.get(dataList.size()/2);

		System.out.println("\n Q1 is: " + q1 );
		System.out.println("\n Q2 (Sample Median) is: " + q2 );
		System.out.println("\n Q3 is: " + q3 );
		System.out.println("\n Interquartile Range (Q3-Q1) is: " + (q3-q1) );
	}
}