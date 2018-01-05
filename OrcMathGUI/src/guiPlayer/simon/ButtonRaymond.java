package guiPlayer.simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonRaymond extends Button implements ButtonInterfaceRaymond{

	public ButtonRaymond(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
	}

	public void drawButton(Graphics2D g, boolean hover) {
		
	}
	
	
	
	
	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		
	}

}
