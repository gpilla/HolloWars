package ar.edu.unq.hollowars.components.strategies;

import java.awt.Color;
import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.sound.Sound;

import ar.edu.unq.hollowars.components.Ship;
import ar.edu.unq.hollowars.components.ships.guns.Bullet;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public abstract class BulletStrategy {
	
	
	private double speed = 500;
	private Color color = Color.ORANGE;
	private double i, j;
	
	private ArrayList<Ship> enemyShips;
	private Sound sound;
	
	public abstract void checkColitions(DeltaState deltaState, Bullet bullet);

	public ArrayList<Ship> getEnemyShips() {
		return enemyShips;
	}

	public void setEnemyShips(ArrayList<Ship> enemyShips) {
		this.enemyShips = enemyShips;
	}

	public void move(DeltaState deltaState, Bullet bullet) {
		double advanced = this.getSpeed() * deltaState.getDelta();
		bullet.move(this.getI() * advanced, this.getJ() * advanced);
		if(this.getSpeed() > 100 ) {
			System.out.println(this.getSpeed());
		}
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}
	
}
