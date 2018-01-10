package guiPlayer.simon;

import guiTeacher.GUIApplication;

public class SimonGameRaymond extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimonGameRaymond(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		SimonGameRaymond r = new SimonGameRaymond(800, 600);
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
