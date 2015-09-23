package ar.edu.unq.hollowars;

import java.awt.Dimension;
import java.util.ArrayList;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;

import ar.edu.unq.hollowars.levels.Level1;
import ar.edu.unq.hollowars.parser.ReadCSV;


public class HolloWarsGame extends Game{

	public static void main(String[] args) {
		ArrayList<String[]> waves2 = null;
		try {
			waves2 = new ReadCSV("lvl12.csv").run();

		} catch (Exception e) {
			System.out.println("me rompo");
		}
			System.out.println(waves2.size());
		for (String[] strings : waves2) {
			System.out.println(strings[1]);
		}

		
//		new DesktopGameLauncher(new HolloWarsGame()).launch();
	}
	
	@Override
	protected void initializeResources() {
		
	}

	@Override
	protected void setUpScenes() {
		Level1 scene = new Level1();
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
