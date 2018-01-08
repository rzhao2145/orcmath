package guiPlayer.simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenRaymond extends ClickableScreen implements Runnable {

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
		label.setText("");
		nextRound();
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		acceptingInput = false;
		roundNumber++;
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
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
		ButtonInterfaceRaymond b = getAButton();
		for(int i = 0; i < sequence.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = sequence.get(i).getButton();
			b.highlight();
			int sleepTime = (10/roundNumber) * 100;
			Thread sleep = new Thread(new Runnable() {

				public void run() {
					try {
						Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
				}

			});
			sleep.start();
		}
		b.dim();
	}
	
	

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for (ButtonInterfaceRaymond b : buttons) {
			viewObjects.add(b);
		}
		progress = getProgress();
		label = new TextLabel(130, 230, 300, 40, "Let's play Simon!");
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
		return new ProgressAnnie(20, 20, 20, 20);
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
			b.setX(i * 20);
			b.setY(50);
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
					}
					if(b == sequence.get(sequenceIndex).getButton()) {
						sequenceIndex++;
					} else {
						progress.gameOver();
					}
					if(sequenceIndex == sequence.size()){ 
					    Thread nextRound = new Thread(SimonScreenRaymond.this); 
					    nextRound.start(); 
					}
				}

			});
		}
	}

	private ButtonInterfaceRaymond getAButton() {
		return new ButtonAnnie(0, 0, 20, 20, "", null);
	}

	private MoveInterfaceRaymond randomMove() {
		int bIndex = (int) (Math.random() * buttons.length);
		while (bIndex == lastSelectedButton) {
			bIndex = (int) (Math.random() * buttons.length);
		}
		return getMove(bIndex);
	}

	/**
	 * Placeholder until partner finishes implementation of MoveInterface
	 */
	private MoveInterfaceRaymond getMove(int bIndex) {
		return null;
	}
	
	public ArrayList<MoveInterfaceRaymond> getSequence() {
		return sequence;
	}



}
