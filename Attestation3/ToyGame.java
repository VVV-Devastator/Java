package Attestation3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToyGame {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyGame() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(String id, String name, int quantity, double frequency) {
        Toy toy = new Toy(id, name, quantity, frequency);
        toys.add(toy);
    }

    public void setFrequency(String id, double frequency) {
        for (Toy toy : toys) {
            if (toy.getId().equals(id)) {
                toy.setFrequency(frequency);
                break;
            }
        }
    }

    public void playGame() {
        for (Toy toy : toys) {
            int numPrizes = (int) (toy.getQuantity() * toy.getFrequency() / 100.0);
            for (int i = 0; i < numPrizes; i++) {
                prizeToys.add(toy);
            }
        }
    }

    public Toy getPrizeToy() {
        if (prizeToys.isEmpty()) {
            return null; // No more prize toys available
        }
        Toy prizeToy = prizeToys.remove(0);
        prizeToy.decrementQuantity();
        return prizeToy;
    }

    public void writePrizeToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            //System.out.println(filePath);
            for (Toy toy : prizeToys) {
              //System.out.println(toy.getId() + " " + toy.getName() + System.lineSeparator());
              writer.write(toy.getId() + " " + toy.getName() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyGame toyGame = new ToyGame();
        toyGame.addToy("12", "конструктор", 10, 20);
        toyGame.addToy("22", "робот", 5, 20);
        toyGame.addToy("36", "кукла", 8, 30);
        toyGame.addToy("44", "мяч", 10, 40);
        toyGame.setFrequency("10", 10); // Пример изменения веса игрушки с id "12"

        toyGame.playGame();
        
        toyGame.writePrizeToFile("output.txt");

        for (int i = 0; i < 10; i++) {
            Toy prizeToy = toyGame.getPrizeToy();
            if (prizeToy != null) {
                System.out.println("Выигрышная игрушка: " + prizeToy.getName());
            } else {
                System.out.println("Больше нет призовых игрушек.");
                break;
            }
        }

        
    }
}

