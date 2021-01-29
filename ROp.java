import java.util.ArrayList;

public class ROp extends Operation
{	
	public ROp()
	{
		super("R code for data");
	}

	public void run()
	{
		ArrayList<Double> dataList = Util.readFile();
		System.out.print("\ndata  <- c(");
		for (double data : dataList)
		{
			System.out.print( data + ",");
		}
		System.out.println("\b)");
	}
}