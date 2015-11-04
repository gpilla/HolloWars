package ar.edu.unq.hollowars.levels;


import java.util.ArrayList;

import ar.edu.unq.hollowars.components.EnemyShip;
import ar.edu.unq.hollowars.components.PlayerShip;
import ar.edu.unq.hollowars.components.Ship;
import ar.edu.unq.hollowars.components.strategies.MoveStrategy;
import ar.edu.unq.hollowars.components.ui.LifesLabel;
import ar.edu.unq.hollowars.components.ui.PointsLabel;
import ar.edu.unq.hollowars.parser.ReadCSV;

public class Level1 extends HolloWarsLevel {
	
	private ArrayList<Ship> enemyShips = new ArrayList<Ship>();
	private PlayerShip playerShip;
	private LifesLabel lifesLabel;
	private PointsLabel pointsLabel;
	private MoveStrategy startegy;
		
	public ArrayList<Ship> getEnemyShips() {
		return enemyShips;
	}

	public void setEnemies(ArrayList<Ship> enemyShips) {
		this.enemyShips = enemyShips;
	}
	
	public void addEnemy(Ship enemyShip)
	{
		this.getEnemyShips().add(enemyShip);
		this.addComponent(enemyShip);
	}
	
	public void removeEnemy(Ship enemyShip)
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
		enemyShip.destroy();
	}
	
}
