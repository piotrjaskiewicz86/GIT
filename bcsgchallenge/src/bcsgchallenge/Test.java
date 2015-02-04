//Piotr Jaskiewicz
package bcsgchallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test
{
	static ArrayList<Card> cards;
	static DateFormat df;
	static String number;
	
	public static void main(String[] args)
	{
		cards = new ArrayList<Card>();
		
		df = new SimpleDateFormat("MMM yyyy");
		
		LoadCards();
		DisplayCards();
		SortCards();
		DisplayCards();
		
		System.exit(0);
	}

	public static void LoadCards()
	{
		try 
        {
			final FileReader inputFile = new FileReader("cardsF.dat");
			final BufferedReader inputBuffer = new BufferedReader(inputFile);

        	String line = inputBuffer.readLine();
       
        	while(line!=null)
        	{
        		boolean f = true;
        		Card c = new Card(line, inputBuffer.readLine(), df.parse(inputBuffer.readLine()), Integer.parseInt(inputBuffer.readLine()));
        		
        		for(Card e: cards)
        		{
        			if(c.getBankName().equals(e.getBankName()))
        				f=false;
        		}
        		if(f)
        		{
        			cards.add(c);
        		}
        		
        		line=inputBuffer.readLine();
        	}
			inputBuffer.close();
        }
		catch (Exception ex) 
        {
			System.out.println("exception");
        }
	}
	
	public static void DisplayCards()
	{
		for(Card e: cards)
		{
			System.out.println(e.getBankName());
			System.out.println(df.format(e.getExpiryDate()));
			if(e.getMaskingType()==3)
			{
				number = e.getCardNumber();
				MaskNumber();
				//System.out.println(df.format(e.getExpiryDate()));
			}
			System.out.println();
		}
	}
	
	public static void SortCards()
	{
		Collections.sort(cards);
		Collections.reverse(cards);
	}
	
	public static void MaskNumber()
	{
		String REGEX = "\\d{4}";
		String INPUT = number;
		String REPLACE = "XXXX";
		
		Pattern p = Pattern.compile(REGEX);
		
		Matcher m = p.matcher(INPUT);
		
		INPUT = m.replaceAll(REPLACE);
		
		System.out.println(INPUT);
	}
}
