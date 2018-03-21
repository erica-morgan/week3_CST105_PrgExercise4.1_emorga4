package twoDimensionalArray;

/**
 *Program: Two Dimensional Array Assignment
 *Project: TwoDimensionalArray.java
 *Summary: This program reads text from a file and displays it in a two-dimensional array. 
 *Author: Erica Morgan
 *Date: 3/17/2018
 */

//imports all java.io with one line
import java.io.*;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		String allText = "";
		char[][] textArray;
		//try catch to import file and produce error if no file is found
		try {
			BufferedReader br = new BufferedReader(new FileReader("Alice.txt"));

			String readLine = "";

			while ((readLine = br.readLine()) != null) {
				allText += readLine;

				System.out.println(allText); //Assignment only asks for column major order to be printed
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		textArray = LoadArray(allText);
		arrayOutput(textArray);
	}
//load array of retrieved text file
	public static char[][] LoadArray(String allText) {
		char[][] textArray = new char[20][45];
		int count = 0;
//begin outer and inner loops
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 45; j++) {
				if (count < allText.length()) {
					textArray[i][j] = allText.charAt(count);
					count++;

					//System.out.println(textArray[i][j]);  //the assignment only wants a column major order print
					
				} 
				else {
					//fill in spaces with the @ symbol
					textArray[i][j] = '@';
				}
			}
		}
//return the array 
		return textArray;
	}
//loops through the array we just wrote, but in column order. this is what the assignment needs to print
	private static void arrayOutput(char[][] textArray) {
		
		StringBuilder outputText = new StringBuilder();
//more for loops
		for (int i = 0; i < 45; i++) {
			for (int j = 0; j < 20; j++) {
				
				outputText.append(textArray[j][i]);
			}
		}
		System.out.println(outputText); //this is the part we print. none of the other parts, according to the instructions
	}
}
