import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        System.out.println("Добро пожаловать в гонку '24 часа Ле-Мана'!");
        int carCount = 3;
        for (int i = 1; i <= carCount; i++) {
            System.out.println("Введите название автомобиля №" + i + ":");
            String name = scanner.nextLine();
            int speed = 0;
            while (true) {
                System.out.println("Введите скорость автомобиля (1-250 км/ч):");
                try {
                    speed = Integer.parseInt(scanner.nextLine());
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Ошибка: скорость должна быть в диапазоне от 1 до 250 км/ч.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число.");
                }
            }
            cars.add(new Car(name, speed));
        }
        Race race = new Race(cars);
        Car winner = race.getWinner();
        System.out.println("Самая быстрая машина: " + winner.getName());
    }
}

class Car {
    private final String name;
    private final int speed;
    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }
    public String  getName() {
        return name;
    }
    public int getDistanceAfterHours(int hours) {
        return speed * hours;
    }
}

class Race {
    private final List<Car> cars;
    public Race(List<Car> cars) {
        this.cars = cars;
    }
    public Car getWinner() {
        Car winner = null;
        int maxDistance = -1;
        for (Car car : cars) {
            int distance = car.getDistanceAfterHours(24);
            if (distance > maxDistance) {
                maxDistance = distance;
                winner = car;
            }
        }
        return winner;
    }
}
