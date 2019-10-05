import java.util.Scanner;
import java.io.*;


public class Bank{

  public static boolean anomaly = false;

  public static void main (String arg[]){
      Scanner in = new Scanner(System.in);
      String withAnomaly = "anomally.txt";
      String noAnomaly = "noanomally.txt";
      System.out.println("Here's what happens what a transaction history with an anomaly if read: ");
      readTransaction(withAnomaly);
      checkAnomaly();
      System.out.println("\nHere's what happens when a transaction history with no anomaly is read: ");
      readTransaction(noAnomaly);
      checkAnomaly();

      }

  static void readTransaction(String filename){
	try{
		FileReader file = new FileReader(filename);
		BufferedReader read = new BufferedReader(file);
		String temp = "";
		double transaction = 0;
    	while(temp != null){
    	  temp = read.readLine();
    	  if(temp != null){
    	  transaction = Double.parseDouble(temp);
    	  if(transaction >= 300.00){
    	    anomaly = true;
    	  }
	     }
		}
		read.close();
	}
	catch(FileNotFoundException e){

	}
	catch(IOException e){

	}

  }

  static void checkAnomaly(){
    if(anomaly)
      System.out.println("There has been suspicious activity detected in your bank account. Please log in to your mobile app.");
      anomaly = false;
  }

}
