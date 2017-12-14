package guiPlayer;
import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Cat extends Component {

	public Cat() {
		 
		super(40, 40, 100, 100);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}

