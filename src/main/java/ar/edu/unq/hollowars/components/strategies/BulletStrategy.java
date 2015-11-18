package ar.edu.unq.hollowars.components.strategies;

import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.sound.Sound;

import ar.edu.unq.hollowars.components.Ship;
import ar.edu.unq.hollowars.components.ships.guns.Bullet;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public abstract class BulletStrategy {
	
	private Bullet bullet;
	private ArrayList<Ship> enemyShips;
	private Sound sound;
	
	public abstract void checkColitions(DeltaState deltaState);

	public Bullet getBullet() {
		return bullet;
	}

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}
	
	protected HolloWarsLevel getScene() {
		return this.getBullet().getScene();
	}

	public ArrayList<Ship> getEnemyShips() {
		return enemyShips;
	}

	public void setEnemyShips(ArrayList<Ship> enemyShips) {
		this.enemyShips = enemyShips;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}
	
}
