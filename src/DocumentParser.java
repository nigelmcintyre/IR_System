
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DocumentParser {

    //This variable will hold all terms of each document in an array.
	private List<String[]> queryTermsArray = new ArrayList<String[]>();
    private List<String[]> termsArray = new ArrayList<String[]>();
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private List<String> queryTerms = new ArrayList<String>();
    private List<double[]> tfidfVector = new ArrayList<double[]>();
    private List<double[]> queryTfidfVector = new ArrayList<double[]>();
    
    // creates and arrayList of all the documents in the folder
    public void parseFiles(ArrayList Med) throws FileNotFoundException, IOException {
    	int z;
    	StringBuilder sb = new StringBuilder();
        String s = null;
    	for(z = 0; z <=Med.size()-1; z++){
    		sb.append(Med.get(z));
    	}
    	 String[] tokenizedTerms = sb.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms
         ;
         
         for (String term : tokenizedTerms) {
         	//if allTerms already contains a term dont add it
             if (!allTerms.contains(term)) {  
             	//add each term in each doc to terms
            	termsArray.add(tokenizedTerms);
            }
        }
         System.out.println(termsArray);
    }
    //creates an arrayList of all the query files in the folder
    public void parseQuery (ArrayList MedQuery)throws FileNotFoundException, IOException {
    	int z;
    	StringBuilder sb = new StringBuilder();
        String s = null;
    	for(z = 0; z <=MedQuery.size()-1; z++){
    		sb.append(MedQuery.get(z));
    	}
    	 String[] tokenizedTerms = sb.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms
    	 ;
         for (String term : tokenizedTerms) {
                	//if allTerms already contains a term dont add it
                    if (!allTerms.contains(term)) {  
                    	//add each term in each doc to terms array
                    	queryTermsArray.add(tokenizedTerms);
                    }
                }       
            }
        
    public void tfIdfCalculator() {
        double tf;
        double idf;
        double tfidf;        
        for (String[] docTermsArray : termsArray) {
            double[] tfidfvectors = new double[allTerms.size()];
            int count = 0;
            for (String terms : allTerms) {
                tf = new TfIdf().tfCalculator(docTermsArray, terms);
                idf = new TfIdf().idfCalculator(termsArray, terms);
                tfidf = tf * idf;
                tfidfvectors[count] = tfidf;
                count++;
            }
            tfidfVector.add(tfidfvectors);  //storing document vectors;            
        }
        for (String[] docTermsArray : queryTermsArray) {
            double[] tfidfvectors = new double[queryTerms.size()];
            int count = 0;
            for (String terms : queryTerms) {
                tf = new TfIdf().tfCalculator(docTermsArray, terms);
                idf = new TfIdf().idfCalculator(queryTermsArray, terms);
                tfidf = tf * idf;
                tfidfvectors[count] = tfidf;
                count++;
            }
            queryTfidfVector.add(tfidfvectors);  //storing document vectors;            
        }
        
    }
    public void getCosineSimilarity() {
        for (int i = 0; i < tfidfVector.size(); i++) {
            for (int j = 0; j < queryTfidfVector.size(); j++) {
                System.out.println("between " + i + " and " + j + "  =  "+
                new CosineSimilarity().cosineSimilarity(tfidfVector.get(i),queryTfidfVector.get(j)));
            }
        }
    }
}
    

