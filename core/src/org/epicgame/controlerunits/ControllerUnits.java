package org.epicgame.controlerunits;

import java.util.ArrayList;

import org.abstractfactory.Unit;
import org.epicgame.basichero.BasicHero.Action;
import org.epicgame.defaultclasses.Point;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class ControllerUnits extends Group {


	private ArrayList<Unit> listUnit;
	private Unit selectedUnit = null;
	private final int SIZE_CELL;
	private final RunningPath runningPath;

	public ControllerUnits(RunningPath runningPath) {
		this.SIZE_CELL = runningPath.getSizeCell();
		this.runningPath = runningPath;
		listUnit = new ArrayList<Unit>();
	}

	@Override
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
	@Override
	public Actor hit(float x, float y, boolean touchable) {
		selectedUnit = (Unit) super.hit(((int)x) / SIZE_CELL, ((int)y) / SIZE_CELL, touchable);
		return selectedUnit;
	}
	
	public ArrayList<Unit> getListUnit() {
		return listUnit;
	}
	
	public void addUnit(int x, int y, Unit unit) {
		unit.changePositionPixel(x, y);
		unit.changePositionToField(x / SIZE_CELL, y / SIZE_CELL);
		addActor(unit);
		listUnit.add(unit);
	}

	public Integer nearAttack() {
		if (selectedUnit != null && !isDie()) {
			selectedUnit.setAction(Action.NEAR_ATACK);
			return selectedUnit.getNearDamage();
		}
		return null;
	}

	public Integer farAttack() {
		if (selectedUnit != null && !isDie()) {
			selectedUnit.setAction(Action.FAR_ATACK);
			return selectedUnit.getRangeDamage();
		}
		return null;
	}

	public Integer magicAttack() {
		if (selectedUnit != null && !isDie()) {
			selectedUnit.setAction(Action.MAGICK_ATACK);
			return selectedUnit.getMagicDamage();
		}
		return null;
	}

	public void damage(Integer damage) {
		if (selectedUnit != null && damage != null && !isDie()) {
			selectedUnit.setHealth(selectedUnit.getHealth() - damage);
			selectedUnit.setAction(selectedUnit.getHealth() > 0 ? Action.DAMAGE
					: Action.DIE);
			selectedUnit = null;
		}
	}

	public void specailSkills(int numberSpecialSkills) {
		if (selectedUnit != null && !isDie()) {
			selectedUnit.setAction(Action.SPECIAL_SKILS);
			selectedUnit.setNumberSpecialSkils(numberSpecialSkills);
		}
	}

	private boolean isDie() {
		return selectedUnit.getAction() == Action.DIE;
	}

	public boolean runThePath(ArrayList<Point> path) {
		if (selectedUnit == null || isDie()) {
			return false;
		}
		runningPath.run(selectedUnit, path);
		return true;
	}

	public Unit getSelectedUnit() {
		return selectedUnit;
	}

	public boolean isActiveActions() {
		return runningPath.isRunning();
	}

}
