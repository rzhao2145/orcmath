package guiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What do you want to name the file?");
		String name = in.nextLine();
		System.out.println("Input text");
		String input = in.nextLine();
		

		try {
			
			FileWriter fw = new FileWriter(name + ".txt");
			fw.write(input);
			fw.close();
			System.out.println("Success! File \"" + name + "\" saved!");
		}catch(IOException e){
			System.out.println(
					"An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}
	} 

}
