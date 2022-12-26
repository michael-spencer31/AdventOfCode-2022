import java.io.File;
import java.util.Scanner; 
import java.io.FileNotFoundException;

public class day25{

	public static long SNAFUtoDecimal(String snafu){

		long[] powers = {1, 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625, 1220703125, 6103515625L, 30517578125L, 152587890625L, 762939453125L, 0, 0, 0, 0, 0, 0};
		int lengthCounter = snafu.length() -1;
		long decimalNumber = 0;

		for(int i = 0; i < snafu.length(); i++){

			if(snafu.charAt(i) == '1'){

				decimalNumber += powers[lengthCounter];
			}else if(snafu.charAt(i) == '2'){

				decimalNumber += (powers[lengthCounter]) * 2;
			}else if(snafu.charAt(i) == '0'){

				//nothing happens here
			}else if(snafu.charAt(i) == '-'){

				decimalNumber += (powers[lengthCounter]) * -1;
				
			}else if(snafu.charAt(i) == '='){

				decimalNumber += (powers[lengthCounter]) * -2;
			}
			lengthCounter--;
		}

		return decimalNumber;
	}
	public static void decimalToSNAFU(long decimal){


	}

	public static void main(String[] args){

		long result = 0;

		try{
			File file = new File("input.txt");
			Scanner reader = new Scanner(file);

			while(reader.hasNextLine()){
				String data = reader.nextLine();
				result += SNAFUtoDecimal(data);
			}
		}catch(FileNotFoundException e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		System.out.println(result);
	}
}
