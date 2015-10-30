package ar.edu.unq.hollowars.components.ui;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class DownIcon extends GameComponent {
	
	public DownIcon() {
		this.setX(650);
		this.setY(7);
	}
	
	@Override
	public void onSceneActivated() {
		this.setAppearance(Sprite.fromImage("images/down.png").scaleTo(30, 30));
		super.onSceneActivated();
	}
	
}
