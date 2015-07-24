package org.abstractfactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.graphics.g2d.Animation;

public class FactoryUnits {
	private JSONObject units;
	private static FactoryUnits instens;
	private AnimationModel aModel;

	private FactoryUnits() {
		String json = "";
		try {
			BufferedReader read = new BufferedReader(new FileReader(
					"resourses/Units/units.json"));
			while (read.ready()) {
				json += read.readLine();
			}
			read.close();
		} catch (IOException e1) {
			json = null;
			e1.printStackTrace();
		}
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

	private <Type> Type readField(String field, Type x, JSONObject inform) {
		try {
			return ((String)inform.get(field)).equalsIgnoreCase("null") ? null : (Type)inform.get(field);
		} catch (Exception e) {
			return null;
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
		Integer f = readField("health", 0, information);
		unit.setHealth(readField("health", 0, information));
		unit.setMana(readField("mana", 0, information));
		unit.setNearArmor(readField("nearArmor", 0, information));
		unit.setMagicArmor(readField("magicArmor", 0, information));
		unit.setRangeArmor(readField("rangeArmor", 0, information));
		unit.setNearDamage(readField("nearDamage", 0, information));
		unit.setMagicDamage(readField("magicDamage", 0, information));
		unit.setRangeDamage(readField("rangeDamage", 0, information));
		unit.setNearPower(readField("nearPower", 0, information));
		unit.setMagicPower(readField("magicPower", 0, information));
		unit.setRangePower(readField("rangePower", 0, information));
		unit.setMoney(readField("money", 0, information));
		unit.setCriticalHit(readField("criticalHit", 0d, information));
		unit.setDistanceAtack(readField("distanceAtack", 0d, information));
		unit.setDistanceMove(readField("distanceMove", 0d, information));
		unit.setSizeX(readField("sizeX", 0, information));
		unit.setSizeY(readField("sizeY", 0, information));
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
