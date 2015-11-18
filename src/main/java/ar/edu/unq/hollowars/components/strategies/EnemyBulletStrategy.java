package ar.edu.unq.hollowars.components.strategies;

import java.awt.Color;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.sound.SoundBuilder;

import ar.edu.unq.hollowars.components.Ship;
import ar.edu.unq.hollowars.components.ships.guns.Bullet;

public class EnemyBulletStrategy extends BulletStrategy {

	public EnemyBulletStrategy() {
		this.setI(0);
		this.setJ(1);
		this.setSpeed(100);
		this.setColor(Color.RED);
		
		this.setSound(new SoundBuilder().buildSound("/sounds/hit.wav"));
	
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
