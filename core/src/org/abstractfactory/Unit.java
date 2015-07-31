package org.abstractfactory;


import org.epicgame.basichero.BasicHero;
import org.epicgame.defaultclasses.Point;
import org.epicgameheroesinterfaces.DrawableAction;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Unit extends BasicHero implements DrawableAction {
	
	public static Action ACTION;
	private Animation rest;
	private Animation movement;
	private Animation nearAttack;
	private Animation farAttack;
	private Animation magickAttack;
	private Animation damage;
	private Animation die;
	private Float runTime = 0f;
	private Boolean fly = false;
	private Point positionUnitToField = new Point();
	private Point positionUnitPixel = new Point();
	private final String NAME;
	private final int WHO_CONTROLS;
	public static final int GAMER = 1;
	public static final int BOT = 2;

	Unit(String name, int whoControls) {
		setAction(Action.REST);
		this.NAME = name;
		this.WHO_CONTROLS = whoControls;
	}
	
	@Override
	public void act(float deltaTime) {
		runTime += deltaTime;
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(drawAction(), positionUnitPixel.x, positionUnitPixel.y, getSizeX() * getScaleX(), getSizeY() * getScaleY());
	}
	
	@Override
	public Actor hit (float x, float y, boolean touchable) {
		return x == positionUnitToField.x && y == positionUnitToField.y ? this : null;
	}
	
	public int getWhoControls() {
		return WHO_CONTROLS;
	}
	
	public String getName() {
		return NAME;
	}

	public Boolean getFly() {
		return fly;
	}

	public void setFly(Boolean fly) {
		this.fly = fly;
	}

	@Override
	public void setAction(Action action) {
		super.setAction(action);
		runTime = 0f;
	}

	@Override
	public void setRestAnimation(Animation anim) {
		if (anim == null)
			return;
		rest = anim;
		rest.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	@Override
	public void setMovementAnimation(Animation anim) {
		if (anim == null)
			return;
		movement = anim;
		movement.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	@Override
	public void setDamageAnimation(Animation anim) {
		if (anim == null)
			return;
		damage = anim;
		damage.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	@Override
	public void setDieAnimation(Animation anim) {
		if (anim == null)
			return;
		die = anim;
		die.setPlayMode(Animation.PlayMode.NORMAL);
	}

	@Override
	public void setNearAttackAnimation(Animation anim) {
		if (anim == null)
			return;
		nearAttack = anim;
		nearAttack.setPlayMode(Animation.PlayMode.NORMAL);
	}

	@Override
	public void setFarAttackAnimation(Animation anim) {
		if (anim == null)
			return;
		farAttack = anim;
		farAttack.setPlayMode(Animation.PlayMode.NORMAL);
	}

	@Override
	public void setMagickAttackAnimation(Animation anim) {
		if (anim == null)
			return;
		magickAttack = anim;
		magickAttack.setPlayMode(Animation.PlayMode.NORMAL);

	}

	private TextureRegion drawAction() {
		Animation selected = selectAction();
		if (selected != null && selected.getPlayMode() == Animation.PlayMode.NORMAL
				&& selected.isAnimationFinished(this.runTime)) {
			setAction(Action.REST);
			this.runTime = 0f;
		}
		return selected == null ? rest.getKeyFrame(this.runTime) : selected
				.getKeyFrame(this.runTime);
	}

	private Animation selectAction() {
		switch (getAction()) {
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
		case DAMAGE:
			return damage;
		case DIE:
			return die;
		default:
			return rest;
		}
	}
	
	public void changePositionPixel(int x, int y) {
		positionUnitPixel.x = x;
		positionUnitPixel.y = y;
	}
	
	public void changePositionToField(int x, int y) {
		positionUnitToField.x = x;
		positionUnitToField.y = y;
	}
	
	public Point getPositionPixel() {
		return positionUnitPixel;
	}
	
	public Point getPositionToField() {
		return positionUnitToField;
	}
}
