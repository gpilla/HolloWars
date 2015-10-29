package ar.edu.unq.hollowars.components.strategies;

import com.uqbar.vainilla.DeltaState;

public class MoveGalaxianStrategy extends MoveStrategy {
		
		
		private double i = 0;

		protected void variante(DeltaState deltaState){
			
			int choan = this.getShip().getGame().getDisplayWidth();
			
			i += deltaState.getDelta();
			System.err.println(i);
			
			if(this.getShip().getX() <= 0 || this.getShip().getX() >= choan  || i >=1.5){
				inverseI();
				i = 0;
			}
				
				
		}


		@Override
		protected void setShipConfig() {
			this.getShip().setI(1);
			this.getShip().setJ(0);
			this.getShip().setSpeed(0);
			this.getShip().setMaxSpeed(100);
			this.getShip().setAcceleration(1.5);
		}
}
