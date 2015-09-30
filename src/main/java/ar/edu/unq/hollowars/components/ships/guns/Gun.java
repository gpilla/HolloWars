package ar.edu.unq.hollowars.components.ships.guns;

import com.uqbar.vainilla.GameComponent;

import ar.edu.unq.hollowars.levels.Level;

public class Gun extends GameComponent<Level> {

	public static final double COLD_DOWN_TIME = 0.1;
	private double coldDown = 0;
	
	public void shoot(double delta) {
		if( this.coldDown(delta) ){
			System.out.println("Shoot!!!!");
			this.getScene().addComponent(new Bullet(this.getX(), this.getY()));
			
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
	
}
