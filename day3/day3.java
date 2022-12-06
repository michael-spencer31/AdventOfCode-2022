import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Character;
import java.util.ArrayList;

public class day3{

	public static void main(String[] args){

		final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		final String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		try{

			//create a file to read the input
			File input = new File("in.txt");
			Scanner scan = new Scanner(input);

			Path filePath = Paths.get("in.txt");
			List<String> lines = Files.readAllLines(filePath);
			int letterValue = 0;

			for(String line: lines){

				String s = line;
				final int mid = s.length() / 2;

				//split the string into 2 equal halfs
				String s1a = s.substring(0, (s.length() / 2));
				String s1b = s.substring((s.length() / 2));

				HashMap<String, Integer> s1Chars = new HashMap<String, Integer>();
				HashMap<String, Integer> s2Chars = new HashMap<String, Integer>();

				char c;

				for(int i = 0; i < s1a.length(); i++){

					c = s1a.charAt(i);

					if(!s1Chars.containsKey(c)){

						s1Chars.put(Character.toString(c), 1);
					}else{
					}
				}
				for(int i = 0; i < s1b.length(); i++){

					c = s1b.charAt(i);

					if(!s2Chars.containsKey(c)){

						s2Chars.put(Character.toString(c), 1);
					}else{
					}
				}
				//this line matches the keys between both maps so we can find the common key
				s1Chars.keySet().retainAll(s2Chars.keySet());

				int sum = 0;
				String current = "";
				//get the letter we are working with
				for(String i: s1Chars.keySet()){
					current = i;
				}
				//check if the letter is a capital or not
				if(Character.isUpperCase(current.charAt(0))){
					letterValue += (upperAlphabet.indexOf(current) + 1) + 26;
				}else{
					letterValue += lowerAlphabet.indexOf(current) + 1;
				}
				s1Chars.clear();
				s2Chars.clear();
			}
			//print out the solution!
			System.out.println(letterValue);
		}catch(FileNotFoundException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}
}