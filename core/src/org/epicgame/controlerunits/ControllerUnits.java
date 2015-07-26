package org.epicgame.controlerunits;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import org.abstractfactory.FactoryUnits;
import org.abstractfactory.Unit;

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

	public static void main(String[] arg) {
		new ControllerUnits(new RunningPath(50));
	}

	public ControllerUnits(RunningPath runningPath) {
		addUnit(1, 2, FactoryUnits.getInstens().creat("Hunter"));
		ArrayList<Unit> ar = getListUnit();
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
		if (deselectUnit() && mapUnit.containsKey((x / SIZE_CELL) + "," + (y / SIZE_CELL))) {
			selectedUnit = mapUnit.get((x / SIZE_CELL) + "," + (y / SIZE_CELL));
			return true;
		}
		return false;
	}

	public boolean deselectUnit() {
		if(!activeActions) {
			selectedUnit = null;
			return true;
		}
		return false;
	}
	
	public void runThePath(ArrayList<Point> path) {
		
	}
	
	public Unit getSelectedUnit() {
		return selectedUnit;
	}
	
	public boolean isActiveActions() {
		return activeActions;
	}

}
