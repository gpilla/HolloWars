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
	
	// Bullet
	public Bullet(double x, double y, BulletStrategy bulletStrategy) {
		this.setBulletStrategy(bulletStrategy);
		this.setAppearance(new Circle(bulletStrategy.getColor(), 8));
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		
		this.getBulletStrategy().move(deltaState, this);
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
	
}
