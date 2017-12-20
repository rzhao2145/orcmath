package myStuff;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen{

	private TextField countryField;
	private TextField capitalField;
	private TextField monthField;
	
	private Button addButton;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		countryField = new TextField(40,40,200,30, "Text goes here", "Country");
		viewObjects.add(countryField);
		
		capitalField = new TextField(240,40,200,30, "Text goes here", "Capital");
		viewObjects.add(capitalField);
		
		monthField = new TextField(440,40,200,30, "Text goes here", "Month Visited");
		viewObjects.add(monthField);
		
		addButton = new Button(40,60,200,30,"Button",  new Action() {
			
			public void act() {
				countryField.setText("You clicked the button!");
				
			}
		});
		viewObjects.add(addButton);

	}
}