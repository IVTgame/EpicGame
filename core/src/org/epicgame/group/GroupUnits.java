package org.epicgame.group;

import org.abstractfactory.Unit;
import org.epicgame.basichero.BasicHero.Action;
import org.epicgame.battlefield.BattleField;
import org.epicgame.controlerunits.RunningPath;
import org.epicgame.defaultclasses.Point;

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
	
	public Integer getHealth() {
		return unit.getHealth() * count;
	}
	
	public void damage(int damage) {
		unit.setAction(Action.DAMAGE);
		unit.setHealth(unit.getHealth() - damage / count);
		if(unit.getHealth() <= 0) {
			unit.setAction(Action.DIE);
		}
	}
	
	public Integer nearAttack() {
		unit.setAction(Action.NEAR_ATACK);
		return (int)(unit.getNearDamage() * count * unit.getCriticalHit());
	}
	
	public Integer farAttack() {
		unit.setAction(Action.FAR_ATACK);
		return (int)(unit.getRangeDamage() * count * unit.getCriticalHit());
	}
	
	public Integer magicAttack() {
		unit.setAction(Action.MAGICK_ATACK);
		return (int)(unit.getMagicDamage() * count * unit.getCriticalHit());
	}
	
	public boolean isDie() {
		return unit.getAction() == Action.DIE;
	}
	
	public boolean goToPoint(RunningPath rP, BattleField bF, Point gP) {
		return rP.run(unit, bF.creatPath(unit.getPositionToField(), gP, unit.getFly()));
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
