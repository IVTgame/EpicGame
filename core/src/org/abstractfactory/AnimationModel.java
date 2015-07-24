package org.abstractfactory;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationModel {

	Texture atlas;
	JSONObject detalisAtlas;
	Float speedAnimation;

	public AnimationModel(Texture atlas, JSONObject detalisAtlas,
			Float speedAnimation) {
		this.atlas = atlas;
		this.detalisAtlas = detalisAtlas;
		this.speedAnimation = speedAnimation;
	}

	public Animation stringArrayToAnimation(Object obj) {
		if (obj == null) {
			return null;
		}
		if(((String)obj).equalsIgnoreCase("null")) {
			return null;
		}
		String[] anim = ((String) obj).split(",");
		TextureRegion[] imgs = new TextureRegion[anim.length];
		for (int i = 0; i < imgs.length; i++) {
			JSONObject img;
			try {
				img = detalisAtlas.getJSONObject((String) anim[i])
						.getJSONObject("frame");
				imgs[i] = new TextureRegion(atlas, img.getInt("x"),
						img.getInt("y"), img.getInt("w"), img.getInt("h"));
			} catch (JSONException e) {
				return null;
			}

		}
		Animation animation = new Animation(speedAnimation, imgs);
		return animation;
	}
}
