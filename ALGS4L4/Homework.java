import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Homework {
  
  /**
   * Необходимо создать класс Box, описывающий коробку с фруктами. В одной коробке должны быть фрукты только одного типа.
   * У коробки должны быть методы:
   * 1. Метод добавления нового фрукта в коробку: add(Fruit fruit)
   * 2. Метод подсчета суммарного веса коробки: getWeight()
   * 3. Метод пересыпания фруктов из одной коробки в другую: move(Box<T> box)
   * 4. * Реализовать итератор для коробки. То есть должна быть возможность использовать цикл foreach для итерации по фруктам в коробке.
   */

  public static void main(String[] args) {
    Box<Apple> appleBox = new Box<>();
    System.out.println(appleBox.getWeight()); // 0

    appleBox.add(new Apple(2)); // Should compile
    appleBox.add(new Apple(4)); // Should compile
    System.out.println(appleBox.getWeight()); // 6
    // appleBox.add(new Orange(4)); // Should not compile!!!
    appleBox.add(new GoldenApple(4)); // Should compile
    System.out.println(appleBox.getWeight()); // 10

    Box<Orange> orangeBox = new Box<>();
    // orangeBox.add(new Apple(2)); // Should not compile!!!
    orangeBox.add(new Orange(8)); // Should compile
    System.out.println(orangeBox.getWeight()); // 8

    // orangeBox.move(appleBox); // Should not compile!!!
    // appleBox.move(orangeBox); // Should not compile!!!

    Box<GoldenApple> goldenAppleBox = new Box<>();
    goldenAppleBox.add(new GoldenApple(20)); // Should compile
    // goldenAppleBox.add(new Apple(2)); // Should not compile!!!
    // goldenAppleBox.add(new Orange(8)); // Should not compile!!!
  }
}

class Box<T extends Fruit> implements Iterable<T> {
  private List<T> fruits;

  public Box() {
    fruits = new ArrayList<>();
  }

  public void add(T fruit) {
    fruits.add(fruit);
  }

  public double getWeight() {
    double totalWeight = 0;
    for (T fruit : fruits) {
      totalWeight += fruit.getWeight();
    }
    return totalWeight;
  }

  public void move(Box<T> box) {
    box.fruits.addAll(this.fruits);
    this.fruits.clear();
  }

  @Override
  public Iterator<T> iterator() {
    return fruits.iterator();
  }
}

abstract class Fruit {
  public abstract double getWeight();
}

class Apple extends Fruit {
  private double weight;

  public Apple(double weight) {
    this.weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }
}

class Orange extends Fruit {
  private double weight;

  public Orange(double weight) {
    this.weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }
}

class GoldenApple extends Apple {
  public GoldenApple(double weight) {
    super(weight);
  }
}