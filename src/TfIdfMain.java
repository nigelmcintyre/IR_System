import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class TfIdfMain {
    

    public static void main(String args[]) throws FileNotFoundException, IOException
    {  
    	
    	String[] stopWrds = { "1","3","2","4","5","6","7","8","9",".","without", "see", "unless", "due", "also", "must", "might", "like", "]", "[", "}", "{", "<", ">", "?", "\"", "\\", "/", ")", "(", "will", "may", "can", "much", "every", "the", "in", "other", "this", "the", "many", "any", "an", "or", "for", "in", "an", "an ", "is", "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren�t", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can�t", "cannot", "could", "couldn�t", "did", "didn�t", "do", "does", "doesn�t", "doing", "don�t", "down", "during", "each", "few", "for", "from", "further", "had", "hadn�t", "has", "hasn�t", "have", "haven�t", "having", "he", "he�d", "he�ll", "he�s", "her", "here", "here�s", "hers", "herself", "him", "himself", "his", "how", "how�s", "i ", " i", "i�d", "i�ll", "i�m", "i�ve", "if", "in", "into", "is", "isn�t", "it", "it�s", "its", "itself", "let�s", "me", "more", "most", "mustn�t", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "ought", "our", "ours", "ourselves", "out", "over", "own", "same", "shan�t", "she", "she�d", "she�ll", "she�s", "should", "shouldn�t", "so", "some", "such", "than", "that", "that�s", "their", "theirs", "them", "themselves", "then", "there", "there�s", "these", "they", "they�d", "they�ll", "they�re", "they�ve", "this", "those", "through", "to", "too", "under", "until", "up", "very", "was", "wasn�t", "we", "we�d", "we�ll", "we�re", "we�ve", "were", "weren�t", "what", "what�s", "when", "when�s", "where", "where�s", "which", "while", "who", "who�s", "whom", "why", "why�s", "with", "won�t", "would", "wouldn�t", "you", "you�d", "you�ll", "you�re", "you�ve", "your", "yours", "yourself", "yourselves", "Without", "See", "Unless", "Due", "Also", "Must", "Might", "Like", "Will", "May", "Can", "Much", "Every", "The", "In", "Other", "This", "The", "Many", "Any", "An", "Or", "For", "In", "An", "An ", "Is", "A", "About", "Above", "After", "Again", "Against", "All", "Am", "An", "And", "Any", "Are", "Aren�t", "As", "At", "Be", "Because", "Been", "Before", "Being", "Below", "Between", "Both", "But", "By", "Can�t", "Cannot", "Could", "Couldn�t", "Did", "Didn�t", "Do", "Does", "Doesn�t", "Doing", "Don�t", "Down", "During", "Each", "Few", "For", "From", "Further", "Had", "Hadn�t", "Has", "Hasn�t", "Have", "Haven�t", "Having", "He", "He�d", "He�ll", "He�s", "Her", "Here", "Here�s", "Hers", "Herself", "Him", "Himself", "His", "How", "How�s", "I ", " I", "I�d", "I�ll", "I�m", "I�ve", "If", "In", "Into", "Is", "Isn�t", "It", "It�s", "Its", "Itself", "Let�s", "Me", "More", "Most", "Mustn�t", "My", "Myself", "No", "Nor", "Not", "Of", "Off", "On", "Once", "Only", "Ought", "Our", "Ours", "Ourselves", "Out", "Over", "Own", "Same", "Shan�t", "She", "She�d", "She�ll", "She�s", "Should", "Shouldn�t", "So", "Some", "Such", "Than", "That", "That�s", "Their", "Theirs", "Them", "Themselves", "Then", "There", "There�s", "These", "They", "They�d", "They�ll", "They�re", "They�ve", "This", "Those", "Through", "To", "Too", "Under", "Until", "Up", "Very", "Was", "Wasn�t", "We", "We�d", "We�ll", "We�re", "We�ve", "Were", "Weren�t", "What", "What�s", "When", "When�s", "Where", "Where�s", "Which", "While", "Who", "Who�s", "Whom", "Why", "Why�s", "With", "Won�t", "Would", "Wouldn�t", "You", "You�d", "You�ll", "You�re", "You�ve", "Your", "Yours", "Yourself", "Yourselves"};
    	
		try{
				Scanner fileName=new Scanner(new File("/Users/AaronMcGloin/Documents/College/4BCT/Modern Information Management/MED.txt")); //file here from which you want to remove the stop words
				FileOutputStream out=new FileOutputStream("/Users/AaronMcGloin/Documents/College/4BCT/Modern Information Management/stopRmvd.txt");
	
			while(fileName.hasNext())
			{
				int flag=1;
				String s1=fileName.next();
				s1=s1.toLowerCase();
				for(int i=0;i<stopWrds.length;i++){
					if(s1.equals(stopWrds[i])){
						flag=0;
					}
				}
				if(flag!=0)
				{
					//System.out.println(s1);
					PrintStream p=new PrintStream(out);
					p.println(s1);
				}
			}
			System.out.println("Stop words Med.txt\t\tcomplete");
			Scanner queryFile=new Scanner(new File("/Users/AaronMcGloin/Documents/College/4BCT/Modern Information Management/MEDQRY.txt"));
			FileOutputStream queryOut=new FileOutputStream("/Users/AaronMcGloin/Documents/College/4BCT/Modern Information Management/queryStopRmvd.txt");
			while(queryFile.hasNext())
			{
				int flag=1;
				String s1=queryFile.next();
				s1=s1.toLowerCase();
				for(int i=0;i<stopWrds.length;i++){
					if(s1.equals(stopWrds[i])){
						flag=0;
					}
				}
				if(flag!=0)
				{
					//System.out.println(s1);
					PrintStream p=new PrintStream(queryOut);
					p.println(s1);
				}
		
			}
			System.out.println("Stop words MedQuery.txt\t\tcomplete");
		}
			catch(Exception e){
				System.err.println("cannot read file"+e);
			}
		
		char[] w = new char[501];
	      Stemmer s = new Stemmer();
	      try
	      {	FileInputStream in = new FileInputStream("/Users/AaronMcGloin/Documents/College/4BCT/Modern Information Management/stopRmvd.txt");
	         try  { while(true) 	 
	           {  int ch = in.read();
	              if (Character.isLetter((char) ch))
	              { int j = 0;
	                 while(true)
	                 {  ch = Character.toLowerCase((char) ch);
	                    w[j] = (char) ch;
	                    if (j < 500) j++;
	                    ch = in.read();
	                    if (!Character.isLetter((char) ch))
	                    {for (int c = 0; c < j; c++) s.add(w[c]);
	                       s.stem();
	                       {  String u;
	                       		u = s.toString();
	                          //System.out.print(u);
	                       }break;
	                    }
	                 }
	              }
	              if (ch < 0) break;
	             // System.out.print((char)ch);
	           }
	         System.out.println("Med.txt stemmed\t\t\tcomplete");
	         }	
	         catch (IOException e)
	         {  System.out.println("error reading "); }
	      }
	      catch (FileNotFoundException e)
	      {  System.out.println("file not found");}
	      
	      
	      char[] x = new char[501];
	      Stemmer y = new Stemmer();
	      try
	      {	FileInputStream in = new FileInputStream("/Users/AaronMcGloin/Documents/College/4BCT/Modern Information Management/queryStopRmvd.txt");
	         try  { while(true) 	 
	           {  int ch = in.read();
	              if (Character.isLetter((char) ch))
	              { int j = 0;
	                 while(true)
	                 {  ch = Character.toLowerCase((char) ch);
	                    x[j] = (char) ch;
	                    if (j < 500) j++;
	                    ch = in.read();
	                    if (!Character.isLetter((char) ch))
	                    {for (int c = 0; c < j; c++) y.add(x[c]);
	                       y.stem();
	                       {  String u;
	                       		u = y.toString();
	                         //System.out.print(u);
	                       }break;
	                    }
	                 }
	              }
	              if (ch < 0) break;              
	           }
	         	System.out.println("MedQuery.txt stemmed\t\tcomplete");
	         }	
	         catch (IOException e)
	         {  System.out.println("error reading "); }
	      }
	      catch (FileNotFoundException e)
	      {  System.out.println("file not found");}
    
	      
	    
		  String fs = ("/Users/AaronMcGloin/Documents/College/4BCT/Modern Information Management/stopRmvd.txt");
		  Processing pf = new Processing(); 
		  ArrayList<String> stopRmvd = pf.Processing(fs);
		  System.out.println("Med.txt process\t\t\tcomplete");
		  //System.out.println(stopRmvd);
		  
		  String fs2 = ("/Users/AaronMcGloin/Documents/College/4BCT/Modern Information Management/querystopRmvd.txt");
		  Processing pf2 = new Processing(); 
		  ArrayList<String> querystopRmvd = pf2.Processing(fs2);
		  System.out.println("MedQuery.txt process\t\tcomplete");
		  //System.out.println(querystopRmvd);
		  
		  


		DocumentParser dp = new DocumentParser();
        dp.parseFiles(stopRmvd);// give the location of source file
        dp.parseQuery(querystopRmvd);
        dp.tfIdfCalculator(); //calculates tfidf
        dp.getCosineSimilarity(); //calculates cosine similarity   
       
    
    }
}