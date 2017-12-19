package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<Countries> list;
	
	public CatalogMaker() {
		list = new ArrayList<Countries>();
		list.add(new Countries("United States", "Washington D.C", "January"));
		list.add(new Countries("Canada", "Ottawa", "July"));
		list.add(new Countries("Sweden", "Stockholm", "March"));
		list.add(new Countries("France", "Paris", "December"));
		list.add(new Countries("Mexico", "Mexico City", "June"));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CatalogMaker cm = new CatalogMaker();
//		System.out.println(cm.getCSVContent());
		
//		System.out.println("Type a country");
//		String cty = in.nextLine();
//		System.out.println("Type the capital");
//		String cap = in.nextLine();
//		System.out.println("Type the month you visited the place");
//		String month = in.nextLine();
//		cm.addNewItem(cty,cap,month);
		
		System.out.println("What do you want to name to file?");
		cm.testSaveContent(in.nextLine());
		
	}
	
	
	
	public String getCSVContent() {
		String data = "Country,Capital,Month Visited \n";
		for(Countries c : list) {
			data += c + "\n";
		}
		return data;
	}
	
	public void addNewItem(String country, String capital, String monthVisited) {
		list.add(new Countries(country,capital,monthVisited));
		System.out.println("Country added successfully!");
	}
	
	private void testSaveContent(String fileName) {

		try {

			FileWriter fw = new FileWriter(fileName);

			for(Countries c : list) {
				fw.write(c + "\n");
			}
			
			fw.write("This file was created programmatically.");

			fw.close();

			System.out.println("Success! File \"" + fileName + "\" saved!");

		} catch (IOException e) {

			System.out.println(
					"An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}

	}
	
	
	private  List<String> testFileLoading() {

		Scanner in = new Scanner(System.in);

		String fileName = "";

		List<String> content = new ArrayList<String>();

		// use this boolean to control the while loop. The user should have multiple
		// chances to enter a correct filename

		boolean opened = false;

		while (!opened) {

			try {

				System.out.println("Enter a file to open");

				fileName = in.nextLine();

				FileReader fileReader = new FileReader(new File(fileName));

				String line = "";

				// a BufferedReader enables us to read teh file one line at a time

				BufferedReader br = new BufferedReader(fileReader);

				while ((line = br.readLine()) != null) {
					String[] param = line.split(",");
					content.add(param[0]);
					/*
					 * 
					 * useful later:
					 * 
					 * split only a comma that has an even number of quotes ahead of it
					 * 
					 * String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					 * 
					 */

				}

				br.close();

				opened = true;

			} catch (IOException e) {

				System.out.println("The file name you specified does not exist.");

			}

		}

		// close the Scanner

		in.close();

		return content;

	}
	
}