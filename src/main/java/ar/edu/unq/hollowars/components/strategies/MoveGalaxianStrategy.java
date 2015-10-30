package ar.edu.unq.hollowars.components.strategies;

import com.uqbar.vainilla.DeltaState;

public class MoveGalaxianStrategy extends MoveStrategy {
		
	private double time = 0;
	private double timeLimit = 1.5;
	private boolean atPosition = false;
	private int yPosition = 200;
	
	@Override
	protected void setShipConfig() {
		this.getShip().setI(0);
		this.getShip().setJ(1);
		this.getShip().setSpeed(0);
		this.getShip().setMaxSpeed(75);
		this.getShip().setAcceleration(1.5);
	}

	protected void variante(DeltaState deltaState) {
		
		if (this.getShip().getY() >= this.yPosition && !this.atPosition) {
			this.atPosition = true;
			this.getShip().setJ(0);
			this.getShip().setI(1);
		}
		
		
		int choan = this.getShip().getGame().getDisplayWidth();
		
		time += deltaState.getDelta();
		
		if(this.getShip().getX() <= 0 || this.getShip().getX() >= choan  || time >= timeLimit){
			inverseI();
			time = 0;
		}
	}
}
