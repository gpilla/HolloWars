package ar.edu.unq.hollowars;

import java.awt.Dimension;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;

import ar.edu.unq.hollowars.components.animations.ExplotionAnimation;
import ar.edu.unq.hollowars.levels.HolloWarsLevel;
import ar.edu.unq.hollowars.levels.Level1;

public class HolloWarsGame extends Game{
	
	private int currentLevel;

	public static void main(String[] args) {
		new DesktopGameLauncher(new HolloWarsGame()).launch();
	}
	
	@Override
	protected void initializeResources() {
		ExplotionAnimation.getInstance();
	}


	@Override
	protected void setUpScenes() {
		HolloWarsLevel scene = new Level1();
		this.setCurrentScene(scene);
	}

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(800,600);
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "HolloWars";
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

}
