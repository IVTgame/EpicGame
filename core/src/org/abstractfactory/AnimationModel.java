package org.abstractfactory;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationModel {

	private Texture atlas;
	private JSONObject detalisAtlas;
	private Float speedAnimation;
	private HashMap<String, Animation> mapAnim;

	public AnimationModel(Texture atlas, JSONObject detalisAtlas,
			Float speedAnimation) {
		this.atlas = atlas;
		this.detalisAtlas = detalisAtlas;
		this.speedAnimation = speedAnimation;
		mapAnim = new HashMap<String, Animation>();
	}

	public Animation stringArrayToAnimation(Object obj) {
		if (obj == null) {
			return null;
		}
		if(("" + obj).equalsIgnoreCase("null")) {
			return null;
		}
		if(mapAnim.containsKey((String)obj)) {
			return mapAnim.get((String)obj);
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
		mapAnim.put((String)obj, animation);
		return animation;
	}
}
