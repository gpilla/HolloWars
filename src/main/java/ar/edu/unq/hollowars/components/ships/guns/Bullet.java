package ar.edu.unq.hollowars.components.ships.guns;

import java.awt.Color;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Bullet extends GameComponent<HolloWarsLevel> {
	
	private double speed = 100;
	private double i, j;
	
	public Bullet(double x, double y) {
		this.setAppearance(new Circle(Color.GREEN, 5));
		this.setX(x);
		this.setY(y);
		
		this.setI(0);
		this.setJ(-1);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		 
		double advanced = this.speed * deltaState.getDelta();
		
		this.move(this.getI() * advanced, this.getJ() * advanced);
		super.update(deltaState);
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
	
	
	
	
}
