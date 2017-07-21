import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Processing 
{
	public ArrayList<String> Processing(String filename)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
		  BufferedReader br = new BufferedReader(new FileReader(filename.toString()));
		  String strLine;
		  String doc = "";
		  while ((strLine = br.readLine()) != null ) 
		  {  
			  if(strLine.equals(".i") || strLine.equals(".w") )
			  {
				  list.add(doc);
				  doc = " ";
			  }
			  else
			  {
				  doc = doc +" "+ strLine;
			  }
		    }
		  int i= 0;
		  int j = 0;
		  while (i <=list.size() - 1){
			  if(list.get(i).equals(" ")){
				  list.remove(i);
			  }
			  i++;
		  }
		}
		
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
		return list;	
	}
}
