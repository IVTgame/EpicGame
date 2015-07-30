package org.epicgame.group;

import java.util.ArrayList;

import org.abstractfactory.AnimationModel;
import org.abstractfactory.FactoryUnits;
import org.abstractfactory.Unit;
import org.epicgame.battlefield.BattleField;
import org.epicgame.controlerunits.ControllerUnits;
import org.epicgame.controlerunits.RunningPath;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BattleGroup extends Group implements InputProcessor {
	
	private BattleField battelField;
	private ControllerUnits controllerUnits;
	private FactoryUnits factoryUnits;
	private Unit selectedUnit;
	private SettingsBattleGroup seting;
	private boolean isLoading;
	private ArrayList<Unit> uits;
	
	public BattleGroup(SettingsBattleGroup seting) {
		this.seting = seting;
		uits = new ArrayList<Unit>();
	}
	
	public void load() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				initController();
				initFactoryUnits();
				loaded();
			}
			
		}).start();
		
	}
	
	private synchronized void initController() {
		controllerUnits = new ControllerUnits(new RunningPath(seting.speedMovement, seting.sizeCell));
	}
	
	private synchronized void initFactoryUnits() {
		factoryUnits = new FactoryUnits(seting.featuresUnits);
		factoryUnits.setAnimationModel(new AnimationModel(seting.atlasAnimation, seting.featuresAtlas, seting.speedAnimation));
	}
	
	private synchronized void initBattleField() {
		battelField = new BattleField();
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
		// TODO Auto-generated method stub
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
