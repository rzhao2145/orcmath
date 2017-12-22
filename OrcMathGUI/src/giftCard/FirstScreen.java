package giftCard;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FirstScreen extends FullFunctionScreen {
	private Button changeB;
	private static Reindeer reindeer;
	private static Reindeer reindeer2;
	private static Banner banner;
	private static Banner banner2;

	
	public FirstScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		Graphic background = new Graphic(0,0,getWidth(), getHeight(), "resources/christmasbg.jpg");
		 changeB = new Button(20,20,50,50,"Change", new Action() {
			
			@Override
			public void act() {
				changeScreen();
			}
		});
		 
		viewObjects.add(background);
		viewObjects.add(changeB);
		
		reindeer = new Reindeer(0,0,600/7,139);
		viewObjects.add(reindeer);
		
//		reindeer2 = new Reindeer(740,900,600/7,139);
//		viewObjects.add(reindeer2);
		
		banner = new Banner(1000,100);
		viewObjects.add(banner);
		
//		banner2 = new Banner(1000,1000);
//		viewObjects.add(banner2);
	}

	protected void changeScreen() {
		// TODO Auto-generated method stub
		StarterGUI.sample.setScreen(StarterGUI.screen2);
	}
	
	
}
