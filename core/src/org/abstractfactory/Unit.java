package org.abstractfactory;

import org.epicgame.basichero.BasicHero;
import org.epicgameheroesinterfaces.BasicAction;
import org.epicgameheroesinterfaces.DrawableAction;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Unit extends BasicHero implements  DrawableAction {

	private Animation rest;
	private Animation movement;
	private Animation nearAttack;
	private Animation farAttack;
	private Animation magickAttack;
	private Animation damage;
	private Animation die;
	private Animation[] specialSkills;
	private Float runTime = 0f;
	
	Unit() {
		setAction(Action.REST);
	}
	
	@Override
	public void setAction(Action action) {
    	super.setAction(action);
    	runTime = 0f;
    }
	
	@Override
	public void setRestAnimation(Animation anim) {
		if(anim == null) return;
		rest = anim;
		rest.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	@Override
	public void setMovementAnimation(Animation anim) {
		if (anim == null) return;
		movement = anim;
		movement.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	@Override
	public void setDamageAnimation(Animation anim) {
		if(anim == null) return;
		damage = anim;
		damage.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}
	
	@Override
	public void setDieAnimation(Animation anim) {
		if(anim == null) return;
		die = anim;
		die.setPlayMode(Animation.PlayMode.NORMAL);
	}
	@Override
	public void setNearAttackAnimation(Animation anim) {
		if(anim == null) return;
		nearAttack = anim;
		nearAttack.setPlayMode(Animation.PlayMode.NORMAL);
	}

	@Override
	public void setFarAttackAnimation(Animation anim) {
		if(anim == null) return;
		farAttack = anim;
		farAttack.setPlayMode(Animation.PlayMode.NORMAL);
	}

	@Override
	public void setMagickAttackAnimation(Animation anim) {
		if(anim == null) return;
		magickAttack = anim;
		magickAttack.setPlayMode(Animation.PlayMode.NORMAL);
		
	}
	
	@Override
	public void setSpecialSkillsAnimation(Animation[] anim) {
		if(anim == null) return;
		specialSkills = anim;
		for(Animation a : anim) {
			if(a == null) {
				specialSkills = null;
				return;
			}
			a.setPlayMode(Animation.PlayMode.NORMAL);
		}
	}

	@Override
	public TextureRegion drawAction(Float runTime) {
		this.runTime = runTime;
		return selectAction().getKeyFrame(runTime);
	}
	
	private Animation selectAction() {
		switch(getAction()) {
		case REST:
			return rest;
		case MOVEMENT:
			return movement;
		case NEAR_ATACK:
			return nearAttack;
		case FAR_ATACK:
			return farAttack;
		case MAGICK_ATACK:
			return magickAttack;
		case SPECIAL_SKILS:
			return specialSkills[getNumberSpecialSkils()];
		case DAMAGE:
			return damage;
		case DIE:
			return die;
		default:
			return rest;
		}
	}


}
