package org.epicgame.group;

import java.util.ArrayList;

import org.abstractfactory.AnimationModel;
import org.abstractfactory.FactoryUnits;
import org.abstractfactory.Unit;
import org.epicgame.battlefield.BattleField;
import org.epicgame.controlerunits.RunningPath;
import org.epicgame.defaultclasses.Point;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BattleGroup extends Group implements InputProcessor {
	
	private BattleField battelField;
	private RunningPath runningPath;
	private FactoryUnits factoryUnits;
	private Unit selectedUnit;
	private SettingsBattleGroup seting;
	private boolean isLoading;
	private ArrayList<Unit> units;
	private Point beginDraw = new Point(0,0);
	private Point prevPosition = new Point();
	
	public BattleGroup(SettingsBattleGroup seting) {
		this.seting = seting;
		units = new ArrayList<Unit>();
		initFactoryUnits();
		initBattleField();
		Unit v = factoryUnits.creat("Hunter", Unit.GAMER);
		v.setSizeX(seting.sizeCell);
		v.setSizeY(seting.sizeCell);
		units.add(v);
		addActor(v);
		loaded();
	}
	
	public void load() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				initRunningPath();
				initFactoryUnits();
				initBattleField();
				loaded();
			}
			
		}).start();
		
	}
	
	private synchronized void initRunningPath() {
		runningPath = new RunningPath(seting.speedMovement, seting.sizeCell);
	}
	
	private synchronized void initFactoryUnits() {
		factoryUnits = new FactoryUnits(seting.featuresUnits);
		factoryUnits.setAnimationModel(new AnimationModel(seting.atlasAnimation, seting.featuresAtlas, seting.speedAnimation));
	}
	
	private synchronized void initBattleField() {
		battelField = new BattleField(seting.sizeCell, seting.sizeBattleFieldX, seting.sizeBattleFieldY);
		battelField.setBackground(seting.backgroundBattleField);
		
		addActor(battelField);
	}
	
	private synchronized void loadUnitGamer() {
		
	}
	
	private synchronized void loadUnitBot() {
		
	}
	
	private synchronized void loaded() {
		isLoading = false;
		Gdx.input.setInputProcessor(this);
	}
	
	public boolean isLoading() {
		return isLoading;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		return false;
	}
	

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		prevPosition.x = screenX;
		prevPosition.y = Gdx.graphics.getHeight() - screenY;
		selectedUnit = (Unit) hit(screenX, Gdx.graphics.getHeight() - screenY, true);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		beginDraw.x += screenX - prevPosition.x; 
		beginDraw.y += Gdx.graphics.getHeight() - screenY - prevPosition.y; 
		prevPosition.x = screenX;
		prevPosition.y = Gdx.graphics.getHeight() - screenY;
		setPosition(beginDraw.x, beginDraw.y);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}