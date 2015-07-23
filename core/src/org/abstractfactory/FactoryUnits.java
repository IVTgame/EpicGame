package org.abstractfactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class FactoryUnits {
	JSONObject units;
	private static FactoryUnits instens;
	
	public static void main(String[] arg) {
		Unit u = FactoryUnits.getInstens().creat("DarkHunter");
	}
	
	
	private FactoryUnits() {
		String json = "";
		try {
			BufferedReader read = new BufferedReader(new FileReader("resourses/Units/units.json"));
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
		if(instens == null) {
			instens = new FactoryUnits();
		}
		return instens;
	}
	
	private<Type> Type readField(String field, Type x, JSONObject inform) {
		try {
			return (Type)inform.get(field);
		} catch (JSONException e) {
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
		return unit;
	}
}
