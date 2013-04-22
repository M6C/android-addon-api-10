package com.addon.api.json;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class JsonElement {

	private OutputStreamWriter outputStreamWriter;
	private String name;
	private int index;

	public JsonElement(OutputStreamWriter outputStreamWriter, String name, int index) {
		this.outputStreamWriter = outputStreamWriter;
		this.name = name;
		this.index = index;
	}

	public void value(int value) throws IOException {
		outputStreamWriter.write("'" + name + "' : '" + String.valueOf(value) + "'");
	}

	public void value(long value) throws IOException {
		outputStreamWriter.write("'" + name + "' : '" + String.valueOf(value) + "'");
	}

	public void value(float value) throws IOException {
		outputStreamWriter.write("'" + name + "' : '" + String.valueOf(value) + "'");
	}

	public void value(double value) throws IOException {
		outputStreamWriter.write("'" + name + "' : '" + String.valueOf(value) + "'");
	}

	public void value(String value) throws IOException {
		outputStreamWriter.write("'" + name + "' : '" + String.valueOf(value) + "'");
	}
}
