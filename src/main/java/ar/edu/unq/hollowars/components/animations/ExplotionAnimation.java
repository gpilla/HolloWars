package ar.edu.unq.hollowars.components.animations;

import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.Sprite;

public class ExplotionAnimation extends Animation {
	
	public ExplotionAnimation() {
		super(0.05, generateSprites());
	}
	
	private static Sprite[] generateSprites() {
		Sprite[] sprites = new Sprite[16];
		for (int j = 0; j < 16; j++) {
			sprites[j] = Sprite.fromImage("images/explosions.png").crop(j*1024/16, 64, 1024/16, 64);
		}
		
		return sprites;
	}

	public ExplotionAnimation(double meantime, Sprite[] sprites) {
		super(meantime, sprites);
	}

}
