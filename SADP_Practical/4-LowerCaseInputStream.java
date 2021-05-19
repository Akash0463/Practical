import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

class InputStreamDecorator extends FilterInputStream 
{
	public InputStreamDecorator(InputStream in) {
		super(in);
	 }

	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char) c));
	 }
}


public class LowerCaseInputStream 
{
	public static void main(String[] args) throws IOException 
	{
		int c;
		try {

			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			String buffer;
			while ((buffer = br.readLine()) != null) {
				System.out.println(buffer);
			}
	
			InputStream in = new InputStreamDecorator(
					new BufferedInputStream(
					new FileInputStream("test.txt")));
			
			System.out.println("\n");
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
			in.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
 
	}
}