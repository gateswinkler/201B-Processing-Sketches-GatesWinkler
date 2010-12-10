import java.util.*;
import java.io.*;
import java.net.*;

public class set_project {
	private static int NumChecks = 0;

	public static void main(String[] args){
		int i = 0;
		int numSets = 0;
		String card[] = new String[12];
		
		File file = new File(System.getProperty("user.dir")+"/"+"Set5.txt");	
		try{
			Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()){

					card[i] = scanner.nextLine();
					i++;
				}
			
		}//catches errors
		   catch (IOException e){ System.out.println("");}

		i = 0;
		for(int x = 0; x <10; x++){
			for(int y = x+1; y < 11; y++){
				for(int z = y+1; z<12; z++){
					String[] tempA = card[x].split(":");
					String cardAcolor = tempA[0];
					String cardAnum = tempA[1];
					String cardAshape = tempA[2];
					String cardAfill = tempA[3];
					
					String[] tempB = card[y].split(":");
					String cardBcolor = tempB[0];
					String cardBnum = tempB[1];
					String cardBshape = tempB[2];
					String cardBfill = tempB[3];
					
					String[] tempC = card[z].split(":");
					String cardCcolor = tempC[0];
					String cardCnum = tempC[1];
					String cardCshape = tempC[2];
					String cardCfill = tempC[3];

					if (numSets < 6){
					  //boolean colorsSame = allSame(cardAcolor,cardBcolor,cardCcolor);
					  //boolean colorsDifferent = allDifferent(cardAcolor,cardBcolor,cardCcolor);
					  
					  boolean legalcolor = EQorDIFF(cardAcolor,cardBcolor,cardCcolor);//(colorsSame || colorsDifferent) ? true : false; 
					  
					  //boolean numSame = allSame(cardAnum,cardBnum,cardCnum);
					  //boolean numDifferent = allDifferent(cardAnum,cardBnum,cardCnum);
					  boolean legalnum = EQorDIFF(cardAnum,cardBnum,cardCnum);//(numSame || numDifferent) ? true : false; 
					  
					  //boolean shapeSame = allSame(cardAshape,cardBshape,cardCshape);
					  //boolean shapeDifferent = allDifferent(cardAshape,cardBshape,cardCshape);
					  boolean legalshape = EQorDIFF(cardAshape,cardBshape,cardCshape);//(shapeSame || shapeDifferent) ? true : false; 
					  
					  //boolean fillSame = allSame(cardAfill,cardBfill,cardCfill);
					  //boolean fillDifferent = allDifferent(cardAfill,cardBfill,cardCfill);
					  boolean legalfill = EQorDIFF(cardAfill,cardBfill,cardCfill);//(fillSame || fillDifferent) ? true : false; 
					  //System.out.println(card[x] + " - "+ card[y] +" - "+ card[z]);
					  //System.out.println();

					  if (legalcolor && legalnum && legalshape && legalfill){
						  System.out.println(card[x] + " - "+ card[y] +" - "+ card[z]);
						  
						  /*System.out.println("color: 	"+colorsSame + " " + colorsDifferent);
						  System.out.println("num:	"+numSame + " " + numDifferent);
						  System.out.println("shape:	"+shapeSame + " " + shapeDifferent);
						  System.out.println("fill:	"+fillSame + " " + fillDifferent);
						  
						  System.out.println(legalcolor + " " + legalnum + " "+ legalshape + " "+legalfill);
						  System.out.println();*/
						  //System.out.println(sets[numSets]);
						  numSets++;
					  }
					}
				}
			}
		}
		System.out.println(numSets +  " sets, " + NumChecks + " checks ");
	}
	public static boolean allSame(String a, String b, String c) {
		  boolean c1 = checkEquals(a, b);
		  boolean c2 = checkEquals(a, c);
		  return (c1 && c2) ? true : false;
		} 

	public static boolean allDifferent(String a, String b, String c) {
		  boolean c1 = checkEquals(a, b);
		  boolean c2 = checkEquals(a, c);
		  boolean c3 = checkEquals(b, c);
		  return (!c1 && !c2 && !c3) ? true : false;
		} 
	
	public static boolean EQorDIFF(String a, String b, String c) {
		  boolean c1 = checkEquals(a, b);
		  boolean c2 = checkEquals(a, c);
		  boolean c3 = checkEquals(b, c);
		  if(!c1 && !c2 && !c3) {
			  return true;
		  }
		  else if(c1 && c2){
			  return true;
		  }
		  else{
			  return false;
		  }
		  
		} 

	public static boolean checkEquals(String a, String b) {
		  set_project.NumChecks++;
		  return (a.equals(b)) ? true : false;
		} 
}
