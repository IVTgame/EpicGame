package org.epicgame.controlerunits;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.abstractfactory.Unit;
import org.epicgame.basichero.BasicHero.Action;
import org.epicgame.defaultclasses.Point;

public class RunningPath {

	private enum Direction {
		UP, DOWN, RIGHT, LEFT, NOT
	}

	private Boolean isRunning;
	private long period = 50;
	private long wait = 0;
	private final int SIZE_CELL;
	private int oneStep;
	private int indexPath = 1;

	public RunningPath(long period, int sizeCell) {
		this.period = period;
		this.SIZE_CELL = sizeCell;
		findOneStep();
	}

	public RunningPath(int sizeCell) {
		this.SIZE_CELL = sizeCell;
		findOneStep();
	}

	private void findOneStep() {
		int oneStep = SIZE_CELL;
		while ((float) SIZE_CELL / (float) oneStep != 5.0f) {
			oneStep--;
		}
		this.oneStep = oneStep;
	}

	public synchronized void run(Unit unit, ArrayList<Point> path) {
		if (path.size() == 0
				|| (unit.getPositionToField().x != path.get(0).x || unit
						.getPositionToField().y != path.get(0).y)) {
			return;
		}
		Timer timer = new Timer();
		isRunning = true;
		unit.setAction(Action.MOVEMENT);
		timer.schedule(creatTask(unit, path, timer), wait, period);
	}

	private TimerTask creatTask(final Unit unit, final ArrayList<Point> path,
			final Timer timer) {
		return new TimerTask() {

			@Override
			public void run() {
				if (indexPath == path.size()) {
					indexPath = 1;
					isRunning = false;
					unit.setAction(Action.REST);
					timer.cancel();
				} else {
					Point nextPointThePath = new Point(path.get(indexPath).x
							* SIZE_CELL, path.get(indexPath).y * SIZE_CELL);
					if (equalPoint(nextPointThePath, unit.getPositionPixel())) {
						indexPath++;
						if (indexPath == path.size()) {
							indexPath = 1;
							isRunning = false;
							unit.setAction(Action.REST);
							timer.cancel();
						} else {
							nextPointThePath = new Point(path.get(indexPath).x
									* SIZE_CELL, path.get(indexPath).y
									* SIZE_CELL);
						}
					}

					switch (chekDirection(unit.getPositionPixel(),
							nextPointThePath)) {
					case RIGHT:
						unit.changePositionPixel(unit.getPositionPixel().x
								+ oneStep, unit.getPositionPixel().y);
						break;
					case LEFT:
						unit.changePositionPixel(unit.getPositionPixel().x
								- oneStep, unit.getPositionPixel().y);
						break;
					case DOWN:
						unit.changePositionPixel(unit.getPositionPixel().x,
								unit.getPositionPixel().y + oneStep);
						break;
					case UP:
						unit.changePositionPixel(unit.getPositionPixel().x,
								unit.getPositionPixel().y - oneStep);
						break;
					case NOT:
						indexPath++;
						break;
					}
					unit.changePositionToField(unit.getPositionPixel().x
							/ SIZE_CELL, unit.getPositionPixel().y / SIZE_CELL);
				}

			}

		};
	}

	private Direction chekDirection(Point point, Point end) {

		if (point.x < end.x) {
			return Direction.RIGHT;
		}
		if (point.x > end.x) {
			return Direction.LEFT;
		}
		if (point.y < end.y) {
			return Direction.DOWN;
		}
		if (point.y > end.y) {
			return Direction.UP;
		}
		return Direction.NOT;
	}

	private boolean equalPoint(Point pointCell, Point pointPixel) {
		if (pointCell.x == pointPixel.x && pointCell.y == pointPixel.y) {
			return true;
		}
		return false;
	}

	public Boolean isRunning() {
		return isRunning;
	}

	public int getSizeCell() {
		return SIZE_CELL;
	}
}
