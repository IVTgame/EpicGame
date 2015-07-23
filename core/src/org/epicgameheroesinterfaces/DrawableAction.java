package org.epicgameheroesinterfaces;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface DrawableAction {
	public void setSpeedAnimation(Float speed);
	public void setRestAnimation(Animation anim);
	public void setMovementAnimation(Animation anim);
	public void setNearAttackAnimation(Animation anim);
	public void setFarAttackAnimation(Animation anim);
	public void setSpecialSkillsAnimation(Animation[] anim);
	public TextureRegion drawAction(Float runTime);
}
