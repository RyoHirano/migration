
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> mapPrice = new Map<Integer, Integer>();

        int iFrultNum = sc.nextInt();
        int iBuyNum = sc.nextInt();
        sc.next();
        for (int i = 0; i < iFrultNum; i++) {
            mapPrice.put(i, sc.nextInt());
        }

        Collections.min(mapPrice);
    }
}
