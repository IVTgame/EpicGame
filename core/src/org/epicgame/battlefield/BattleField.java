package org.epicgame.battlefield;

import java.util.ArrayList;
import java.util.HashMap;

import org.abstractfactory.Unit;
import org.epicgame.defaultclasses.Point;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BattleField extends Actor {

	private final int SIZE_CELL;
	private int[][] battleField;
	private final int sizeScreenX;
	private final int sizeScreenY;
	private Sprite background;
	private Sprite textureCellNotActiv;
	private Sprite textureCellActiv;
	private Point begin;
	private HashMap<String, String> activCell;

	public BattleField(int sizeCell, int fieldSizeX, int fieldSizeY) {
		SIZE_CELL = sizeCell;
		battleField = new int[fieldSizeX][fieldSizeY];
		this.sizeScreenX = sizeCell * fieldSizeX + sizeCell * fieldSizeX / 5 * 2;
		this.sizeScreenY = sizeCell * fieldSizeY + sizeCell * fieldSizeY / 5 * 2;
		begin = new Point(sizeCell * fieldSizeX / 5, sizeCell * fieldSizeY / 5);
	}

	private void clearField() {
		battleField = new int[battleField.length][battleField[0].length];
	}
	
	public Point getBeginDraw() {
		return begin;
	}
	
	public void setActivCell(ArrayList<Point> activCell) {
		if(activCell == null) {
			this.activCell = null;
			return;
		}
		this.activCell = new HashMap<String, String>(activCell.size());
		for(Point p : activCell) {
			this.activCell.put(p.y + "," + p.x, null);
		}
	}

	public void addUnitsTheField(ArrayList<Unit> units) {
		for (Unit unit : units) {
			battleField[unit.getPositionToField().y][unit.getPositionToField().x] = -1;
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		background.draw(batch);
		if (textureCellActiv != null && textureCellNotActiv != null) {
			int x = begin == null ? 0 : begin.x;
			int y = begin == null ? 0 : begin.y;
			for(int i = 0; i < battleField.length; i++) {
				for(int j = 0; j < battleField[i].length; j++) {
					if(activCell != null && activCell.containsKey(i + "," + j)) {
						textureCellActiv.setPosition(j * SIZE_CELL + x, i * SIZE_CELL + y);
						textureCellActiv.draw(batch);
					} else {
						textureCellNotActiv.setPosition(j * SIZE_CELL + x, i * SIZE_CELL + y);
						textureCellNotActiv.draw(batch);
					}
				}	
			}
		}
	}

	public ArrayList<Point> creatPath(Point start, Point end,
			Boolean ignoreBarriers) {
		return serchPath(start, end, ignoreBarriers);
	}

	public void setBackground(TextureRegion background) {
		this.background = background == null ? this.background : new Sprite(background);
		if(this.background != null) {
			this.background.setBounds(0, 0, sizeScreenX, sizeScreenY);
		}
	}
	
	public void setTextureCell(TextureRegion ñellNotActiv, TextureRegion ñellActiv) {
		this.textureCellNotActiv = ñellNotActiv == null ? this.textureCellNotActiv : new Sprite(ñellNotActiv);
		this.textureCellActiv = ñellActiv == null ? this.textureCellActiv : new Sprite(ñellActiv);
		if(this.textureCellNotActiv != null) {
			this.textureCellNotActiv.setBounds(0, 0, SIZE_CELL, SIZE_CELL);
		}
		if(this.textureCellActiv != null) {
			this.textureCellActiv.setBounds(0, 0, SIZE_CELL, SIZE_CELL);
		}
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
		clearField();
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
