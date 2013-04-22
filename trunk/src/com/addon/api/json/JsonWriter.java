package com.addon.api.json;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class JsonWriter {

	private static final String RETURN = "\r\n";
	private OutputStreamWriter outputStreamWriter;
	private String indent;
	private int level = 0;
	private ArrayList<Integer> index = new ArrayList<Integer>();

	public JsonWriter(OutputStreamWriter outputStreamWriter) {
		this.outputStreamWriter = outputStreamWriter;
	}

	public void setIndent(String indent) {
		this.indent = indent;
	}

	public void beginObject() throws IOException {
		writeIntent();
		outputStreamWriter.write("{"+RETURN);
		level++;
	}

	public void endObject() throws IOException {
		writeIntent();
		outputStreamWriter.write("}+RETURN");
		level--;
	}

	public void beginArray() throws IOException {
		writeIntent();
		outputStreamWriter.write("[+RETURN");
		level++;
	}

	public void endArray() throws IOException {
		writeIntent();
		outputStreamWriter.write("]+RETURN");
		level--;
	}
	
	public JsonWriter name(String name) throws IOException {
		writeIntent();
		int idx = index.get(level);
//		JsonElement element = new JsonElement(outputStreamWriter, name, idx);
		return this;
	}

	public JsonWriter value(boolean value) throws IOException {
		return this;
	}

	public JsonWriter value(double value) throws IOException {
		return this;
	}

	public JsonWriter value(long value) throws IOException {
		return this;
	}

	public JsonWriter value(Number value) throws IOException {
		return this;
	}

	public JsonWriter value(String value) throws IOException {
		return this;
	}

	public void close() throws IOException {
		outputStreamWriter.close();
	}
	
	private void writeIntent() throws IOException {
		for(int i=0 ; i<level ; i++) {
			outputStreamWriter.write(indent);
		}
	}
	
	private void initIndex() {
		if (level>index.size())
			index.add(0);
		else
			index.set(level, index.get(level) + 1);
	}
}
