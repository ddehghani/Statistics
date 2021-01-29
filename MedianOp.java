import java.util.Collections;
import java.util.ArrayList;

public class MedianOp extends Operation
{	
	public MedianOp()
	{
		super("Sample Median (X tilda)");
	}

	public void run()
	{
		ArrayList<Double> dataList = Util.readFile();
		Collections.sort(dataList);

		System.out.print("\n Sample Median is: ");
		if ((dataList.size() % 2) == 0)
			System.out.println( (dataList.get(dataList.size()/2) + dataList.get( (dataList.size()/2) - 1 ) )/2 );
		else
			System.out.println(dataList.get(dataList.size()/2));
	}
}