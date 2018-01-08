package guiPlayer.simon;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressAnnie extends Component implements ProgressInterfaceRaymond {
	
	private int round;
	private int sequenceSize;

	public ProgressAnnie(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRound(int round) {
		this.round = round;
	}

	@Override
	public void setSequenceSize(int size) {
		this.sequenceSize = size;
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
