package pl.scacademy.programming.examples.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Car {
	private final String producer;
	private final String model;
	private String colour;
	private final Set<String> extra = new HashSet<>();

	public Car(String producer, String model, String colour) {
		this.producer = producer;
		this.model = model;
		this.colour = colour;
	}

	public Car(String producer, String model, String colour, Collection<String> extra) {
		this(producer, model, colour);
		if (extra == null || extra.isEmpty()) {
			throw new IllegalArgumentException("Extra must be set");
		}
		this.extra.addAll(extra);
	}

	public String getProducer() {
		return producer;
	}

	public String getModel() {
		return model;
	}

	public String getColour() {
		return colour;
	}

	public Collection<String> getExtra() {
		return Collections.unmodifiableSet(extra);
	}

	public void setColour(String unknown) {
		this.colour = unknown;
	}
}
