package org.battlefield;

import java.awt.Point;
import java.util.ArrayList;

import org.abstractfactory.Unit;
import org.drawinterfeses.FaitFieldAction;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BattleField implements FaitFieldAction {

	@Override
	public void addUnitsTheField(ArrayList<Unit> units) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TextureRegion drawField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Point> creatPath(Point start, Point end,
			Boolean ignoreBarriers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void touchScreen(Point touch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movementOnTheScreen(Point move) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBackground(TextureRegion background) {
		// TODO Auto-generated method stub
		
	}

}
