import java.util.ArrayList;
import java.util.List;

public class ToyGame {

    public static void main(String[] args) {
        List<Toy> toys = createToysList();
        ToyQueue toyQueue = new ToyQueue(toys);
        toyQueue.writeResultsToFile("ToyResults.txt");
    }
/// я представляю этот розыгрыш как те самые автоматы в магазине с манипулятором. 
/// "Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки)"
/// Решил сделать так, только не стал делать изменение через терминал.
/// Номера и вес выставил такие чтобы было удобнее проверять так как чем выше id тем тяжелее игрушка

    private static List<Toy> createToysList() {
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("1", "Лего", 10));
        toys.add(new Toy("2", "Машинка", 9));
        toys.add(new Toy("3", "Кукла", 8));
        toys.add(new Toy("4", "Кубик-Рубик", 7));
        toys.add(new Toy("5", "Робот", 6));
        toys.add(new Toy("6", "Самолет", 5));
        toys.add(new Toy("7", "Меч", 4));
        toys.add(new Toy("8", "Мяч", 3));
        toys.add(new Toy("9", "Пистолет", 2));
        toys.add(new Toy("10", "Лодка", 1));
        return toys;
    }
}