package guiPlayer;
import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Countries extends Component {

	private String country;
	private String capital;
	private String monthVisited;
	
	public Countries(String country, String capital, String monthVisited) {
		super(40, 40, 256, 256);		 
		this.country = country;
		this.capital = capital;
		this.monthVisited = monthVisited;
//		addSequence("resources/movingSprite.png", 150, 0, 0, 256, 256, 6);
//		Thread animation = new Thread(this);
//		animation.start();
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
//		super.update(g);
		
	}
	
	public String toString() {
		return country + "," + capital + "," + monthVisited;
	}
}