package pl.scacademy.programming.examples.service;

import org.junit.jupiter.api.Test;
import pl.scacademy.programming.examples.data.CarDataProvider;
import pl.scacademy.programming.examples.model.Car;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarServiceTest {
    private CarService carService;

    @Test
    void shouldFind4RedCarsViaSimpleSearch() {
        CarDataProvider dataProvider = mock(CarDataProvider.class);
        when(dataProvider.getCars()).thenReturn(Arrays.asList(new Car("", "", "red"),
                new Car("", "", "red"),
                new Car("", "", "red"),
                new Car("", "", "red")));
        carService = new CarService(dataProvider);
        Collection<Car> cars = carService.findBy(car -> car.getColour().equals("red"));
        assertThat(cars.size()).isEqualTo(4);


    }
 /*   @Test
    void shouldFind4RedCarsViaStreamSearch() {
        CarDataProvider dataProvider = mock(CarDataProvider.class);
        when(dataProvider.getCars()).thenReturn(Arrays.asList(new Car("", "", "red"),
                new Car("", "", "red"),
                new Car("", "", "red"),
                new Car("", "", "red")));
        carService = new CarService(dataProvider);
        Collection<Car> cars = carService.getByColour("red");
        assertThat(cars.size()).isEqualTo(4);
    }
    */
 @Test
 void shouldFind4RedCarsViaStreamSearch() {
     //void shouldReturnCollectionWithKnownOfElements(){
     //        Collection<Car> result = carDataProvider.getCars();
     //
     //        assertThat(result.size()).isEqualTo(14);
   carService =new CarService(new CarDataProvider());
     Collection<Car> cars=  carService.getBy(g->g.getColour().toLowerCase().equals("red"));
     assertThat(cars.size()).isEqualTo(4);
 }
    @Test
    void shouldFindRedOpelAstraViaStreamSearch() {
        //void shouldReturnCollectionWithKnownOfElements(){
        //        Collection<Car> result = carDataProvider.getCars();
        //
        //        assertThat(result.size()).isEqualTo(14);
        Predicate<Car> condition;
        condition= c->"red".equalsIgnoreCase(c.getColour().toLowerCase());
        condition=condition.and(c->"astra".equalsIgnoreCase(c.getModel().toLowerCase()));
        condition=condition.and(c->"opel".equalsIgnoreCase(c.getProducer().toLowerCase()));
        carService =new CarService(new CarDataProvider());
        Collection<Car> cars=  carService.getBy(condition);
        assertThat(cars.size()).isEqualTo(1);
    }
    @Test
    void shouldFindRedOpelAstraViaSimpleSearch() {
        //void shouldReturnCollectionWithKnownOfElements(){
        //        Collection<Car> result = carDataProvider.getCars();
        //
        //        assertThat(result.size()).isEqualTo(14);
        Predicate<Car> condition;
        condition= c->"red".equalsIgnoreCase(c.getColour().toLowerCase());
        condition=condition.and(c->"astra".equalsIgnoreCase(c.getModel().toLowerCase()));
        condition=condition.and(c->"opel".equalsIgnoreCase(c.getProducer().toLowerCase()));
        carService =new CarService(new CarDataProvider());
        Collection<Car> cars=  carService.findBy(condition);
        assertThat(cars.size()).isEqualTo(1);
    }

    @Test
    void shouldInformAClientThatCarWithAtrributesAvailable() {
        //void shouldReturnCollectionWithKnownOfElements(){
        //        Collection<Car> result = carDataProvider.getCars();
        //
        //        assertThat(result.size()).isEqualTo(14);
        Predicate<Car> condition;
        condition= c->"red".equalsIgnoreCase(c.getColour().toLowerCase());
        condition=condition.and(c->"astra".equalsIgnoreCase(c.getModel().toLowerCase()));
        condition=condition.and(c->"opel".equalsIgnoreCase(c.getProducer().toLowerCase()));
        carService =new CarService(new CarDataProvider());
        String message=  carService.checkIfExist(condition);

        assertThat(message).isEqualTo("Zapraszamy, szukany samochod jest dostepny");
    }
    @Test
    void shouldInformAClientThatCarWithAtrributesNotAvailable() {
        //void shouldReturnCollectionWithKnownOfElements(){
        //        Collection<Car> result = carDataProvider.getCars();
        //
        //        assertThat(result.size()).isEqualTo(14);
        Predicate<Car> condition;
        condition= c->"red".equalsIgnoreCase(c.getColour().toLowerCase());
        condition=condition.and(c->"astra".equalsIgnoreCase(c.getModel().toLowerCase()));
        condition=condition.and(c->"opel".equalsIgnoreCase(c.getProducer().toLowerCase()));
        carService =new CarService(new CarDataProvider());
        String message=  carService.checkIfExist(condition);

        assertThat(message).isNotEqualTo("NIestety nie ma");
    }
}
