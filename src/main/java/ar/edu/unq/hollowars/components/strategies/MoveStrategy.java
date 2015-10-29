package ar.edu.unq.hollowars.components.strategies;

import com.uqbar.vainilla.DeltaState;

import ar.edu.unq.hollowars.components.EnemyShip;

public abstract class MoveStrategy {
	
	protected EnemyShip ship;
	
	public EnemyShip getShip() {
		return ship;
	}
	
	public void setShip(EnemyShip nave) {
		this.ship = nave;
		this.setShipConfig();
	}
	
	protected abstract void setShipConfig();

	public double getI() {
		return this.getShip().getI();
	}
	public void setI(double i) {
		this.getShip().setI(i);
	}
	
	protected void inverseI() {
		this.setI(this.getI()*-1);
	}
	
	public double getJ() {
		return this.getShip().getJ();
	}
	public void setJ(double j) {
		this.getShip().setJ(j);
	}
	
	public void update(DeltaState deltaState) {
		double speed = this.getShip().getSpeed() + this.getShip().getAcceleration() / deltaState.getDelta();
		double advanced = Math.min(this.getShip().getMaxSpeed(), speed) * deltaState.getDelta();
		this.getShip().setSpeed(speed);
		
		this.ship.move(this.getI() * advanced, this.getJ() * advanced);
		
		if (this.ship.getY() > this.ship.getGame().getDisplayHeight()) {
			this.ship.getScene().getEnemyShips().remove(this.ship);
			this.ship.destroy();
		}
		this.variante(deltaState);
	}
	
	protected void variante(DeltaState deltaState) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
