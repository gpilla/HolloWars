package ar.edu.unq.hollowars.components.ui;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

import ar.edu.unq.hollowars.components.EnemyShip;
import ar.edu.unq.hollowars.components.animations.ExplotionAnimation;

public class Explotion extends GameComponent {
	
	private double time;
	
	public Explotion(EnemyShip ship) {
		ExplotionAnimation animation = ExplotionAnimation.getInstance();
		animation.restart();
		time = animation.getDuration();
		this.setAppearance(animation);
		this.alignHorizontalCenterTo(ship.getX());
		this.alignVerticalCenterTo(ship.getY());
	}
	
	@Override
	public void update(DeltaState deltaState) {
		time -= deltaState.getDelta();
		if (time <= 0) {
			destroy();
		}
		super.update(deltaState);
	}
	
}
