package guiPlayer.simon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressAnnie extends Component implements ProgressInterfaceRaymond {
	
	private boolean gameOver;
	private int round;
	private int sequenceSize;

	public ProgressAnnie(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();
	}

	@Override
	public void setRound(int round) {
		this.round = round;
		update();
	}

	@Override
	public void setSequenceSize(int size) {
		this.sequenceSize = size;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		if(gameOver) {
			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
			g.drawString("GAME OVER!", 0, 40);
		} else {
			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 20));
			g.drawString("ROUND: " + round, 0, 20);
			g.drawString("SEQUENCE LENGTH: " + sequenceSize, 0, 60);
		}
	}

	public boolean isGameOver() {
		return gameOver;
	}

}
