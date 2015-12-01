package ar.edu.unq.hollowars.components;

import java.awt.Color;
import java.util.ArrayList;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.vainilla.colissions.CollisionDetector;
import com.uqbar.vainilla.events.constants.Key;

import ar.edu.unq.hollowars.components.ships.guns.Gun;
import ar.edu.unq.hollowars.components.strategies.PlayerBulletStrategy;

public class PowerUp extends GameComponent<GameScene>{
	
	public static final int SPEED = 300;
	public static final int NAVE_HEIGHT = 50;
	public static final int NAVE_WIDTH = 30;
	
	
	public PowerUp() {
		this.setAppearance(new Circle(Color.green, 15));

		this.setAppearance(Sprite.fromImage("images/1942Sheet1.png").crop(71, 424, 16, 16).scaleTo(50, 50));

	}

	
}
