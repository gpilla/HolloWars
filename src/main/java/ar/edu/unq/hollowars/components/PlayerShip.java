package ar.edu.unq.hollowars.components;

import java.awt.Color;
import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.colissions.CollisionDetector;
import com.uqbar.vainilla.events.constants.Key;

import ar.edu.unq.hollowars.levels.Level1;

public class PlayerShip extends GameComponent<Level1> {
	
	public static final int SPEED = 300;
	public static final int NAVE_HEIGHT = 50;
	public static final int NAVE_WIDTH = 30;
	
	public PlayerShip() {
		this.setAppearance(new Rectangle(Color.BLUE, NAVE_WIDTH, NAVE_HEIGHT));
	}
	
	@Override
	public void onSceneActivated() {
		this.alignVerticalCenterTo(this.getGame().getDisplayHeight() - 100);
		this.alignHorizontalCenterTo(this.getGame().getDisplayWidth()/2);

		super.onSceneActivated();
	}
	
	@Override
	public void update(DeltaState deltaState) {
		this.checkKeyboard(deltaState);
		this.checkColitions(deltaState);
		super.update(deltaState);
	}

	private void checkKeyboard(DeltaState deltaState) {
		if(deltaState.isKeyBeingHold(Key.RIGHT)) {
			this.right(deltaState.getDelta());
		}
		if(deltaState.isKeyBeingHold(Key.LEFT)) {
			this.left(deltaState.getDelta());
		}
		if(deltaState.isKeyBeingHold(Key.UP)) {
			this.up(deltaState.getDelta());
		}
		if(deltaState.isKeyBeingHold(Key.DOWN)) {
			this.down(deltaState.getDelta());
		}
	}
	
	private void checkColitions(DeltaState deltaState) {
		ArrayList<EnemyShip> enemies = this.getScene().getEnemyShips();
		for (EnemyShip enemy : enemies) {
			if ( this.checkColitionWithEnemy(enemy) ) {
				System.out.println("Coliciono!");
				enemy.destroy();
			}
		}
	}

	private boolean checkColitionWithEnemy(EnemyShip enemy) {
		return CollisionDetector.INSTANCE.collidesRectAgainstRect(this.getX(), this.getY(), this.getWidth(), this.getHeight(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
	}

	public void left(double delta) {
		this.setX(Math.max(this.getLeftLimit(), this.getX()- SPEED * delta));
	}
	
	public void right(double delta) {
		this.setX(Math.min(this.getRightLimit(), this.getX()+ SPEED * delta));
	}

	public void down(double delta) {
		this.setY(Math.min(this.getBottomLimit(), this.getY() + SPEED * delta));
	}
	
	public void up(double delta) {
		this.setY(Math.max(this.getTopLimit() , this.getY()- SPEED * delta));
	}
	
	public double getLeftLimit()
	{
		return 0;
	}
	
	private double getRightLimit() {
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

	private int getWidth() {
		return (int) this.getAppearance().getWidth();
	}
	
	private int getHeight() {
		return (int) this.getAppearance().getHeight();
	}
	
}