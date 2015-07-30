package org.abstractfactory;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;

public class FactoryUnits {
	private JSONObject units;
	private static FactoryUnits instens;
	private AnimationModel aModel;

	private FactoryUnits() {
		String json = "";
		FileHandle unitsFile = Gdx.files.internal("units.json");
		json = unitsFile.readString();
		try {
			units = new JSONObject(json);
		} catch (JSONException e) {
			units = null;
			e.printStackTrace();
		}
	}

	public static FactoryUnits getInstens() {
		if (instens == null) {
			instens = new FactoryUnits();
		}
		return instens;
	}

	public void setAnimationModel(AnimationModel aModel) {
		this.aModel = aModel;
	}

	private Number readField(String field, JSONObject inform) {
		try {
			Number value = ("" + inform.get(field)).equalsIgnoreCase("null") ? null : inform.getDouble(field);
			return value != null ? value : -1;
		} catch (Exception e) {
			return -1;
		}
	}

	public Unit creat(String name) {
		JSONObject information = null;
		try {
			information = units.getJSONObject(name);
		} catch (JSONException e) {
			return null;
		}
		Unit unit = new Unit();
		Number value = readField("health", information);
		unit.setHealth(value.intValue() < 0 ? null : value.intValue());
		value = readField("mana", information);
		unit.setMana(value.intValue() < 0 ? null : value.intValue());
		value = readField("nearArmor", information);
		unit.setNearArmor(value.intValue() < 0 ? null : value.intValue());
		value = readField("magicArmor", information);
		unit.setMagicArmor(value.intValue() < 0 ? null : value.intValue());
		value = readField("rangeArmor", information);
		unit.setRangeArmor(value.intValue() < 0 ? null : value.intValue());
		value = readField("nearDamage", information);
		unit.setNearDamage(value.intValue() < 0 ? null : value.intValue());
		value = readField("magicDamage", information);
		unit.setMagicDamage(value.intValue() < 0 ? null : value.intValue());
		value = readField("rangeDamage", information);
		unit.setRangeDamage(value.intValue() < 0 ? null : value.intValue());
		value = readField("nearPower", information);
		unit.setNearPower(value.intValue() < 0 ? null : value.intValue());
		value = readField("magicPower", information);
		unit.setMagicPower(value.intValue() < 0 ? null : value.intValue());
		value = readField("rangePower", information);
		unit.setRangePower(value.intValue() < 0 ? null : value.intValue());
		value = readField("money", information);
		unit.setMoney(value.intValue() < 0 ? null : value.intValue());
		value = readField("criticalHit", information);
		unit.setCriticalHit(value.doubleValue() < 0 ? null : value.doubleValue());
		value = readField("distanceAtack", information);
		unit.setDistanceAtack(value.doubleValue() < 0 ? null : value.doubleValue());
		value = readField("distanceMove", information);
		unit.setDistanceMove(value.doubleValue() < 0 ? null : value.doubleValue());
		value = readField("sizeX", information);
		unit.setSizeX(value.intValue() < 0 ? null : value.intValue());
		value = readField("sizeY", information);
		unit.setSizeY(value.intValue() < 0 ? null : value.intValue());
		if (aModel != null) {
			try {
				unit.setRestAnimation(aModel.stringArrayToAnimation(information
						.get("rest")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			try {
				unit.setMovementAnimation(aModel.stringArrayToAnimation(information
						.get("movement")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			try {
				unit.setDamageAnimation(aModel.stringArrayToAnimation(information
						.get("damage")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			try {
				unit.setDieAnimation(aModel.stringArrayToAnimation(information
						.get("die")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			try {
				unit.setNearAttackAnimation(aModel
						.stringArrayToAnimation(information.get("nearAttack")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			try {
				unit.setFarAttackAnimation(aModel
						.stringArrayToAnimation(information.get("farAttack")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			try {
				unit.setMagickAttackAnimation(aModel
						.stringArrayToAnimation(information.get("magickAttack")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			String[] a = null;
			try {
				a = information.get("specialSkills") == null ? null
						: ((String) information.get("specialSkills")).split(";");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(a != null) {
				Animation[] skills = new Animation[a.length];
				for(int i = 0; i < skills.length; i++) {
					skills[i] = aModel.stringArrayToAnimation(a[i]);
				}
				unit.setSpecialSkillsAnimation(skills);
			}
		}
		return unit;
	}
}
