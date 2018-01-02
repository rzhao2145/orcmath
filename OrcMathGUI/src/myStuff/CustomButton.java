package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiPlayer.CustomLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button implements CustomLabel{

	private String string1;
	private String string2;
	

	public CustomButton(int x, int y) {
		super(x,y, 300,100,"",null);
		string1 = "String 1";
		string2 = "String 2";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateString1(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateString2(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIconColor(Color color) {
		// TODO Auto-generated method stub
		
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.drawString(string1, 200, 200);
		g.drawString(string2, 200, 300);
		g.setColor(Color.BLACK);
		
	}

}
