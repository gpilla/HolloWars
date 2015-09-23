package ar.edu.unq.hollowars.levels;

import java.util.ArrayList;

import com.uqbar.vainilla.GameScene;

import ar.edu.unq.hollowars.components.EnemyShip;
import ar.edu.unq.hollowars.components.PlayerShip;
import ar.edu.unq.hollowars.components.ui.LifesLabel;
import ar.edu.unq.hollowars.components.ui.PointsLabel;
import ar.edu.unq.hollowars.parser.ReadCSV;

public class Level1 extends GameScene {
	
	private ArrayList<EnemyShip> enemyShips;
	private PlayerShip playerShip;
	private LifesLabel lifesLabel;
	private PointsLabel pointsLabel;
	
	public Level1() {
		this.setEnemies(new ArrayList<EnemyShip>());
		
		this.addComponent(new PlayerShip());
		
		generateEnemies();
		
		generateUI();
	}

	private void generateUI() {
		lifesLabel = new LifesLabel(10, 10);
		this.addComponent(lifesLabel);
		pointsLabel = new PointsLabel(600, 10);
		this.addComponent(pointsLabel);
	}

	private void generateEnemies() {
		
		ArrayList<String[]> waves = null;
		EnemyShip enemy = null;
		
		try {
			waves = new ReadCSV("lvlConfigs/"+this.getClass().getSimpleName()+".csv").run();
		} catch (Exception e) {
			System.out.println("me rompo");
		}	
		for (String[] linea : waves) {
			for (int i = 0; i < linea[1];  i++) {
				String string = linea[i];
				enemy = new EnemyShip()
						.setStartingX(linea[3])
						.setStartingY(linea[4])
						.setSpawnTime(linea[0]);
					
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

	public void destroyEnemyShip(EnemyShip enemyShip) {
		enemyShip.setY(0);;
	}
	
}
