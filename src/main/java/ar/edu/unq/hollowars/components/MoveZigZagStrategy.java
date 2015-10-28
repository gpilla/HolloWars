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
		
		@SuppressWarnings("unused")
		private void variante(DeltaState deltaState){
			if((deltaState.getDelta()*100000)%1 ==0){
				this.i = this.i*-1;
			}
		}
}
