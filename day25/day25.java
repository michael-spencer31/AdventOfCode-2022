import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.io.File;  
import java.util.Scanner;
import java.io.FileNotFoundException;

public class day25{

	private static final Map<Character, Integer> VALUES = Map.of( '0', 0, '1', 1, '2', 2, '=', -2,
      '-', -1 );
  	private static final List<Character> DIGITS = List.of( '0', '1', '2', '=', '-' );
 	private static final List<Integer> REMAINDERS = List.of( 0, 1, 2, -2, -1 );

	private static String toSnafu(long decimal){

		final var snafu = new StringBuilder();  

		while(decimal != 0){

			final int remainder = (int) (decimal % 5);
			decimal -= REMAINDERS.get(remainder);
			snafu.append(DIGITS.get(remainder));
			decimal /= 5;
		}
		return snafu.reverse().toString();
	}
	private static long toDecimal(final String snafu){

		long decimal = 0L;

		for(final var c: snafu.toCharArray()){

			decimal *= 5;
			decimal += VALUES.get(c);
		}
		return decimal;
	}

	public static void main(String[] args){

		long result = 0;
		String snafu = "";

		try{

			File file = new File("input.txt");
			Scanner reader = new Scanner(file);

			while(reader.hasNextLine()){
				String data = reader.nextLine();
				result += toDecimal(data);
			}
		}catch(FileNotFoundException e){
			System.out.println("An error has occurred");
			e.printStackTrace();
		}
		snafu = toSnafu(result);
		System.out.println(snafu);
	}
}
