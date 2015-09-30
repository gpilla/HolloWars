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
	private double spawnTime;

	public EnemyShip() {
		this.setAppearance(new Rectangle(Color.RED, width, height));
		this.setX(0);
		this.setY(0);
		this.setSpawnTime(spawnTime);

		// Configuro en caida perpendicular
		this.i = 0;
		this.j = 1;
	}

	@Override
	public void update(DeltaState deltaState) {
		
		if (checkSpawmColdDown(deltaState) ) {
			move(deltaState);
		}
		
		super.update(deltaState);
	}

	private void move(DeltaState deltaState) {
		this.speed += this.acceleration + deltaState.getDelta();
		double advanced = Math.min(this.maxSpeed, this.speed) * deltaState.getDelta();

		this.move(this.i * advanced, this.j * advanced);

		if (this.getY() > this.getGame().getDisplayHeight()) {
			this.getScene().destroyEnemyShip(this);
		}
	}

	private boolean checkSpawmColdDown(DeltaState deltaState) {
		if (this.getSpawnTime() > 0) {
			this.setSpawnTime(this.getSpawnTime() - deltaState.getDelta());
			return false;
		}
		return true;
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
	
	public EnemyShip setStartingX(double x) {
		super.setX(x);
		return this;
	}
	
	public EnemyShip setStartingY(double y) {
		super.setY(y);
		return this;
	}

	public double getSpawnTime() {
		return spawnTime;
	}

	public EnemyShip setSpawnTime(double spawnTime) {
		this.spawnTime = spawnTime;
		return this;
	}

}