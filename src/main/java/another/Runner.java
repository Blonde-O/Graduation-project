package another;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<Integer> generated = new HashSet<Integer>();
        Random r = new Random();
        while (generated.size() < 3) {
            generated.add(r.nextInt(10) + 1);
        }
        System.out.println(generated.toString());
    }
}
