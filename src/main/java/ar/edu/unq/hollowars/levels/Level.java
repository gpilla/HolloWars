package ar.edu.unq.hollowars.levels;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.uqbar.vainilla.GameScene;

import ar.edu.unq.hollowars.components.EnemyShip;
import ar.edu.unq.hollowars.components.PlayerShip;
import ar.edu.unq.hollowars.components.ui.LifesLabel;
import ar.edu.unq.hollowars.components.ui.PointsLabel;

public class Level extends GameScene {
	
	private ArrayList<EnemyShip> enemyShips;
	private PlayerShip playerShip;
	private int points;
	private int lifes;
	private LifesLabel lifesLabel;
	private PointsLabel pointsLabel;
	
	public Level() {
		generateUI();
		
		this.setPoints(0);
		this.setLifes(3);
		
		generatePlayer();
		generateEnemies();		
	}

	private void generatePlayer() {
		this.addComponent(new PlayerShip());
	}

	private void generateUI() {
		lifesLabel = new LifesLabel(10, 10);
		this.addComponent(lifesLabel);
		pointsLabel = new PointsLabel(600, 10);
		this.addComponent(pointsLabel);
	}

	private void generateEnemies() {
		this.setEnemies(new ArrayList<EnemyShip>());
		
		EnemyShip enemy = null;
		for (int j = 0; j < 1; j++) {
			for (int i = 0; i < 10; i++) {
				double x = 100 * i;
				enemy = new EnemyShip()
					.setStartingX(x)
					.setStartingY(-30)
					.setSpawnTime(3 * j);
				
				this.addEnemy(enemy);
			}
		}
	}
	
	public ArrayList<EnemyShip> getEnemyShips() {
		return enemyShips;
	}

	public void setEnemies(ArrayList<EnemyShip> enemyShips) {
		this.enemyShips = enemyShips;
	}
	
	public void addEnemy(EnemyShip enemyShip)
	{
		this.getEnemyShips().add(enemyShip);
		this.addComponent(enemyShip);
	}
	
	public void removeEnemy(EnemyShip enemyShip)
	{
		this.getEnemyShips().remove(enemyShip);
	}

	public PlayerShip getPlayerShip() {
		return playerShip;
	}

	public void setPlayerShip(PlayerShip playerShip) {
		this.playerShip = playerShip;
	}

	public void enemyShipDestroyed(EnemyShip enemyShip) {
		this.setPoints(this.getPoints() + 10);
		this.getEnemyShips().remove(enemyShip);
		enemyShip.destroy();
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
		this.pointsLabel.setValue(this.points);
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	
}
