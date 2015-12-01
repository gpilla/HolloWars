package ar.edu.unq.hollowars.components.ui;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class EnemiesCountLabel extends GameComponent<HolloWarsLevel> {
	
	public EnemiesCountLabel(double x, double y) {
		this.setX(x);
		this.setY(y);
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20) , Color.YELLOW, String.valueOf(0)));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		this.renderAppearence();
		super.update(deltaState);
	}

	private void renderAppearence() {
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20) , Color.YELLOW, String.valueOf(this.getScene().getEnemyShips().size())));
	}
	
}
