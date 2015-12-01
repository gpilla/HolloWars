package ar.edu.unq.hollowars.components;

import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class BossEnemyShip extends GameComponent<HolloWarsLevel> {
	
	private ArrayList<BossEnemyShipTurret> turrets;
	private double i = 1;
	
	public BossEnemyShip() {
		this.setX(50);
		this.setY(50);
		this.setZ(1);
		this.setAppearance(Sprite.fromImage("images/47750.png").crop(437, 0, 159, 1363).scale(0.4));
		this.setTurrets(new ArrayList<BossEnemyShipTurret>());
	}
	
	@Override
	public void onSceneActivated() {
		super.onSceneActivated();
	}
	
	@Override
	public void update(DeltaState deltaState) {
		double advanced = 10 * deltaState.getDelta();
		if (this.getX() + this.getAppearance().getWidth() + 100 > this.getGame().getDisplayWidth()) {
			this.i = -1;
		}
		
		if (this.getX() - 100 < 0) {
			this.i = 1;
		}
		
		this.move(this.i * advanced, 0 * advanced);
		
		for (BossEnemyShipTurret bossEnemyShipTurret : turrets) {
			bossEnemyShipTurret.setX(bossEnemyShipTurret.getRelativeX() + this.getX());
			bossEnemyShipTurret.setY(bossEnemyShipTurret.getRelativeY() + this.getY()-bossEnemyShipTurret.getAppearance().getHeight()/2);
		}
	}

	public ArrayList<BossEnemyShipTurret> getTurrets() {
		return turrets;
	}

	public void setTurrets(ArrayList<BossEnemyShipTurret> turrets) {
		this.turrets = turrets;
	}
	
	public void addTurret(BossEnemyShipTurret turret) {
		this.getTurrets().add(turret);
	}
}
