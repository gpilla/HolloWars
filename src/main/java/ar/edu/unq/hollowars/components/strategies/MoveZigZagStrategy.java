package ar.edu.unq.hollowars.components.strategies;

import com.uqbar.vainilla.DeltaState;

public class MoveZigZagStrategy extends MoveStrategy {
		
		public MoveZigZagStrategy(){
			this.i = 1;
			this.j = 1;
			this.speed = 0;
			this.maxSpeed = 500;
			this.acceleration = 1.5;
		}	
		
		
		protected void variante(DeltaState deltaState){
			int t = (int) (deltaState.getDelta()*1000);
			System.out.println(deltaState.getDelta()*1000);
			
			if(t>0){
				System.out.println(t);		
			}
			
			if(t%8 ==0){
				this.i = this.i*-1;
			}
		}
}
