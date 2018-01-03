package guiPlayer.simon;

import guiPlayer.CustomGUI;
import guiTeacher.GUIApplication;

public class SimonGameRaymond extends GUIApplication {

	public SimonGameRaymond(int width, int height) {
		super(width, height);
		
	}

	public static void main(String[] args) {
		SimonGameRaymond r = new SimonGameRaymond(800, 550);
		Thread runner = new Thread(r);
		runner.start();
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		SimonScreenRaymond raymond = new SimonScreenRaymond(getWidth(), getHeight());
		setScreen(raymond);
	}

}
