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
		ArrayList<Unit> ar = getListUnit();
		this.SIZE_CELL = runningPath.getSizeCell();
		this.runningPath = runningPath;
		addUnit(50, 100, FactoryUnits.getInstens().creat("Hunter"));
		ArrayList<Point> p = new ArrayList<Point>();
		selectUnit(50,100);
		p.add(new Point(1,2));
		p.add(new Point(1,3));
		p.add(new Point(2,3));
		p.add(new Point(3,3));
		p.add(new Point(4,3));
		p.add(new Point(4,4));
		p.add(new Point(4,5));
		p.add(new Point(4,6));
		p.add(new Point(4,7));
		p.add(new Point(4,6));
		p.add(new Point(5,5));
		runThePath(p);
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
		runningPath.run(selectedUnit, path);
	}
	
	public Unit getSelectedUnit() {
		return selectedUnit;
	}
	
	public boolean isActiveActions() {
		if(runningPath.isRunning()) {
			return true;	
		}
		return false;
	}

}
