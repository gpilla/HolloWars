package ar.edu.unq.hollowars.components.ui;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.Sprite;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Image extends GameComponent<HolloWarsLevel> {

	public Image(String route, double scale, int x, int y, int z) {
		this.setAppearance(Sprite.fromImage(route).scale(scale)
		);
		this.setX(x);
		this.setY(y);
		this.setZ(z);

		
	}
	
	
}
