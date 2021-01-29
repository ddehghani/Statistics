import java.util.ArrayList;
import java.util.Collections;

public class RangeOp extends Operation
{	
	public RangeOp()
	{
		super("Sample Range (Max - Min)");
	}

	public void run()
	{
		ArrayList<Double> dataList = Util.readFile();
		Collections.sort(dataList);

		System.out.println("\n Sample Range (Max - Min) is: " + dataList.get(dataList.size()-1) + " - " +  dataList.get(0) + " = " + (dataList.get(dataList.size()-1)- dataList.get(0)));
	}
}