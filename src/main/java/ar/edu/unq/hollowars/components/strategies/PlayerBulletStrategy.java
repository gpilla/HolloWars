package ar.edu.unq.hollowars.components.strategies;

import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.sound.SoundBuilder;

import ar.edu.unq.hollowars.components.Ship;

public class PlayerBulletStrategy extends BulletStrategy {

	public PlayerBulletStrategy() {
		this.setSound(new SoundBuilder().buildSound("/sounds/hit.wav"));
	}
	
	@Override
	public void checkColitions(DeltaState deltaState) {
		ArrayList<Ship> enemies = new ArrayList<Ship>( getEnemyShips() );
		for (Ship enemy : enemies) {
			if ( this.getBullet().checkColitionWithShip(enemy) ) {
				enemy.hit();
				this.getBullet().destroy();
			}
		}
	}

}
