package org.epicgame.battlefield;

import java.awt.Point;
import java.util.ArrayList;

import org.abstractfactory.Unit;
import org.drawinterfeses.FaitFieldAction;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BattleField implements FaitFieldAction {

	private final int SIZE_CELL;
	private int[][] battleField;
	private final int sizeScreenX;
	private final int sizeScreenY;
	private Sprite background;
	private Sprite textureCell;
	private Point begin;

	public BattleField(int sizeCell, int fieldSizeX, int fieldSizeY, int sizeScreenX, int sizeScreenY) {
		SIZE_CELL = sizeCell;
		battleField = new int[fieldSizeX][fieldSizeY];
		this.sizeScreenX = sizeScreenX;
		this.sizeScreenY = sizeScreenY;
	}

	private void clear() {
		battleField = new int[battleField.length][battleField[0].length];
	}

	@Override
	public void addUnitsTheField(ArrayList<Unit> units) {
		for (Unit unit : units) {
			battleField[unit.getPositionToField().y][unit.getPositionToField().x] = -1;
		}
	}

	@Override
	public void drawField(SpriteBatch spriteBatch) {
		background.draw(spriteBatch);
		if (textureCell != null) {
			int x = begin == null ? 0 : begin.x;
			int y = begin == null ? 0 : begin.y;
			for(int i = 0; i < battleField.length; i++) {
				for(int j = 0; j < battleField[i].length; j++) {
					textureCell.setPosition(j * SIZE_CELL + x, i * SIZE_CELL + y);
					textureCell.draw(spriteBatch);
				}	
			}
		}
	}

	@Override
	public ArrayList<Point> creatPath(Point start, Point end,
			Boolean ignoreBarriers) {
		return serchPath(start, end, ignoreBarriers);
	}

	@Override
	public void setBackground(TextureRegion background) {
		this.background = background == null ? this.background : new Sprite(background);
		if(this.background != null) {
			this.background.setBounds(0, 0, sizeScreenX, sizeScreenY);
		}
	}
	
	@Override
	public void setTextureCell(TextureRegion textureCell) {
		this.textureCell = textureCell == null ? this.textureCell : new Sprite(textureCell);
		if(this.textureCell != null) {
			this.textureCell.setBounds(0, 0, SIZE_CELL, SIZE_CELL);
		}
	}
	
	@Override
	public void setBeginFildTheUnit(Point begin) {
		this.begin = begin;
	}

	private ArrayList<Point> serchPath(Point start, Point end,
			Boolean ignoreBarriers) {
		if (serch(end, start, ignoreBarriers)) {
			return readPath(start, end);
		}
		return null;
	}

	private boolean serch(Point start, Point end, Boolean ignoreBarriers) {
		int d = 1;
		battleField[start.y][start.x] = d;
		boolean endSerch = false;
		while (!endSerch) {
			d++;
			endSerch = true;
			for (int i = 0; i < battleField.length; i++) {
				for (int j = 0; j < battleField[i].length; j++) {
					if (battleField[i][j] == d - 1) {
						if (i == end.y && j == end.x) {
							return true;
						}
						endSerch = false;
						mark(i, j, d, ignoreBarriers);
					}
				}
			}
		}
		return false;
	}

	private void mark(int i, int j, int d, Boolean igB) {
		markPoint(i + 1, j, d, igB);
		markPoint(i - 1, j, d, igB);
		markPoint(i, j + 1, d, igB);
		markPoint(i, j - 1, d, igB);
	}

	private void markPoint(int i, int j, int d, Boolean igB) {
		if (i >= 0 && j >= 0 && battleField.length > i
				&& battleField[i].length > j
				&& (battleField[i][j] != d - 2 || battleField[i][j] == 0)
				&& battleField[i][j] >= 0
				&& (battleField[i][j] == 0 || igB == null || igB)) {
			battleField[i][j] = d;
		}
	}

	private ArrayList<Point> readPath(Point start, Point end) {
		ArrayList<Point> path = new ArrayList<Point>();
		Point step = new Point(start.x, start.y);
		path.add(step);
		while (step.x != end.x || step.y != end.y) {
			step = step(step);
			path.add(step);
		}
		clear();
		return path;
	}

	private Point step(Point prev) {
		if (isNext(prev.x, prev.y, prev.x + 1, prev.y)) {
			return new Point(prev.x + 1, prev.y);
		}
		if (isNext(prev.x, prev.y, prev.x - 1, prev.y)) {
			return new Point(prev.x - 1, prev.y);
		}
		if (isNext(prev.x, prev.y, prev.x, prev.y + 1)) {
			return new Point(prev.x, prev.y + 1);
		}
		if (isNext(prev.x, prev.y, prev.x, prev.y - 1)) {
			return new Point(prev.x, prev.y - 1);
		}
		return null;
	}

	private boolean isNext(int px, int py, int nx, int ny) {
		if (nx >= 0 && ny >= 0 && ny < battleField.length
				&& nx < battleField[ny].length
				&& battleField[ny][nx] == battleField[py][px] - 1) {
			return true;
		}
		return false;
	}

}
