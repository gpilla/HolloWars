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
			for (int i = 0; i < Integer.parseInt(linea[2]);  i++) {
				try {
					enemy = ((EnemyShip) Class.forName("ar.edu.unq.hollowars.components."+linea[1]).newInstance())
							.setStartingX(Integer.parseInt(linea[3]))
							.setStartingY(Integer.parseInt(linea[4]))
							.setSpawnTime(Integer.parseInt(linea[0]));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
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
