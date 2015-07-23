package org.abstractfactory;

import org.epicgame.basichero.BasicHero;
import org.epicgameheroesinterfaces.BasicAction;
import org.epicgameheroesinterfaces.DrawableAction;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Unit extends BasicHero implements BasicAction, DrawableAction {

	private Animation rest;
	private Animation movement;
	private Animation nearAttack;
	private Animation farAttack;
	private Animation[] specialSkills;
	private Float speedAnimation;
	
	@Override
	public void setRestAnimation(Animation anim) {
		rest = anim;
	}

	@Override
	public void setMovementAnimation(Animation anim) {
		movement = anim;
	}

	@Override
	public void setNearAttackAnimation(Animation anim) {
		nearAttack = anim;
	}

	@Override
	public void setFarAttackAnimation(Animation anim) {
		farAttack = anim;
	}

	@Override
	public void setSpecialSkillsAnimation(Animation[] anim) {
		specialSkills = anim;
	}

	@Override
	public TextureRegion drawAction(Float runTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpeedAnimation(Float speed) {
		speedAnimation = speed;
		
	}

}
