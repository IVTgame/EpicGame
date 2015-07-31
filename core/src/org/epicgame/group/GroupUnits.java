package org.epicgame.group;

import org.abstractfactory.Unit;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GroupUnits extends Actor {
	
	private Unit unit;
	private int count;
	
	
	private GroupUnits(Unit unit) {
		this.unit = unit;
		count = 0;
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		unit.draw(batch, parentAlpha);
	}
	
	@Override
	public Actor hit (float x, float y, boolean touchable) {
		return unit.hit(x, y, touchable);
	}
}
