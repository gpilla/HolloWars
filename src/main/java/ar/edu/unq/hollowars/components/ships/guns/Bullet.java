package ar.edu.unq.hollowars.components.ships.guns;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.colissions.CollisionDetector;

import ar.edu.unq.hollowars.components.Ship;
import ar.edu.unq.hollowars.components.strategies.BulletStrategy;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Bullet extends GameComponent<HolloWarsLevel> {
	
	private BulletStrategy bulletStrategy;
	private double i;
	private double j;
	private double speed;
	
	// Bullet
	public Bullet(double x, double y, BulletStrategy bulletStrategy) {
		this.setBulletStrategy(bulletStrategy);
		this.setAppearance(new Circle(bulletStrategy.getColor(), 8));
		
		this.setX(x);
		this.setY(y);
		this.setI(bulletStrategy.getI());
		this.setJ(bulletStrategy.getJ());
		this.setSpeed(bulletStrategy.getSpeed());
		
		this.setZ(50);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		
		double advanced = this.getSpeed() * deltaState.getDelta();
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
		this.getBulletStrategy().checkColitions(deltaState, this);
	}
	
	public boolean checkColitionWithShip(Ship enemy) {
		return CollisionDetector.INSTANCE.collidesCircleAgainstRect(this.getX(), this.getY(), 4, enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
	}

	public BulletStrategy getBulletStrategy() {
		return bulletStrategy;
	}

	public void setBulletStrategy(BulletStrategy bulletStrategy) {
		this.bulletStrategy = bulletStrategy;
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
