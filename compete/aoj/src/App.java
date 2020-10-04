import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(sc.next()));
        list.add(Integer.parseInt(sc.next()));
        list.add(Integer.parseInt(sc.next()));
        output(list);
        sc.close();
    }

    private static void output(final ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();

        sb.append(Collections.min(list));
        sb.append(" ");
        sb.append(Collections.max(list));
        System.out.println(sb);
    }
}
