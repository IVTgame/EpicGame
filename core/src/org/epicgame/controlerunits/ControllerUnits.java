package org.epicgame.controlerunits;

import java.util.ArrayList;

import org.abstractfactory.Unit;
import org.epicgame.basichero.BasicHero.Action;
import org.epicgame.defaultclasses.Point;

public class ControllerUnits {

	private Unit selectedUnit = null;
	private final RunningPath runningPath;

	public ControllerUnits(RunningPath runningPath) {
		this.runningPath = runningPath;
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

	public void setSelectedUnit(Unit selectedUnit) {
		this.selectedUnit = selectedUnit;
	}
	
	public Unit getSelectedUnit() {
		return selectedUnit;
	}

	public boolean isActiveActions() {
		return runningPath.isRunning();
	}

}
