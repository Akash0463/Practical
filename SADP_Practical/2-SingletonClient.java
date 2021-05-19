class Singleton 
{
	private static Singleton uniqueInstance; 
	private Singleton() {}
 
	public static Singleton getInstance() 
	{
		if (uniqueInstance == null) 
		{
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
 
	public String getDescription() 
	{	
		return "I'm a classic Singleton!";
	}
}

public class SingletonClient 
{
	public static void main(String[] args) 
	{
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.getDescription());
		
	}
}
