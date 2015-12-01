package ar.edu.unq.hollowars.components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;

import ar.edu.unq.hollowars.components.ships.guns.Bullet;
import ar.edu.unq.hollowars.components.ships.guns.Gun;
import ar.edu.unq.hollowars.components.strategies.BulletStrategy;
import ar.edu.unq.hollowars.components.strategies.EnemyBulletStrategy;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class BossEnemyShipTurret extends Gun {
	
	private BulletStrategy bulletStrategy;
	private double relativeX;
	private double relativeY;
	Sprite appearance = Sprite.fromImage("images/47750.png").crop(187, 0, 40, 40).scale(0.4);
	//Sprite appearance = Sprite.fromImage("images/47750.png").crop(185, 380, 40, 40).scale(0.4);
	
	private double i;
	private double j;
	
	public BossEnemyShipTurret(int x, double y, EnemyBulletStrategy bulletStrategy) {
		
		this.setAppearance(appearance);
		this.setRelativeX(x);
		this.setRelativeY(y);
		this.setBulletStrategy(bulletStrategy);
		
		this.setZ(2);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		searchForEnemy();
		if (Math.random()* 100 < 10) {
			this.shoot(deltaState.getDelta(), this.getBulletStrategy(), this.getScene());	
		}
	}
	
	public void shoot(double delta, BulletStrategy bulletStrategy, HolloWarsLevel scene) {
		if( this.coldDown(delta) ){
			Bullet  bullet = new Bullet(this.getX(), this.getY(), bulletStrategy);
			scene.addComponent(bullet);
			bullet.setI(this.getI());
			bullet.setJ(this.getJ());
			System.out.println(this.getJ());
		}
	}
	
	private void searchForEnemy() {
		double deltaX = this.getX() - this.getScene().getPlayerShip().getX(); 
		double deltaY = this.getY() - this.getScene().getPlayerShip().getY(); 
		
		double rads = Math.atan2(deltaY, deltaX);
		
		this.setI(Math.cos(rads)*-1);
		this.setJ(Math.sin(rads)*-1);
		updateAppearance(rads);
	}
	
	private void updateAppearance(double rotation) {
		this.setAppearance(appearance.rotate(rotation));
	}

	public BulletStrategy getBulletStrategy() {
		return bulletStrategy;
	}

	public void setBulletStrategy(BulletStrategy bulletStrategy) {
		this.bulletStrategy = bulletStrategy;
	}

	public double getRelativeX() {
		return relativeX;
	}

	public void setRelativeX(double relativeX) {
		this.relativeX = relativeX;
	}

	public double getRelativeY() {
		return relativeY;
	}

	public void setRelativeY(double relativeY) {
		this.relativeY = relativeY;
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
