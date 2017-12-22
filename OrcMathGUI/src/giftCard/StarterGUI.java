package giftCard;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;
import myStuff.CatalogMakerGUI;

public class StarterGUI extends GUIApplication {
	public static StarterGUI sample;
	public static FirstScreen screen1;
	public static SecondScreen screen2;
	
	
	public static void main(String[] args){
		 sample = new StarterGUI(1300, 1000);
		Thread go = new Thread(sample);
		go.start();
		
		
	}
	 
	public StarterGUI(int width, int height) {
		super(width,height);
		setVisible(true);
	}
	
	public void initScreen() {
		screen1 = new FirstScreen(getWidth(), getHeight());
		screen2 = new SecondScreen(getWidth(), getHeight());
		setScreen(screen1);

	}
	

	
	
}
