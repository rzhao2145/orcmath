package myStuff;

import java.awt.Color;
import java.util.List;

import guiPlayer.CatalogMaker;
import guiPlayer.Countries;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen{

	private TextField countryField;
	private TextField capitalField;
	private TextField monthField;
	private TextArea textArea;
	private CatalogMaker catalog;
	
	private Button addButton;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
 
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		
		textArea = new TextArea(300,200,200,200,"This is a text area");
		viewObjects.add(textArea);
		
		countryField = new TextField(40,40,200,30, "Text goes here", "Country");
		viewObjects.add(countryField);
		
		capitalField = new TextField(240,40,200,30, "Text goes here", "Capital");
		viewObjects.add(capitalField);
		
		monthField = new TextField(440,40,200,30, "Text goes here", "Month Visited");
		viewObjects.add(monthField);
		
		addButton = new Button(640,40,200,30,"Button",  new Action() {
			
			public void act() {
				addButtonClicked();
			}
		});
		viewObjects.add(addButton);

	}

	protected void addButtonClicked() {
		Countries c = new Countries(countryField.getText(), capitalField.getText(), monthField.getText());
		String s = textArea.getText() + c + "\n";
		textArea.setText(s);
		catalog.addNewItem(countryField.getText(), capitalField.getText(), monthField.getText());
		
		checkFields();
		countryField.setText("");
		capitalField.setText("");
		monthField.setText("");
		
		countryField.setInputType(TextField.INPUT_TYPE_PLAIN);
		capitalField.setInputType(TextField.INPUT_TYPE_PLAIN);
		monthField.setInputType(TextField.INPUT_TYPE_PLAIN);

	}
	
	public boolean checkFields() {
		if(countryField.getText().equals("")) {
			countryField.setBackground(Color.RED);
			return false;
		}
		if(capitalField.getText().equals("") {
			capitalField.setBackground(Color.RED);
			return false;
		}
		if(monthField.getText().equals("")) {
			monthField.setBackground(Color.RED);
		}
		return true;
	}
}