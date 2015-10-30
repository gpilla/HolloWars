package ar.edu.unq.hollowars.components.ui;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.Sprite;

public class Island extends GameComponent {
	
	private double speed;

	@Override
	public void onSceneActivated() {
		
		this.setAppearance(this.getSprite());
		this.reset();
		super.onSceneActivated();
	}
	
	private Sprite getSprite() {
		return Sprite.fromImage("images/island.png").scaleTo(300, 150);
	}

	public void update(DeltaState deltaState) {
		double advanced = this.getSpeed() * deltaState.getDelta();
		
		this.move(0 * advanced, 1 * advanced);
		
		if (this.getY() > this.getGame().getDisplayHeight()) {
			reset();
		}
		super.update(deltaState);
	}
	
	private void reset() {
		this.setY(0-this.getAppearance().getHeight());
		this.setX(Math.random()*this.getGame().getDisplayWidth());
		this.setSpeed(50);
		this.setAppearance(this.getSprite().rotate(Math.random()*1));
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
