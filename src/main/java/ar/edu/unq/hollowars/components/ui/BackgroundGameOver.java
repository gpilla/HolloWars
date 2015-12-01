package ar.edu.unq.hollowars.components.ui;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.Sprite;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class BackgroundGameOver extends GameComponent<HolloWarsLevel> {

	public BackgroundGameOver() {
		
	}
	
	@Override
	public void onSceneActivated() {
				
		this.setAppearance(Sprite.fromImage("images/holloAlpha.png").scale(0.17)
		);
		this.setX(00);
		this.setY(this.getGame().getDisplayHeight()-this.getAppearance().getHeight());
		
		super.onSceneActivated();
	}
	
}
