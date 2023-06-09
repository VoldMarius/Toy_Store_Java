
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
        this.toyIds = ids.split(" ");
        this.toyNames = names.split(" ");
        String[] weightString = weights.split(" ");
        this.toyWeights = new int[weightString.length];
        this.queue = new PriorityQueue<>();

        for (int i = 0; i < weightString.length; i++) {
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
        } else {
            int randomIndex = rand.nextInt(queue.size());
            return queue.toArray(new String[queue.size()])[randomIndex];
        }
    }

