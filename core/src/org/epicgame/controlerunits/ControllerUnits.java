package org.epicgame.controlerunits;

import java.util.ArrayList;
import java.util.HashMap;

import org.abstractfactory.FactoryUnits;
import org.abstractfactory.Unit;
import org.epicgame.basichero.BasicHero.Action;
import org.epicgame.defaultclasses.Point;

public class ControllerUnits {

	/*
	 * хранится пара(место расположение - юнит). Для быстроты нахождения юнита
	 * на поле.
	 */
	private HashMap<String, Unit> mapUnit = new HashMap<String, Unit>();
	private Unit selectedUnit = null;
	private Boolean activeActions = false;
	private final int SIZE_CELL;
	private final RunningPath runningPath;

	public ControllerUnits(RunningPath runningPath) {
		this.SIZE_CELL = runningPath.getSizeCell();
		this.runningPath = runningPath;
	}

	public ArrayList<Unit> getListUnit() {
		ArrayList<Unit> list = new ArrayList<Unit>();
		list.addAll(mapUnit.values());
		return list;
	}

	public boolean addUnit(int x, int y, Unit unit) {
		unit.changePosition(x, y);
		mapUnit.put((x / SIZE_CELL) + "," + (y / SIZE_CELL), unit);
		return mapUnit.containsKey((x / SIZE_CELL) + "," + (y / SIZE_CELL));
	}

	public boolean selectUnit(int x, int y) {
		if (deselectUnit()
				&& mapUnit.containsKey((x / SIZE_CELL) + "," + (y / SIZE_CELL))) {
			selectedUnit = mapUnit.get((x / SIZE_CELL) + "," + (y / SIZE_CELL));
			return true;
		}
		return false;
	}

	public boolean deselectUnit() {
		if (!activeActions) {
			selectedUnit = null;
			return true;
		}
		return false;
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
		if (isDie()) {
			return false;
		}
		runningPath.run(selectedUnit, path);
		return true;
	}

	public Unit getSelectedUnit() {
		return selectedUnit;
	}

	public boolean isActiveActions() {
		if (runningPath.isRunning()) {
			return true;
		}
		return false;
	}

}
