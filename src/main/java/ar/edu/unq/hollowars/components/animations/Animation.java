package ar.edu.unq.hollowars.components.animations;

import com.uqbar.vainilla.appearances.Sprite;

public class Animation extends com.uqbar.vainilla.appearances.Animation {

	private boolean repeat;
	
	public Animation(double meantime, boolean repeat, Sprite[] sprites) {
		super(meantime, sprites);
		this.setRepeat(repeat);
	}
	
	@Override
	protected void advance() {
		
		this.setCurrentIndex(this.getCurrentIndex() + 1);

		if(this.getCurrentIndex() >= this.getSprites().length) {
			if (this.isRepeat()) {
				this.setCurrentIndex(0);
			} else {
				this.setCurrentIndex(this.getCurrentIndex() - 1);
			}
		}

		this.setRemainingTime(this.getMeantime() - this.getRemainingTime());
	}
	
	public void restart() {
		this.setCurrentIndex(0);
	}
	
	protected Sprite getCurrentSprite() {
		return this.getSprites()[this.getCurrentIndex()];
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

}
