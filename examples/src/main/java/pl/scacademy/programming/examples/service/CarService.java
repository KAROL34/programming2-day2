package pl.scacademy.programming.examples.service;

import pl.scacademy.programming.examples.data.CarDataProvider;
import pl.scacademy.programming.examples.model.Car;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarService  {
    private final CarDataProvider dataProvider;
    // Predicate<Book> checkPrice = book1 -> book1.price > 29.99;
    //
    //    if (checkPrice.test(book)) {
    //      System.out.println("Drogo!");
    //    }

    public CarService(CarDataProvider dataProvider) {
       this.dataProvider=dataProvider;
    }
    public Collection<Car> findBy(Predicate<Car> condition) {

        if (Objects.isNull(condition)){
            throw new IllegalArgumentException("color must be set");
        }
        List<Car> cars=new ArrayList<>();
        for (Car car :dataProvider.getCars()){
            if(condition.test(car)){cars.add(car);}
        }
        return cars;
    }

/*    public Collection<Car> findBuColour(String red) {
        if (Objects.isNull(red)){
            throw new IllegalArgumentException("color must be set");
        }
        List<Car> cars=new ArrayList<>();
        for (Car car :dataProvider.getCars()){
            if(red.equals(car.getColour())){cars.add(car);}
        }
        return cars;
    }*/

    public Collection<Car> getBy(Predicate<Car> condition) {
        if (Objects.isNull(condition)){throw new IllegalArgumentException("color must be set");}

      //  List<Car> red1 = dataProvider.getCarsAsStream().stream().filter(g -> g.getColour().equals("red")).collect(Collectors.toList());
        return dataProvider.getCarsAsStream().filter(condition).collect(Collectors.toList());

    }

    public String checkIfExist(Predicate<Car> condition) {
        if (Objects.isNull(condition)){throw new IllegalArgumentException("color must be set");}
        Optional<Car> found=Optional.empty();
        for (Car car :dataProvider.getCars()){
            if(condition.test(car)){found=Optional.of(car);}
        }
        return  found
                .map(car -> "Zapraszamy, szukany samochod jest dostepny")
                .orElse("NIestety nie ma");




    }
    public String checkIfExistStream(Predicate<Car> condition) {
        if (Objects.isNull(condition)){throw new IllegalArgumentException("color must be set");}
        Optional<Car> found=Optional.empty();

        return  dataProvider.getCarsAsStream().filter(condition).findAny()
                .map(car -> "Zapraszamy, szukany samochod jest dostepny")
                .orElse("NIestety nie ma");




    }
}
