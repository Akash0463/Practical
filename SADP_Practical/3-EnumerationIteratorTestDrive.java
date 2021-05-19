import java.util.*;

class EnumerationIterator implements Iterator<Object> {
	Enumeration<?> enumeration;
 
	public EnumerationIterator(Enumeration<?> enumeration) {
		this.enumeration = enumeration;
	}
 
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}
 
	public Object next() {
		return enumeration.nextElement();
	}
}

public class EnumerationIteratorTestDrive 
{
	public static void main (String args[]) 
	{
		Vector v = new Vector(Arrays.asList(args));
		Iterator iterator = new EnumerationIterator(v.elements());
		while (iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
	}
}
