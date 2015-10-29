package ar.edu.unq.hollowars.components.strategies;


public class MoveVerticalStrategy extends MoveStrategy {

	@Override
	protected void setShipConfig() {
		this.getShip().setI(0);
		this.getShip().setJ(1);
		this.getShip().setSpeed(0);
		this.getShip().setMaxSpeed(500);
		this.getShip().setAcceleration(1.5);
	}
		
}
