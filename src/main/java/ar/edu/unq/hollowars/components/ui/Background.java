package ar.edu.unq.hollowars.components.ui;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.Sprite;

import ar.edu.unq.hollowars.levels.HolloWarsLevel;

public class Background extends GameComponent<HolloWarsLevel> {

	public Background() {
		
	}
	
	@Override
	public void onSceneActivated() {
				
		this.setAppearance(new Animation(0.1, 
				Sprite.fromImage("images/water/frame-01.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-02.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-03.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-04.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-05.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-06.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-07.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-08.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-09.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-10.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-11.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-12.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-13.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-14.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
				Sprite.fromImage("images/water/frame-15.gif").scale(0.5).repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight())
				
			));
		
//		this.setAppearance(new Animation(0.05, 
//				Sprite.fromImage("images/broken_tv/frame-1.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
//				Sprite.fromImage("images/broken_tv/frame-2.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
//				Sprite.fromImage("images/broken_tv/frame-3.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
//				Sprite.fromImage("images/broken_tv/frame-4.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
//				Sprite.fromImage("images/broken_tv/frame-5.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
//				Sprite.fromImage("images/broken_tv/frame-6.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
//				Sprite.fromImage("images/broken_tv/frame-7.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
//				Sprite.fromImage("images/broken_tv/frame-8.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight()),
//				Sprite.fromImage("images/broken_tv/frame-9.gif").repeatHorizontallyToCover(this.getGame().getDisplayWidth()).repeatVerticallyToCover(this.getGame().getDisplayHeight())
//			));
		super.onSceneActivated();
	}
	
}
