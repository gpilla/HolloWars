package ar.edu.unq.hollowars;

import java.awt.Color;

import com.uqbar.vainilla.GameScene;

import ar.edu.unq.hollowars.components.ui.Text;

public class GameOverScene extends GameScene {
	
	@Override
	public void onSetAsCurrent() {
		this.addComponent(new Text("GAME OVER, PERDEDOR!", Color.BLACK, 400, 300 ));
		super.onSetAsCurrent();
	}
	
}
