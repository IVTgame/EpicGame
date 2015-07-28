package org.epicgame;

import java.awt.Point;
import java.util.ArrayList;

import org.abstractfactory.FactoryUnits;
import org.abstractfactory.Unit;
import org.epicgame.battlefield.BattleField;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EpicGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Animation anim;
	BattleField b;

	@Override
	public void create() {
		batch = new SpriteBatch();
		String json = "";
		json = Gdx.files.internal("test.json").readString();
		b = new BattleField(30, 10, 10, 600, 600);
		ArrayList<Unit> unit = new ArrayList<Unit>();
		Unit u = FactoryUnits.getInstens().creat("Hunter");
		u.changePosition(10, 0);
		Unit u1 = FactoryUnits.getInstens().creat("Hunter");
		u1.changePosition(10, 10);
		Unit u2 = FactoryUnits.getInstens().creat("Hunter");
		u2.changePosition(10, 20);
		Unit u3 = FactoryUnits.getInstens().creat("Hunter");
		u3.changePosition(10, 30);
		//Unit u4 = FactoryUnits.getInstens().creat("Hunter");
		//u4.changePosition(10, 40);
		unit.add(u);
		unit.add(u1);
		unit.add(u2);
		unit.add(u3);
		//unit.add(u4);
		b.addUnitsTheField(unit);
		b.creatPath(new Point(0, 0), new Point(4, 0), null);
		img = new Texture("badlogic.jpg");
		b.setBackground(new TextureRegion(img));
		b.setTextureCell(new TextureRegion(img, 0, 0, 10, 10));
		b.setBeginFildTheUnit(new Point(50, 50));
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		b.drawField(batch);
		batch.end();
	}
	
	@Override
	public void pause() {
		super.pause();
	}
}
