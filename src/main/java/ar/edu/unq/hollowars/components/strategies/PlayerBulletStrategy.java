package ar.edu.unq.hollowars.components.strategies;

import java.awt.Color;
import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;

import ar.edu.unq.hollowars.components.Ship;
import ar.edu.unq.hollowars.components.ships.guns.Bullet;

public class PlayerBulletStrategy extends BulletStrategy {

	public PlayerBulletStrategy() {
		this.setI(0);
		this.setJ(-1);
		this.setColor(Color.BLACK);
	}
	
	@Override
	public void checkColitions(DeltaState deltaState, Bullet bullet) {
		ArrayList<Ship> enemies = new ArrayList<Ship>( getEnemyShips() );
		for (Ship enemy : enemies) {
			if ( bullet.checkColitionWithShip(enemy) ) {
				enemy.hit();
				bullet.destroy();
			}
		}
	}

}
