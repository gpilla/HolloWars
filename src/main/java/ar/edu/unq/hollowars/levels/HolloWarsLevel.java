package ar.edu.unq.hollowars.levels;

import java.util.ArrayList;

import com.uqbar.vainilla.GameScene;

import ar.edu.unq.hollowars.GameOverScene;
import ar.edu.unq.hollowars.components.EnemyShip;
import ar.edu.unq.hollowars.components.PlayerShip;
import ar.edu.unq.hollowars.components.ships.guns.Gun;
import ar.edu.unq.hollowars.components.strategies.MoveVerticalStrategy;
import ar.edu.unq.hollowars.components.ui.Background;
import ar.edu.unq.hollowars.components.ui.Cloud;
import ar.edu.unq.hollowars.components.ui.LifesLabel;
import ar.edu.unq.hollowars.components.ui.PointsLabel;
import ar.edu.unq.hollowars.parser.ReadCSV;

public abstract class HolloWarsLevel extends GameScene {
	
	protected ArrayList<EnemyShip> enemyShips;
	protected PlayerShip playerShip;
	protected int points;
	protected int lifes;
	protected LifesLabel lifesLabel;
	protected PointsLabel pointsLabel;
	
	@Override
	public void onSetAsCurrent() {
		enemyShips = new ArrayList<EnemyShip>();
		this.generateUI();
		
		this.setPoints(0);
		this.setLifes(3);
		
		generatePlayer();
		generateEnemies();
		
		super.onSetAsCurrent();
	}

	private void generatePlayer() {
		this.setPlayerShip(new PlayerShip());
		this.addComponent(this.getPlayerShip());
		Gun gun = new Gun(this.getPlayerShip());
		this.addComponent(gun);
		this.getPlayerShip().setGun(gun);
	}

	private void generateUI() {
		this.addComponent(new Background());
		this.addComponent(new Cloud());
		this.addComponent(new Cloud());
		this.addComponent(new Cloud());
		lifesLabel = new LifesLabel(10, 10);
		this.addComponent(lifesLabel);
		pointsLabel = new PointsLabel(600, 10);
		this.addComponent(pointsLabel);
		
	}

	private void generateEnemies() {
		ArrayList<String[]> waves = null;
		EnemyShip enemy = null;
		
		try {
			waves = new ReadCSV("src/main/resources/config/levels/"+this.getClass().getSimpleName()+".csv").run();
		} catch (Exception e) {
			System.out.println("No se encontro el archivo de configuración");
		}	
		for (String[] linea : waves) {
			for (int i = 0; i < Integer.parseInt(linea[2]);  i++) {
				try {
					enemy = ((EnemyShip) Class.forName("ar.edu.unq.hollowars.components."+linea[1]).newInstance())
							.setStartingX(Integer.parseInt(linea[3]))
							.setStartingY(Integer.parseInt(linea[4]))
							.setSpawnTime(Integer.parseInt(linea[0]))
							.setMoveStrategy(new MoveVerticalStrategy());
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
		this.lifesLabel.setValue(this.lifes);
	}

	public void playerShipDestroyed(PlayerShip playerShip) {
		this.setLifes(this.getLifes() - 1);
	}
	
	public void gameOver()
	{
		this.removeComponent(this.getPlayerShip());
		this.removeComponents(this.getEnemyShips());
	//	this.getGame().setCurrentScene(new GameOverScene());
	}
	
}
