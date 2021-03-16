package web.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import web.model.Car;

@Component
public class CarService {
  private static int CAR_COUNT;
  private List<Car> cars;
  {
    cars = new ArrayList<>();
    cars.add(new Car(++CAR_COUNT, "GAZ",3310,1987));
    cars.add(new Car(++CAR_COUNT,"VAZ",2101,1975));
    cars.add(new Car(++CAR_COUNT,"Moskvich",412,1971));
    cars.add(new Car(++CAR_COUNT,"BMV",3,2014));
    cars.add(new Car(++CAR_COUNT,"AUDI",7,2020));
  }
  public List<Car> listCar(int cnt){
    return cars.subList(0,cnt);
  }

  public Car getCar(int id){
    return cars.stream().filter(car -> car.getId() == id).findAny().orElse(null);
  }
}
