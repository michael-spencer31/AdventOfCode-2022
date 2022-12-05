import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class day1{

	public static void main(String[] args){

		double sum = 0;
		double largestSum = 0;

		try{
			File input = new File("in.txt");
			Scanner scan = new Scanner(input);

			Path filePath = Paths.get("in.txt");
			List<String> lines = Files.readAllLines(filePath);

			for(String line: lines){

				if(!line.trim().isEmpty()){

					sum += Double.parseDouble(line);

				}else{

					if(sum > largestSum){
						largestSum = sum;
					}
					sum = 0;
				}
			}
			System.out.println(largestSum);
		}catch(FileNotFoundException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}
}