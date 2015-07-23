package org.abstractfactory;

import org.json.JSONObject;

public class FactoryUnits {
	JSONObject obj;
	private FactoryUnits instens;
	
	
	private FactoryUnits() {
		
		
	}
	
	public FactoryUnits getInstens() {
		if(instens == null) {
			instens = new FactoryUnits();
		}
		return instens;
	}
}
