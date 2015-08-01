package org.epicgame.group;

import org.abstractfactory.Unit;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GroupUnits extends Actor {
	
	private Unit unit;
	private int count;
	
	
	public GroupUnits(Unit unit) {
		this.unit = unit;
		count = 1;
	}
	
	public GroupUnits(Unit unit, int count) {
		this.unit = unit;
		this.count = count;
	}
	
	public boolean equalsUnit(Unit unitEq) {
		if(unit.getName().equalsIgnoreCase(unitEq.getName())) {
			count++;
			return true;
		}
		return false;
	}
	
	@Override
	public void act(float deltaTime) {
		unit.act(deltaTime);
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
