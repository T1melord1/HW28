import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    setSale();
    }


    private static void setSale() {
        try {
            List<String> strings = Files.readAllLines(Path.of("HW28/data/car_price.txt"));
            List<Car> cars = strings.stream().map(s ->{
                String[] items = s.split("\\s");
                return new Car(items[0],
                        Integer.parseInt(items[1]),
                        Double.parseDouble(items[2])
                );
            }).toList();


                       int currentYear = LocalDate.now().getYear();
                        List<String> carWithPrice = cars.stream()
                                .map(car -> {
                                    int age = currentYear - car.getYear();
                                    double discount = age > 5 ? 0.05 : 0.02;
                                    double discountedPrice = car.getPrice() * (1 - discount);
                                    return car.getMark() + " " + car.getYear() + " " + discountedPrice;
                                }).toList();
                Files.write(Path.of("HW28/data/car_price2.txt"),carWithPrice);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
