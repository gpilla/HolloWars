package ar.edu.unq.hollowars.levels;

import java.util.ArrayList;

import com.uqbar.vainilla.GameScene;

import ar.edu.unq.hollowars.components.EnemyShip;
import ar.edu.unq.hollowars.components.PlayerShip;

public class Level1 extends GameScene {
	
	private ArrayList<EnemyShip> enemyShips;
	private PlayerShip playerShip;
	
	public Level1() {
		this.setEnemies(new ArrayList<EnemyShip>());
		
		this.addComponent(new PlayerShip());
		
		this.addEnemy(new EnemyShip(100, 0));
		this.addEnemy(new EnemyShip(200, 0));
		this.addEnemy(new EnemyShip(300, 0));
		this.addEnemy(new EnemyShip(400, 0));
		this.addEnemy(new EnemyShip(500, 0));
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

	public void destroyEnemyShip(EnemyShip enemyShip) {
		enemyShip.setY(0);;
	}
	
}
