package ar.edu.unq.hollowars;

import java.awt.Dimension;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;

import ar.edu.unq.hollowars.levels.Level;

public class HolloWarsGame extends Game{

	public static void main(String[] args) {
		new DesktopGameLauncher(new HolloWarsGame()).launch();
	}
	
	@Override
	protected void initializeResources() {
		this.initializeEnemies();
		
	}

	private void initializeEnemies() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setUpScenes() {
		Level scene = new Level();
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

}
