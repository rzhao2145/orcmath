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
		//addSequence("resources/reindeer", 150, 0, 0 , 256, 256, 7); 
		viewObjects.add(background);
		viewObjects.add(changeB);
	}

	protected void changeScreen() {
		// TODO Auto-generated method stub
		StarterGUI.sample.setScreen(StarterGUI.screen2);
	}
	
	
}
