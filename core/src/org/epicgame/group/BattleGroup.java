package org.epicgame.group;

import org.abstractfactory.Unit;
import org.epicgame.battlefield.BattleField;
import org.epicgame.controlerunits.ControllerUnits;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BattleGroup extends Group implements InputProcessor {
	
	private BattleField battelField;
	private ControllerUnits controllerUnitsGamer;
	private ControllerUnits controllerUnitsBot;
	private Unit selectedUnit;

	public BattleGroup() {
		Gdx.input.setInputProcessor(this);
	}

	public void setControllerUnitGame(ControllerUnits controllerUnitsGamer) {
		this.controllerUnitsGamer = controllerUnitsGamer;
		this.addActor(controllerUnitsGamer);
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
