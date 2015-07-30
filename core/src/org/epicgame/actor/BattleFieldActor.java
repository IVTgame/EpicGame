package org.epicgame.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BattleFieldActor extends Actor {
	
	TextureRegion texture;
	
	public BattleFieldActor(TextureRegion texture) {
		this.texture = texture;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(texture, getX(), getY(), 800, 800);
	}
}
