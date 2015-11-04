package ar.edu.unq.hollowars.components.ships.guns;

import java.awt.Color;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.colissions.CollisionDetector;

import ar.edu.unq.hollowars.components.Ship;
import ar.edu.unq.hollowars.components.strategies.BulletStrategy;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Bullet extends GameComponent<HolloWarsLevel> {
	
	private double speed = 500;
	private double i, j;
	private BulletStrategy bulletStrategy;
	
	// Bullet
	public Bullet(double x, double y, BulletStrategy bulletStrategy) {
		this.setBulletStrategy(bulletStrategy);
		this.setAppearance(new Circle(Color.BLACK, 8));
		this.setX(x);
		this.setY(y);
		
		this.setI(0);
		this.setJ(-1);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		 
		double advanced = this.speed * deltaState.getDelta();
		
		this.move(this.getI() * advanced, this.getJ() * advanced);
		if (!this.isDestroyPending()) {
			this.checkColitions(deltaState);
		}
		
		if (this.getY() < 0) {
			this.destroy();
		}
		
		super.update(deltaState);
	}

	private void checkColitions(DeltaState deltaState) {
		this.getBulletStrategy().checkColitions(deltaState);
	}
	
	public boolean checkColitionWithShip(Ship enemy) {
		return CollisionDetector.INSTANCE.collidesCircleAgainstRect(this.getX(), this.getY(), 7, enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
	}
	
	private int getWidth() {
		return (int) this.getAppearance().getWidth();
	}
	
	private int getHeight() {
		return (int) this.getAppearance().getHeight();
	}

	public double getI() {
		return i;
	}

	public void setI(double i) {
		this.i = i;
	}

	public double getJ() {
		return j;
	}

	public void setJ(double j) {
		this.j = j;
	}

	public BulletStrategy getBulletStrategy() {
		return bulletStrategy;
	}

	public void setBulletStrategy(BulletStrategy bulletStrategy) {
		this.bulletStrategy = bulletStrategy;
		this.bulletStrategy.setBullet(this);
	}
	
}
