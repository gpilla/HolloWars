package ar.edu.unq.hollowars.components.ships.guns;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

import ar.edu.unq.hollowars.components.Ship;
import ar.edu.unq.hollowars.components.strategies.BulletStrategy;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Gun extends GameComponent<HolloWarsLevel> {

	public static final double COLD_DOWN_TIME = 0.3;
	private double coldDown = 0;
	private BulletStrategy bulletStrategy;
	
	private Ship ship;
	
	public void shoot(double delta) {
		if( this.coldDown(delta) ){
			Bullet  bullet = new Bullet(this.getX(), this.getY(), this.getShip().getBulletStrategy());
			this.getScene().addComponent(bullet);
		}
	}
	
	public void shoot(double delta, BulletStrategy bulletStrategy, HolloWarsLevel scene) {
		if( this.coldDown(delta) ){
			Bullet  bullet = new Bullet(this.getX(), this.getY(), bulletStrategy);
			scene.addComponent(bullet);
		}
	}

	protected boolean coldDown(double delta) {
		if ( this.getColdDown() <= 0 ) {
			this.setColdDown(COLD_DOWN_TIME);
			return true;
		}
		this.setColdDown(this.getColdDown() - delta);
		return false;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		this.setX(this.getShip().getCenterX());
		this.setY(this.getShip().getCenterY());
		super.update(deltaState);
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public BulletStrategy getBulletStrategy() {
		return bulletStrategy;
	}

	public void setBulletStrategy(BulletStrategy bulletStrategy) {
		this.bulletStrategy = bulletStrategy;
	}

	public double getColdDown() {
		return coldDown;
	}

	public void setColdDown(double coldDown) {
		this.coldDown = coldDown;
	}
	
}
