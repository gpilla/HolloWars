package ar.edu.unq.hollowars.components;

import com.uqbar.vainilla.GameComponent;

import ar.edu.unq.hollowars.components.ships.guns.Gun;
import ar.edu.unq.hollowars.components.strategies.BulletStrategy;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public abstract class Ship extends GameComponent<HolloWarsLevel> {

	private Gun gun = null;
	private BulletStrategy bulletStrategy;
	
	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		if (this.getGun() != null && this.getScene() != null) {
			this.getScene().removeComponent(this.getGun());
		}
		this.gun = gun;
		this.getGun().setShip(this);
	}
	
	public double getLeftLimit()
	{
		return 0;
	}
	
	public double getRightLimit() {
		return this.getGame().getDisplayWidth() - this.getWidth();
	}
	
	public double getTopLimit()
	{
		return 0;
	}
	
	public double getBottomLimit()
	{
		return this.getGame().getDisplayHeight() - this.getHeight();
	}

	public int getWidth() {
		return (int) this.getAppearance().getWidth();
	}
	
	public int getHeight() {
		return (int) this.getAppearance().getHeight();
	}
	
	public double getCenterX() {
		return this.getX() + this.getWidth() / 2;
	}
	
	public double getCenterY() {
		return this.getY() + this.getHeight() / 2;
	}
	
	public BulletStrategy getBulletStrategy() {
		return bulletStrategy;
	}

	public void setBulletStrategy(BulletStrategy bulletStrategy) {
		this.bulletStrategy = bulletStrategy;
	}

	public abstract void hit();
	
}
