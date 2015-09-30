package ar.edu.unq.hollowars.components;

import com.uqbar.vainilla.DeltaState;

public class MoveZigZagStrategy extends MoveStrategy {
		
		public MoveZigZagStrategy(){
			this.i = 1;
			this.j = 1;
			this.speed = 0;
			this.maxSpeed = 500;
			this.acceleration = 1.5;
		}	
		
		public void update(DeltaState deltaState) {
			this.speed += this.acceleration + deltaState.getDelta();
			double advanced = Math.min(this.maxSpeed, this.speed) * deltaState.getDelta();
			
			this.ship.move(this.i * advanced, this.j * advanced);
			
			if (this.ship.getY() > this.ship.getGame().getDisplayHeight()) {
				this.ship.getScene().enemyShipDestroyed(this.ship);
			}
			this.variante(deltaState);
		}
		@SuppressWarnings("unused")
		private void variante(DeltaState deltaState){
			System.out.println(deltaState.getDelta());
			if((deltaState.getDelta()*100000)%1 ==0){
				this.i = this.i*-1;
			}
		}
}
