package ar.edu.unq.hollowars.components.strategies;

import com.uqbar.vainilla.DeltaState;

public class MoveZigZagStrategy extends MoveStrategy {
		
	
		
		
		protected void variante(DeltaState deltaState){
			int t = (int) (deltaState.getDelta()*1000);
			System.out.println(deltaState.getDelta()*1000);
			
			if(t>0){
				System.out.println(t);		
			}
			
			if(t%8 >=0){
				inverseI();
			}
		}

		@Override
		protected void setShipConfig() {
			this.getShip().setI(1);
			this.getShip().setJ(1);
			this.getShip().setSpeed(0);
			this.getShip().setMaxSpeed(50);
			this.getShip().setAcceleration(1.5);
		}

}
