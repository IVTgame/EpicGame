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
	private Animation magickAttack;
	private Animation damage;
	private Animation die;
	private Animation[] specialSkills;
	private Float runTime = 0f;
	
	@Override
	public void setAction(Action action) {
    	super.setAction(action);
    	runTime = 0f;
    }
	
	@Override
	public void setRestAnimation(Animation anim) {
		rest = anim;
		rest.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	@Override
	public void setMovementAnimation(Animation anim) {
		movement = anim;
		movement.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	@Override
	public void setDamageAnimation(Animation anim) {
		damage = anim;
		damage.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}
	
	@Override
	public void setDieAnimation(Animation anim) {
		die = anim;
		die.setPlayMode(Animation.PlayMode.NORMAL);
	}
	@Override
	public void setNearAttackAnimation(Animation anim) {
		nearAttack = anim;
		nearAttack.setPlayMode(Animation.PlayMode.NORMAL);
	}

	@Override
	public void setFarAttackAnimation(Animation anim) {
		farAttack = anim;
		farAttack.setPlayMode(Animation.PlayMode.NORMAL);
	}

	@Override
	public void setMagickAttackAnimation(Animation anim) {
		magickAttack = anim;
		magickAttack.setPlayMode(Animation.PlayMode.NORMAL);
		
	}
	
	@Override
	public void setSpecialSkillsAnimation(Animation[] anim) {
		specialSkills = anim;
		for(Animation a : anim) {
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
