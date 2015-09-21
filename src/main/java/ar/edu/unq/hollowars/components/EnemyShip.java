package ar.edu.unq.hollowars.components;

import java.awt.Color;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;

import ar.edu.unq.hollowars.levels.Level1;

public class EnemyShip extends GameComponent<Level1> {

	private int height = 20;
	private int width = 20;
	private double speed = 0;
	private double maxSpeed = 500;
	private double acceleration = 1.5;
	private double i, j;

	public EnemyShip(double x, double y) {
		this.setAppearance(new Rectangle(Color.RED, width, height));
		this.setX(x);
		this.setY(y);

		// Configuro en caida perpendicular
		this.i = 0;
		this.j = 1;
	}

	@Override
	public void update(DeltaState deltaState) {
		this.speed += this.acceleration + deltaState.getDelta();
		double advanced = Math.min(this.maxSpeed, this.speed) * deltaState.getDelta();

		this.move(this.i * advanced, this.j * advanced);

		if (this.getY() > this.getGame().getDisplayHeight()) {
			this.getScene().destroyEnemyShip(this);
		}

		super.update(deltaState);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}