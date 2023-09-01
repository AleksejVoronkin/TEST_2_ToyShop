import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class ToyQueue {
    private Queue<Toy> toyQueue;

    public ToyQueue(List<Toy> toys) {
        this.toyQueue = new PriorityQueue<>(toys);
    }

    public void writeResultsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, StandardCharsets.UTF_8))) {
            Random random = new Random();
            /// тут достают 5 игрушек из 10 присутствующих. После как достали убираем ее из списка. 
            /// Я не стал делать, чтобы был выбор сколько достать, но сделать его нет так сложно. просто на таком примере проще проверить
            /// когда из 10 достаем только 5
            for (int i = 0; i < 5; i++) {
                Toy toy = getRandomToy(random);
                writer.write(toy.getId());
                writer.write("  ");
                writer.write(toy.getName());
                writer.newLine();
                toyQueue.remove(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/// тут уже по весу вероятность, что игрушку достанут. в оригнале и измененном задание, чем она тяжелее тем выше шанс. Тут также
    private Toy getRandomToy(Random random) {
        int totalWeight = toyQueue.stream().mapToInt(Toy::getWeight).sum();
        int randomNumber = random.nextInt(totalWeight);
        int currentWeight = 0;
            for (Toy toy : toyQueue) {
                currentWeight += toy.getWeight();
                if (randomNumber < currentWeight) {
                    return toy;
                }
            }
        return toyQueue.peek();
    }
}