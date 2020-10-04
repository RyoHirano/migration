import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int iResult = 0;
        for (int i = 1; i <= 5; i++) {
            if (0 == Integer.parseInt(sc.next())) {
                iResult = i;
            }
        }
        System.out.print(iResult);

    }
}
