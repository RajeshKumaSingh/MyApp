package com.myapp.form;

import java.util.List;

public class HomeForm {

	boolean selected;
	private List<String> mapping;
	private List<String> values;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public List<String> getMapping() {
		return mapping;
	}

	public void setMapping(List<String> mapping) {
		this.mapping = mapping;
	}
}
