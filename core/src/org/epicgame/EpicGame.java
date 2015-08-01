package org.epicgame;

import org.epicgame.group.BattleGroup;
import org.epicgame.group.SettingsBattleGroup;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class EpicGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Animation anim;
	Stage stage;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		SettingsBattleGroup set = new SettingsBattleGroup();
		set.atlasAnimation = new Texture("atlas.png");
		try {
			set.featuresAtlas = new JSONObject(Gdx.files.internal("test.json").readString()).getJSONObject("frames");
			set.featuresUnits = new JSONObject(Gdx.files.internal("units.json").readString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		set.speedAnimation = 0.5f;
		set.sizeCell = Gdx.graphics.getHeight() / 5;
		set.backgroundBattleField = new TextureRegion(img);
		set.sizeBattleFieldX = 5;
		set.sizeBattleFieldY = 5;
		set.cellNotActiv = new TextureRegion(img, 0, 0, 20, 20);
		set.cellActiv = new TextureRegion(img, 0, 0, 20, 20);
		BattleGroup b = new BattleGroup(set);
		stage = new Stage();
		stage.addActor(b);
	}
	
	BattleGroup bg;
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		stage.act(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void pause() {
		super.pause();
	}
}
