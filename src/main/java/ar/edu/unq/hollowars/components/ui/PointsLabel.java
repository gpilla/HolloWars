package ar.edu.unq.hollowars.components.ui;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class PointsLabel extends GameComponent<HolloWarsLevel> {

private int value = 0;
	
	public PointsLabel(double x, double y) {
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20) , Color.YELLOW, String.valueOf(value)));
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20) , Color.YELLOW, String.valueOf(value)));
		super.update(deltaState);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void addToValue(int value) {
		this.value += value;
	}
	
	
}
