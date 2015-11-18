package ar.edu.unq.hollowars.components.ui;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Label;

public class Text extends GameComponent<GameScene> {
	
	public Text(String text, Color color, double x, double y ) {
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20) , color, text));
		this.alignHorizontalCenterTo(x);
		this.alignVerticalCenterTo(y);
	}
	
}
