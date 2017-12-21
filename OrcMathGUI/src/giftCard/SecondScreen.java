package giftCard;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SecondScreen extends FullFunctionScreen {
	private Button changeB;

	public SecondScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		 changeB = new Button(20,20,50,50,"Change", new Action() {
			
			@Override
			public void act() {
				changeScreen();
			}
		});
		viewObjects.add(changeB);
	}

	protected void changeScreen() {
		// TODO Auto-generated method stub
		StarterGUI.sample.setScreen(StarterGUI.screen1);
	}
	
}
