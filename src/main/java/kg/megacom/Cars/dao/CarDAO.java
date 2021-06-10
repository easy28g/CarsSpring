package kg.megacom.Cars.dao;

import kg.megacom.Cars.models.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    private static int carsID;

    private ArrayList<Car> carList;
    {
        carList = new ArrayList<>();
        carList.add(new Car(++carsID, "Honda", "Silver", 2020));
        carList.add(new Car(++carsID, "Honda", "White", 2021));
    }

    public List<Car> index(){
        return carList;
    }

    public Car show(int id){

        return carList.stream().filter(car -> car.getId() == id).findAny().orElse(null);
    }

    public void save(Car car){
        car.setId(++carsID);
        carList.add(car);
    }

    public void delete(int id){
        Car car = (Car)this.carList.stream()
                .filter(car1 -> {return car1.getId() == id;})
                .findAny().get();
        this.carList.remove(car);
    }

    public void update(Car car, int id){
        Car carToBeUpdate = show(id);
        carToBeUpdate.setMark(car.getMark());
        carToBeUpdate.setColor(car.getColor());
        carToBeUpdate.setYear(car.getYear());
    }
}

























