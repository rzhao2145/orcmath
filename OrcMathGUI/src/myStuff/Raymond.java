package myStuff;


import guiTeacher.GUIApplication;

public class Raymond extends GUIApplication{
	
	private static Raymond raymond;
	private static CustomButton customButton;

	public Raymond(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    raymond = new Raymond(1000,1000);
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		customButton = new CustomButton();
		
	}

}
