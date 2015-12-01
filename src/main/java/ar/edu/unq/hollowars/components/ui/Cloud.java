package ar.edu.unq.hollowars.components.ui;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.Sprite;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Cloud extends GameComponent<HolloWarsLevel>{

	private double speed;
	
	public Cloud() {
		this.setZ(100);
	}
	
	@Override
	public void onSceneActivated() {
		resetCloud();
		Sprite[] sprites = new Sprite[10];
		sprites[0] = Sprite.fromImage("images/cloud/frame-1.png").scaleTo(100, 50);
		sprites[1] = Sprite.fromImage("images/cloud/frame-1.png").scaleTo(100, 50);
		sprites[2] = Sprite.fromImage("images/cloud/frame-1.png").scaleTo(100, 50);
		sprites[3] = Sprite.fromImage("images/cloud/frame-2.png").scaleTo(100, 50);
		sprites[4] = Sprite.fromImage("images/cloud/frame-3.png").scaleTo(100, 50);
		sprites[5] = Sprite.fromImage("images/cloud/frame-4.png").scaleTo(100, 50);
		sprites[6] = Sprite.fromImage("images/cloud/frame-5.png").scaleTo(100, 50);
		sprites[7] = Sprite.fromImage("images/cloud/frame-6.png").scaleTo(100, 50);
		sprites[8] = Sprite.fromImage("images/cloud/frame-7.png").scaleTo(100, 50);
		sprites[9] = Sprite.fromImage("images/cloud/frame-1.png").scaleTo(100, 50);
		this.setAppearance(new Animation(0.1, sprites));
		super.onSceneActivated();
	}
	
	@Override
	public void update(DeltaState deltaState) {
		double advanced = this.getSpeed() * deltaState.getDelta();
		
		this.move(0 * advanced, 1 * advanced);
		
		if (this.getY() > this.getGame().getDisplayHeight()) {
			resetCloud();
		}
		super.update(deltaState);
	}

	private void resetCloud() {
		this.setY(0-this.getAppearance().getHeight());
		this.setX(Math.random()*this.getGame().getDisplayWidth());
		this.setSpeed(100+Math.random()*200);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
