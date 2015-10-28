package ar.edu.unq.hollowars.components.strategies;


public class MoveVerticalStrategy extends MoveStrategy {
		
		public MoveVerticalStrategy(){
			this.i = 0;
			this.j = 1;
			this.speed = 0;
			this.maxSpeed = 500;
			this.acceleration = 1.5;
		}	
}
