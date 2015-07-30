package org.epicgameheroesinterfaces;

import com.badlogic.gdx.graphics.g2d.Animation;

public interface DrawableAction {
	public void setRestAnimation(Animation anim);
	public void setMovementAnimation(Animation anim);
	public void setNearAttackAnimation(Animation anim);
	public void setFarAttackAnimation(Animation anim);
	public void setMagickAttackAnimation(Animation anim);
	public void setDamageAnimation(Animation anim);
	public void setDieAnimation(Animation anim);
	public void setSpecialSkillsAnimation(Animation[] anim);
}
