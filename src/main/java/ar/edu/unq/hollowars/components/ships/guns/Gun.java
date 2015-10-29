package ar.edu.unq.hollowars.components.ships.guns;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

import ar.edu.unq.hollowars.components.PlayerShip;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Gun extends GameComponent<HolloWarsLevel> {

	public static final double COLD_DOWN_TIME = 0.3;
	private double coldDown = 0;
	
	private PlayerShip ship;
	
	public Gun(PlayerShip ship) {
		this.setShip(ship);
	}
	
	public void shoot(double delta) {
		if( this.coldDown(delta) ){
			Bullet  bullet = new Bullet(this.getX(), this.getY());
			this.getScene().addComponent(bullet);
		}
	}

	private boolean coldDown(double delta) {
		if ( this.coldDown <= 0 ) {
			this.coldDown = COLD_DOWN_TIME;
			return true;
		}
		this.coldDown -= delta;
		return false;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		this.setX(this.getShip().getCenterX());
		this.setY(this.getShip().getCenterY());
		super.update(deltaState);
	}

	public PlayerShip getShip() {
		return ship;
	}

	public void setShip(PlayerShip ship) {
		this.ship = ship;
	}
	
}
