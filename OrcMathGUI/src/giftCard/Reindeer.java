package giftCard;

import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;

public class Reindeer extends AnimatedComponent {

	public Reindeer(int x, int y, int w, int h) {
		super(x, y, w, h);
		addSequence("resources/reindeer.png",150,0,0,600/7,139,7);
		setVx(-1.5);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}
	
	public void update(Graphics2D g) {
		super.update(g);
		
	}
	
	public void checkBehaviors(){
		if(getX() + getWidth()<0) {
			setX(900);
		}
	}
}
