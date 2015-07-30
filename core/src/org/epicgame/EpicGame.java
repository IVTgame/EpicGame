package org.epicgame;

import org.abstractfactory.AnimationModel;
import org.abstractfactory.FactoryUnits;
import org.epicgame.battlefield.BattleField;
import org.epicgame.controlerunits.ControllerUnits;
import org.epicgame.controlerunits.RunningPath;
import org.epicgame.group.BattleGroup;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class EpicGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Animation anim;
	BattleField b;
	Stage stage;

	@Override
	public void create() {
		batch = new SpriteBatch();
		b = new BattleField(30, 10, 10, 600, 600);
		img = new Texture("badlogic.jpg");
//		try {
//			FactoryUnits.getInstens().setAnimationModel(
//					new AnimationModel(new Texture("atlas.png"), new JSONObject(
//							Gdx.files.internal("test.json").readString()).getJSONObject("frames"), 0.5f));
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		stage = new Stage();
		bg = new BattleGroup();
		stage.addActor(bg);
	}
	ControllerUnits con;
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
