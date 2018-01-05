package guiPlayer.simon;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceRaymond extends Visible{

	void gameOver();
	void setRound(int round);
	void setSequenceSize(int size);
}
