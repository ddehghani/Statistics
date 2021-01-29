import java.util.Collections;
import java.util.ArrayList;

public class PercentileOp extends Operation
{	
	public PercentileOp()
	{
		super("Percentile");
	}

	public void run()
	{	
		ArrayList<Double> dataList = Util.readFile();
		Collections.sort(dataList);
		//read %tile
		System.out.print("Enter percentile in % : ");
		double percentile = Util.readDouble();
		double place = percentile/100 * dataList.size();
		double result = 0;
		if ( place == Math.floor(place) )
			result = ( dataList.get( (int)place ) + dataList.get( (int)place - 1 ) )/2 ;
		else
			result = dataList.get((int)place);
		System.out.println("\n " + percentile + "% of values in this sample are at or lower than: " + result );
	}
}