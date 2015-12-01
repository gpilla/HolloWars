package ar.edu.unq.hollowars;

import java.awt.Color;

import com.uqbar.vainilla.GameScene;

import ar.edu.unq.hollowars.components.ui.BackgroundGameOver;
import ar.edu.unq.hollowars.components.ui.Image;
import ar.edu.unq.hollowars.components.ui.Text;

public class GameOverScene extends GameScene {
	
	@Override
	public void onSetAsCurrent() {
		this.addComponent(new Text("GAME OVER, PERDEDOR!", Color.BLACK, 545,480 ));
//		this.addComponent(new BackgroundGameOver());
		this.addComponent(new Image("images/holloAlpha.png",0.17, 00, 70, 0 ));
		this.addComponent(new Image("images/strip.png",0.8, 300,400, -1 ));

		super.onSetAsCurrent();
	}
	
}
