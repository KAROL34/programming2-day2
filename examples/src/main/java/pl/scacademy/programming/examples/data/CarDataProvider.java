package pl.scacademy.programming.examples.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import pl.scacademy.programming.examples.model.Car;

public class CarDataProvider {

	private Collection<Car> cars = initData();

	private static Collection<Car> initData() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Opel", "Astra", "Black"));
		cars.add(new Car("Opel", "Astra", "White"));
		cars.add(new Car("Opel", "Astra", "Grey"));
		cars.add(new Car("Opel", "Astra", "RED"));
		cars.add(new Car("Opel", "Isignia", "Black"));
		cars.add(new Car("Fiat", "Panda", "Black"));
		cars.add(new Car("Fiat", "Panda", "Red"));
		cars.add(new Car("Fiat", "Panda", "Orange", Collections.singleton("Metalic")));
		cars.add(new Car("Fiat", "Panda", "Orange"));
		cars.add(new Car("Toyota", "Aygo", "Black"));
		cars.add(new Car("Toyota", "Aygo", "Blue"));
		cars.add(new Car("Toyota", "Aygo", "red"));
		cars.add(new Car("Toyota", "Avensis", "Red", Arrays.asList("Automatic", "Metalic")));
		cars.add(new Car("Toyota", "Avensis", "Blue"));
		return cars;
	}


	public Collection<Car> getCars() {
		return Collections.unmodifiableCollection(cars);
	}

	public Stream<Car> getCarsAsStream() {return (Stream<Car>) cars.stream();
	}


}
