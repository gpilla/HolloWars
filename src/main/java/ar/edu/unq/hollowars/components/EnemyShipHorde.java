package ar.edu.unq.hollowars.components;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import ar.edu.unq.hollowars.levels.Level1;

public class EnemyShipHorde extends GameComponent<Level1> {

	private ArrayList<EnemyShip> naves = new ArrayList<EnemyShip>();
	private Double spawningPauseTime = 0.0;

	public EnemyShipHorde() {
		super();
	}
	
	public void spawnShips(){
		if(this.spawningPauseTime>0){
			int i = 0;
			for (EnemyShip enemyShip : naves) {
				enemyShip.setSpawnTime(enemyShip.getSpawnTime()+i+this.spawningPauseTime);
				i++;
			}			
		}
	}

	@Override
	public void update(DeltaState deltaState) {
		
	}

	public ArrayList<EnemyShip> getNaves() {
		return naves;
	}

	public void setNaves(ArrayList<EnemyShip> naves) {
		this.naves = naves;
	}

	public Double getSpawningPauseTime() {
		return spawningPauseTime;
	}

	public void setSpawningPauseTime(double d) {
		this.spawningPauseTime = d;
	}

}