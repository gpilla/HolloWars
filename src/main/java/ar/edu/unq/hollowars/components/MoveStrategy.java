package ar.edu.unq.hollowars.components;

import com.uqbar.vainilla.DeltaState;

public abstract class MoveStrategy {
	
	protected EnemyShip ship;
	
	protected double speed = 0;
	protected double maxSpeed = 500;
	protected double acceleration = 1.5;
	protected double i,j;
	
	public EnemyShip getNave() {
		return ship;
	}
	public void setNave(EnemyShip nave) {
		this.ship = nave;
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
	
	public void update(DeltaState deltaState) {
		this.speed += this.acceleration + deltaState.getDelta();
		double advanced = Math.min(this.maxSpeed, this.speed) * deltaState.getDelta();
		
		this.ship.move(this.i * advanced, this.j * advanced);
		
		if (this.ship.getY() > this.ship.getGame().getDisplayHeight()) {
			this.ship.getScene().destroyEnemyShip(this.ship);
		}
		this.variante(deltaState);
	}
	private void variante(DeltaState deltaState) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
