package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMaping {
	private Map<String, Controller> mappings;

	public HandlerMaping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}

}
