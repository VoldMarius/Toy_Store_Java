
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class Toy {
    private String[] toyIds;
    private String[] toyNames;
    private int[] toyWeights;
    private PriorityQueue<String> queue;

    public Toy(String ids, String names, String weights) {
        this.toyIds = ids.split(" ");//ids — это строка, в которой идентификаторы игрушек разделены пробелами,
        // каждый элемент массива toyIds соответствует идентификатору одной игрушки в том же порядке, что и их имена
        // и вес в массивах toyNames и toyWeights.

        this.toyNames = names.split(" ");//names — это строка, в которой имена игрушек разделены пробелами,
        //  каждый элемент массива toyNames соответствует имени одной игрушки в том же порядке,
        // что и их идентификаторы и вес в массивах toyIds и toyWeights.

        String[] weightString = weights.split(" "); //weights — это строка, в которой веса игрушек
        // разделены пробелами, каждый элемент массива toyWeights соответствует весу одной игрушки в том же порядке,
        // что и их идентификаторы и имена в массивах toyIds и toyNames.

        this.toyWeights = new int[weightString.length]; //Эта строка кода создает массив целых чисел toyWeights
        // длиной weightString.length. Переменная weightString представляет собой массив строк,
        // содержащий вес игрушек в порядке их идентификаторов и имен. В этой строке кода создается новый массив
        // целых чисел для хранения веса игрушек.
        this.queue = new PriorityQueue<>();

        for (int i = 0; i < weightString.length; i++) { // данный цикл проходит по всем элементам массива weightString,
            // преобразует их в целые числа сохраняет их в массив toyWeights объекта, а также добавляет элементы
            // массива toyIds в очередь queue объекта.
            this.toyWeights[i] = Integer.parseInt(weightString[i]);
            this.queue.add(this.toyIds[i]);
        }

    }

    public String get() {
        Random rand = new Random();
        int rnd = rand.nextInt(100) + 1;
        if (rnd <= 20) {
            return this.toyIds[0];
        } else if (rnd <= 40) {
            return this.toyIds[1];
        } else { // (если rnd больше 40), генерируется случайный индекс элемента в очереди queue объекта,
            // сохраняется в переменной randomIndex, преобразуется в массив методом toArray(),
            // и затем возвращается этот случайный элемент. queue.toArray(new String[queue.size()])[randomIndex]
            // преобразует очередь queue в массив объектов типа String, выбирает случайный элемент в массиве по индексу
            // randomIndex и возвращает его в качестве результата выполнения метода get().
            int randomIndex = rand.nextInt(queue.size());
            return queue.toArray(new String[queue.size()])[randomIndex];
        }
    }

    public static void main(String[] args) throws IOException {
        Toy toy = new Toy("1 2 3", "конструктор робот кукла", "2 2 6");
        String fileName = "output.txt";
        FileWriter writer = new FileWriter(fileName);
        int i = 0;
        while (i < 10) {
            try {
                writer.write(toy.get() + " ");
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл " + fileName + ": " + e.getMessage());
            }
            i++;
        }
        writer.close();
    }
}
