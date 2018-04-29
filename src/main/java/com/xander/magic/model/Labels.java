package com.xander.magic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Labels {
	private List<String> labels;

	public Labels(){

	}

	public Labels(String labels){
		this();
		this.parseAndSetLabel(labels);
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public String getLabelString() {
		if (labels != null && labels.size() > 0) {
			String label = labels.get(0);
			for (int i = 1; i < labels.size(); i++) {
				label = label + ", " + labels.get(i);
			}
			return label;
		}
		return "";
	}

	public void addLabel(String label) {
		if (this.labels == null) {
			this.labels = new ArrayList<String>();
		}
		this.labels.add(label);
	}

	public void parseAndSetLabel(String label) {
		if (label != null && !label.equals("")) {
			this.labels = Arrays.asList(label.split(", "));
		}
	}

	public String toString() {
		return this.getLabelString();
	}
}
