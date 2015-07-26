package org.epicgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.abstractfactory.AnimationModel;
import org.abstractfactory.FactoryUnits;
import org.epicgame.controlerunits.ControllerUnits;
import org.epicgame.controlerunits.RunningPath;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EpicGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Animation anim;
	ControllerUnits con;

	@Override
	public void create() {
		batch = new SpriteBatch();
		String json = "";
		try {
			BufferedReader read = new BufferedReader(new FileReader(
					"resourses/Drawable/test.json"));
			while (read.ready()) {
				json += read.readLine();
			}
			read.close();
		} catch (IOException e1) {
			json = null;
			e1.printStackTrace();
		}
		try {
			FactoryUnits.getInstens().setAnimationModel(
					new AnimationModel(new Texture(
							"resourses/Drawable/atlas.png"), new JSONObject(
							json).getJSONObject("frames"), 0.5f));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		img = new Texture("badlogic.jpg");
		con = new ControllerUnits(new RunningPath(200, 50, 50));
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(con.getListUnit().get(0).drawAction(0.1f), con.getListUnit()
				.get(0).getPosition().x,
				con.getListUnit().get(0).getPosition().y, 50, 50);
		batch.end();
	}
}
