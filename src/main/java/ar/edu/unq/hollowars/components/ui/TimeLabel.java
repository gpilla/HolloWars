package ar.edu.unq.hollowars.components.ui;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class TimeLabel extends GameComponent<HolloWarsLevel> {
	
	Double timeElapsed = 0.0;
	
	public TimeLabel(double x, double y) {
		this.setX(x);
		this.setY(y);
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20) , Color.YELLOW, "00:00"));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		timeElapsed += deltaState.getDelta();
		this.renderAppearence();
		super.update(deltaState);
	}

	private void renderAppearence() {
		Double seconds = timeElapsed%60;
		Double minutes = timeElapsed/60;
		String text = String.valueOf(minutes.intValue()) + ":" + String.valueOf(seconds.intValue()); 
		//String text = String.valueOf(seconds.intValue());
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20) , Color.YELLOW, text));
	}
	
}
