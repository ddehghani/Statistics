public abstract class Operation
{
	private String name;
	private int opNumber;
	private static int numberOfOps;

	static
	{
		numberOfOps = 0;
	}

	public Operation(String name)
	{
		this.name = name;
		opNumber = ++numberOfOps;
	}

	public int getOpNumber()
	{
		return opNumber;
	}

	public String getName()
	{
		return name;
	}

	public abstract void run();
}