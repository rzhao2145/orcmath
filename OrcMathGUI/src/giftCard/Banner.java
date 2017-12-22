package giftCard;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;

public class Banner extends MovingComponent {

	private BufferedImage img;
	private int topToBottom;
	private int leftToRight;
	
	public Banner(int w, int h) {
		super(900,100,500,137);
		img = new Graphic(0, 500,500,137, "resources/banner.png").getImage();
		setVx(-1.5);

		update();
		Thread t = new Thread(this);
		t.start();
//		setY((int)(Math.random()*h));
	}

	@Override
	public void drawImage(Graphics2D g) {
		if(img != null){
			g.drawImage(img, 0, 0, null);
		}
	}

	@Override
		public void checkBehaviors(){
			if(getX()+30<0) {
				setX(1000);
			}
		}
	

}