package guiPlayer.simon;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenRaymond extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextLabel label;
	private ButtonInterfaceRaymond[] buttons;
	private ProgressInterfaceRaymond progress;
	private ArrayList<MoveInterfaceRaymond> sequence;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenRaymond(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		label.setText("");
		if(!progress.isGameOver()) {
			nextRound();
		} else
			acceptingInput = false;
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		acceptingInput = false;
		roundNumber++;
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("SIMON'S TURN");
		label.setText("");
		playSequence();
		changeText("YOUR TURN");
		acceptingInput = true;
		sequenceIndex = 0;
	}
	
	public void changeText(String s) {
		label.setText(s);
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void playSequence() {
		ButtonInterfaceRaymond b;
		for(int i = 0; i < sequence.size(); i++) {
			b = sequence.get(i).getButton();
			b.highlight();
			int sleepTime = (10/roundNumber) * 100;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			b.dim();
		}
	}
	
	

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for (ButtonInterfaceRaymond b : buttons) {
			viewObjects.add(b);
		}
		progress = getProgress();
		label = new TextLabel(100, 100, 300, 40, "LET'S PLAY SIMON!");
		label.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 20));
		sequence = new ArrayList<MoveInterfaceRaymond>();
		// add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);

	}

	/**
	 * Placeholder until partner finishes implementation of ProgressInterface
	 */
	private ProgressInterfaceRaymond getProgress() {
		return new ProgressAnnie(100, 320, 300, 100);
	}

	private void addButtons() {
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceRaymond[numberOfButtons];

		Color[] colors = new Color[numberOfButtons];
		colors[0] = Color.orange;
		colors[1] = Color.blue;
		colors[2] = Color.red;
		colors[3] = Color.pink;
		colors[4] = Color.yellow;
		colors[5] = Color.green;

		for (int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceRaymond b = getAButton();
			b.setColor(colors[i]);
			b.setX((int) ((i + 1) * 100));
			b.setY(180);
			buttons[i] = b;
			b.setAction(new Action() {

				@Override
				public void act() {
					if (acceptingInput) {
						Thread blink = new Thread(new Runnable() {

							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
									} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
									b.dim();
							}

						});
						blink.start();
						if(b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						} else {
							progress.gameOver();
							label.setText("");
						}
						if(sequenceIndex == sequence.size() || progress.isGameOver()){ 
						    Thread nextRound = new Thread(SimonScreenRaymond.this); 
						    nextRound.start(); 
						}
					}
				}

			});
		}
	}

	private ButtonInterfaceRaymond getAButton() {
		return new ButtonAnnie(0, 0, 80, 80, "", null);
	}

	private MoveInterfaceRaymond randomMove() {
		int bIndex = (int) (Math.random() * buttons.length);
		while (bIndex == lastSelectedButton) {
			bIndex = (int) (Math.random() * buttons.length);
		}
		lastSelectedButton = bIndex;
		return getMove(bIndex);
	}

	/**
	 * Placeholder until partner finishes implementation of MoveInterface
	 */
	private MoveInterfaceRaymond getMove(int bIndex) {
		return new MoveAnnie(buttons[bIndex]);
	}
		
}
