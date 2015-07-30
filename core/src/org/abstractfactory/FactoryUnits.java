package org.abstractfactory;

import org.json.JSONException;
import org.json.JSONObject;

public class FactoryUnits {
	private JSONObject units;
	private AnimationModel aModel;

	public FactoryUnits(JSONObject units) {
		this.units = units;
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

	public Unit creat(String name, int whoControls) {
		JSONObject information = null;
		try {
			information = units.getJSONObject(name);
		} catch (JSONException e) {
			return null;
		}
		Unit unit = new Unit(name, whoControls);
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
		//new
		value = readField("initiative", information);
		unit.setInitiative(value.intValue() < 0 ? null : value.intValue());
		value = readField("capacity", information);
		unit.setCapacity(value.intValue() < 0 ? null : value.intValue());
		value = readField("increment", information);
		unit.setIncrement(value.intValue() < 0 ? null : value.intValue());
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
		}
		return unit;
	}
}
