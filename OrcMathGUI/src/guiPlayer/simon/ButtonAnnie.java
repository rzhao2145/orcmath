package guiPlayer.simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonAnnie extends Button implements ButtonInterfaceRaymond {
	
	private Color color;

	public ButtonAnnie(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		update();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		setBackground(color.darker().darker());
		update();
	}

	@Override
	public void highlight() {
		setBackground(color);
		update();
	}

	@Override
	public void dim() {
		setBackground(color.darker());
		update();
	}
	
}
