package ar.edu.unq.hollowars.components;

import java.awt.Color;
import java.util.Random;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.appearances.Sprite;

import ar.edu.unq.hollowars.components.strategies.MoveStrategy;
import ar.edu.unq.hollowars.components.strategies.MoveZigZagStrategy;

public class EnemyShip extends Ship {

	private int height = 50;
	private int width = 30;
	private double speed = 0;
	private double maxSpeed = 500;
	private double acceleration = 1.5;
	private double i,j;
	
	private double spawnTime;
	private MoveStrategy estategiaDeMovimiento = new MoveZigZagStrategy();

	public EnemyShip() {
		this.setAppearance(new Rectangle(Color.RED, width, height));
		this.setAppearance(Sprite.fromImage("images/1942Sheet1.png").crop(92, 374, 12, 25).scaleTo(width, height));
		this.setX(0);
		this.setY(0);
		this.setZ(30);
		this.setSpawnTime(spawnTime);
		
		this.estategiaDeMovimiento.setShip(this);
	}

	@Override
	public void update(DeltaState deltaState) {
		
		if (checkSpawmColdDown(deltaState) ) {
			this.estategiaDeMovimiento.update(deltaState);
		}
		
		if (Math.random()* 100 < 10) {
			this.getGun().shoot(deltaState.getDelta());
		}
		
		super.update(deltaState);
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

	public EnemyShip setMoveStrategy(MoveStrategy startegy) {
		this.estategiaDeMovimiento = startegy;
		this.estategiaDeMovimiento.setShip(this);
		return this;
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public void hit() {
		getScene().enemyShipDestroyed(this);
	}

}