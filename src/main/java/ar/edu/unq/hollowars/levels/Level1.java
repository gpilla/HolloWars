package ar.edu.unq.hollowars.levels;


import java.util.ArrayList;

import ar.edu.unq.hollowars.components.EnemyShip;
import ar.edu.unq.hollowars.components.EnemyShipHorde;
import ar.edu.unq.hollowars.components.PlayerShip;
import ar.edu.unq.hollowars.components.strategies.MoveStrategy;
import ar.edu.unq.hollowars.components.ui.LifesLabel;
import ar.edu.unq.hollowars.components.ui.PointsLabel;
import ar.edu.unq.hollowars.parser.ReadCSV;

public class Level1 extends HolloWarsLevel {
	
	private ArrayList<EnemyShip> enemyShips = new ArrayList<EnemyShip>();
	private PlayerShip playerShip;
	private LifesLabel lifesLabel;
	private PointsLabel pointsLabel;
	private MoveStrategy startegy;
	
	public Level1() {
//		this.setEnemies(new ArrayList<EnemyShip>());
//		
////		this.addComponent(new PlayerShip());
//		
//		generateEnemies();
//		
//		generateUI();
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
			String deltatime = linea[0];;
			String tipo = linea[1];
			String cantidad = linea[2];
			String x = linea[3];
			String y = linea[4];
			String strategyName = linea[5];

			for (int i = 0; i < Integer.parseInt(cantidad);  i++) {
//				for (int i = 0; i < 2;  i++) {
				try {
					startegy = (MoveStrategy) Class.forName("ar.edu.unq.hollowars.components.strategies.Move"+strategyName+"Strategy").newInstance(); 
					enemy = ((EnemyShip) Class.forName("ar.edu.unq.hollowars.components."+tipo).newInstance())
							.setStartingX(Integer.parseInt(x))
							.setStartingY(Integer.parseInt(y))
							.setSpawnTime(Integer.parseInt(deltatime))
							.setMoveStrategy(startegy);
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
		EnemyShipHorde x = new EnemyShipHorde();
		x.setSpawningPauseTime(0.3);
		x.setNaves(this.getEnemyShips());
		x.spawnShips();
		
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
		enemyShip.destroy();
	}
	
}
