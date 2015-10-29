package ar.edu.unq.hollowars.components.ships.guns;

import java.awt.Color;
import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.colissions.CollisionDetector;

import ar.edu.unq.hollowars.components.EnemyShip;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Bullet extends GameComponent<HolloWarsLevel> {
	
	private double speed = 500;
	private double i, j;
	
	// Bullet
	public Bullet(double x, double y) {
		this.setAppearance(new Circle(Color.BLACK, 5));
		this.setX(x);
		this.setY(y);
		
		this.setI(0);
		this.setJ(-1);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		 
		double advanced = this.speed * deltaState.getDelta();
		
		this.move(this.getI() * advanced, this.getJ() * advanced);
		this.checkColitions(deltaState);
		
		if (this.getY() < 0) {
			this.destroy();
		}
		
		super.update(deltaState);
	}

	private void checkColitions(DeltaState deltaState) {
		ArrayList<EnemyShip> enemies = new ArrayList<EnemyShip>( this.getScene().getEnemyShips() );
		for (EnemyShip enemy : enemies) {
			if ( this.checkColitionWithEnemy(enemy) ) {
				this.getScene().enemyShipDestroyed(enemy);
			}
		}
	}
	
	private boolean checkColitionWithEnemy(EnemyShip enemy) {
		return CollisionDetector.INSTANCE.collidesRectAgainstRect(this.getX(), this.getY(), this.getWidth(), this.getHeight(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
	}
	
	private int getWidth() {
		return (int) this.getAppearance().getWidth();
	}
	
	private int getHeight() {
		return (int) this.getAppearance().getHeight();
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
