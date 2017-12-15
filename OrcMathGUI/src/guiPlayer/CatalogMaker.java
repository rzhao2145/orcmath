package guiPlayer;

import java.util.ArrayList;
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
		System.out.println(cm.getCSVContent());
		
		System.out.println("Type a country");
		String cty = in.nextLine();
		System.out.println("Type the capital");
		String cap = in.nextLine();
		System.out.println("Type the month you visited the place");
		String month = in.nextLine();
		cm.addNewItem(cty,cap,month);

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

	
	
}
