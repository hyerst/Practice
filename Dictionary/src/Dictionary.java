import java.util.*;
import java.io.*;

public class Dictionary 
{

	public static void main(String[] args) throws IOException
	{

		File outFile = new File ("bear_syllables.txt");
		FileWriter fWriter = new FileWriter (outFile);
		PrintWriter pWriter = new PrintWriter (fWriter);

		Hashtable<String, ArrayList<String>> htable = new Hashtable<String, ArrayList<String>>();
		Scanner scan = new Scanner(new File("Syllables.txt"));


		// this loop splits the lines in the text file and adds the syllables to an arraylist
		// which is added to a hashtable with the original word being the key.
		while(scan.hasNextLine())
		{

			String line = scan.nextLine();
			String[] array1 = line.split("[·=\\s]");
			ArrayList<String> list = new ArrayList<String>();

			for(int i = 1; i < array1.length; i++)
			{
				list.add(array1[i]);
			}
			htable.put(array1[0], list);

		}

		//enter the word you would like to see the syllables for.
		Scanner scan2  = new Scanner(System.in);
		//System.out.println("Please enter the lyrics you would like the syllables for");
		//String lyrics = scan2.nextLine();



		Scanner scanFile = new Scanner(new File("bear.txt"));


		while(scanFile.hasNextLine())
		{
			String lyrics2 = scanFile.nextLine().toLowerCase();


			String[] paragraph = lyrics2.split("--");
			System.out.println(paragraph.length + " num of paragraphs");

			System.out.println(numOfSyllables(paragraph, htable));	

			String[] lyric = lyrics2.split("[\\s,\\?\\.!(--)]+");



			for(int i = 0; i < lyric.length; i++)
			{
				String key = lyric[i];
				if(i == lyric.length -1)
				{
					System.out.println();
					pWriter.print("");
				}

				//System.out.println(lyrics2);
				syllables(lyric[i], htable, pWriter);


			}

		}

		pWriter.close();
	}


	public static void syllables(String key, Hashtable<String, ArrayList<String>> htable, PrintWriter pWriter) throws IOException
	{
		Scanner scan3 = new Scanner(System.in);

		// if the word you entered is in the hashtable it will output the syllables
		if(htable.containsKey(key))
		{
			for(int j = 0; j < htable.get(key).size(); j++)
			{	

				//System.out.print(htable.get(key).get(j) + " ");

				pWriter.print(htable.get(key).get(j) + " ");


			}
			//pWriter.close();
		}

		else
		{
			//if the word you entered is not in the hashtable it will ask you to enter the syllables
			System.out.println("the word \'" + key + "\' was not found");
			System.out.println("please enter the syllables for this word separated by spaces.");
			String syllables = scan3.nextLine();

			//the syllables are output to the text file, adding another word to the dictionary.
			File outFile = new File ("Syllables.txt");
			FileWriter fWriter = new FileWriter (outFile, true);
			PrintWriter pWriter1 = new PrintWriter (fWriter);
			pWriter1.println (key + "=" + syllables);
			pWriter1.close();
		}


	}

	public static int numOfSyllables(String[] paragraph, Hashtable<String, ArrayList<String>> htable)
	{
		int numOfSyllables = 0;

		for(int i = 0; i < paragraph.length; i++)
		{
			//System.out.println(paragraph[i]);
			String words[] = paragraph[i].split("[\\s,\\?\\.!(--)]+");
		

				System.out.println(numOfSyllables);
			
			numOfSyllables = 0;

			for(int k = 0; k < words.length; k++)
			{
				if(!htable.containsKey(words[k]))
				{

				}
				else
				{
					ArrayList<String> temp = htable.get(words[k]);
					int temp2 = temp.size();
					for(int j = 0; j <temp2; j++)
					{

						numOfSyllables +=1; 
					}
				}
			}

		}
		return numOfSyllables;

	}


}
