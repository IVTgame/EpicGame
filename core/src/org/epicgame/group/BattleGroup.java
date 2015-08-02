package org.epicgame.group;

import java.util.ArrayList;

import org.epicgame.abstractfactory.AnimationModel;
import org.epicgame.abstractfactory.FactoryUnits;
import org.epicgame.abstractfactory.Unit;
import org.epicgame.battlefield.BattleField;
import org.epicgame.controlerunits.RunningPath;
import org.epicgame.defaultclasses.Point;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	private ArrayList<GroupUnits> units;
	private Point beginDraw = new Point(0, 0);
	private Point prevPosition = new Point();

	public BattleGroup(SettingsBattleGroup seting) {
		this.seting = seting;
		units = new ArrayList<GroupUnits>();
		initBattleField();
		initFactoryUnits();
		Unit v = factoryUnits.creat("Hunter", Unit.GAMER);
		v.setSizeX(seting.sizeCell);
		v.setSizeY(seting.sizeCell);
		v.changePositionToField(1, 1);
		initRunningPath();
		addUnit(v);
		loaded();
	}

	private GroupUnits addUnit(Unit unit) {
		for (GroupUnits add : units) {
			if (add.equalsUnit(unit)) {
				addActor(add);
				return add;
			}
		}
		GroupUnits add = new GroupUnits(unit);
		units.add(add);
		addActor(add);
		return add;
	}

	private void addUnits(Unit unit, int count) {
		GroupUnits add = new GroupUnits(unit, count);
		units.add(add);
		addActor(add);
	}

	public void load() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				initRunningPath();
				initBattleField();
				initFactoryUnits();
				loadUnitGamer();
				loadUnitBot();
				loaded();
			}

		}).start();

	}

	private synchronized void initRunningPath() {
		runningPath = new RunningPath(seting.speedMovement, seting.sizeCell);
	}

	private synchronized void initFactoryUnits() {
		factoryUnits = new FactoryUnits(seting.featuresUnits,
				battelField.getBeginDraw(), seting.sizeCell);
		factoryUnits.setAnimationModel(new AnimationModel(
				seting.atlasAnimation, seting.featuresAtlas,
				seting.speedAnimation));
	}

	private synchronized void initBattleField() {
		battelField = new BattleField(seting.sizeCell, seting.sizeBattleFieldX,
				seting.sizeBattleFieldY);
		battelField.setBackground(seting.backgroundBattleField);
		battelField.setTextureCell(seting.cellNotActiv, seting.cellActiv);
		addActor(battelField);
	}

	private synchronized void loadUnitGamer() {
		fillingListUnit(seting.featuresHero, Unit.GAMER);
	}

	private synchronized void loadUnitBot() {
		fillingListUnit(seting.featuresBattleField, Unit.BOT);
	}

	private void fillingListUnit(JSONArray listUnit, int whoControls) {
		for (int i = 0; !listUnit.isNull(i); i++) {
			try {
				JSONObject oneUnit = listUnit.getJSONObject(i);
				String name = oneUnit.getString("name");
				int count = oneUnit.getInt("count");
				Unit cU = factoryUnits.creat(name, whoControls);
				addUnits(cU, count);
			} catch (JSONException ex) {
				// Запись эксепшена в файл.
			}
		}
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
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		int x = screenX - battelField.getBeginDraw().x - beginDraw.x;
		int y = Gdx.graphics.getHeight() - screenY
				- battelField.getBeginDraw().y - beginDraw.y;
		//selectedUnit = (Unit) hit(x, y, true);
		units.get(0).goToPoint(runningPath, battelField, new Point(x / seting.sizeCell, y / seting.sizeCell));
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