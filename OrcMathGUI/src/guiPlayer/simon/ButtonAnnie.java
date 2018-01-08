package guiPlayer.simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonAnnie extends Button implements ButtonInterfaceRaymond {
	
	private Color color;
	private Color color1;
	private Color color2;

	public ButtonAnnie(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public ButtonAnnie(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		color1 = color;
		int red = 255;
		int green = 255;
		int blue = 255;
		if(color1.getRed() < 200)
			red = color1.getRed() + 55;
		if(color1.getGreen() < 200)
			green = color1.getGreen() + 50;
		if(color1.getBlue() < 200)
			blue = color1.getBlue() + 50;
		color2 = new Color(red, green, blue);
	}

	@Override
	public void highlight() {
		color = color2;
		update();
	}

	@Override
	public void dim() {
		color = color1;
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setColor(color);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}
	
}
