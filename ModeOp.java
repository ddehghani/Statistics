import java.util.ArrayList;

public class ModeOp extends Operation
{	
	public ModeOp()
	{
		super("Mode");
	}

	public void run()
	{
		ArrayList<Double> dataList = Util.readFile();
		double sum = 0, counter = 0, p=0;

		//count
		double[][] dataCount = new double[dataList.size()][2];
		int indexOfUniqueNumbers = 0;

		while (!dataList.isEmpty())
		{	
			double temp = dataList.get(0);
			int count = 1;
			dataList.remove(0);
			while ( dataList.indexOf(temp) >= 0)
			{
				count++;
				dataList.remove (dataList.indexOf(temp));
			}
			dataCount[indexOfUniqueNumbers][0] = temp;
			dataCount[indexOfUniqueNumbers][1] = count;
			indexOfUniqueNumbers++;
		}

		//find highest count
		int highestCount = 0;
		for (int i=0; i < indexOfUniqueNumbers; i++)
		{
			if (dataCount[i][1] > highestCount)
				highestCount = (int)dataCount[i][1];
		}

		//output
		System.out.println("\n The mode value(s) (repeated " + highestCount + " times) are: ");
		for (int i=0; i < indexOfUniqueNumbers; i++)
		{
			if (dataCount[i][1] == highestCount)
				System.out.print("\n " + dataCount[i][0] + "\t");
		}
		System.out.println();
	}
}