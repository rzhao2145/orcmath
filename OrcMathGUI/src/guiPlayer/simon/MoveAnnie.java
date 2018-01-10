package guiPlayer.simon;

public class MoveAnnie implements MoveInterfaceRaymond {
	
	private ButtonInterfaceRaymond button;
	
	public MoveAnnie(ButtonInterfaceRaymond button) {
		this.button = button;
	}

	@Override
	public ButtonInterfaceRaymond getButton() {
		return button;
	}

}
