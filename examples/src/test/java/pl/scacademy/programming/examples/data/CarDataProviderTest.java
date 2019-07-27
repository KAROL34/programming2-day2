package pl.scacademy.programming.examples.data;



import org.junit.jupiter.api.Test;
import pl.scacademy.programming.examples.model.Car;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


class CarDataProviderTest {
    CarDataProvider carDataProvider = new CarDataProvider();

    @Test
    void shouldReturnCollectionWithKnownOfElements(){
        Collection<Car> result = carDataProvider.getCars();
        
        assertThat(result.size()).isEqualTo(14);

        //result.clear();

    }
    @Test
    void shouldReturnStreamWithKnownOfElements(){
        Collection<Car> result = (Collection<Car>) carDataProvider.getCarsAsStream();
        assertThat(result.size()).isEqualTo(14);
    }


    }