import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(final String[] args) throws Exception {

        int[] iTop = { 0, 0 };
        Scanner sc = new Scanner(System.in);
        int iInputY = sc.nextInt();
        int iInputX = sc.nextInt();

        int iFeildY = 0;
        int iFeildX = 0;

        for (int y = 0; y < iInputY; y++) {
            iFeildY++;
            System.out.print("・");
            for (int x = 0; x < iInputX - 1; x++) {
                iFeildX++;
                System.out.print("・");
            }
            System.out.print("\n");
        }
        int[] FEILD_NUM = { iFeildY, iFeildX };

        for (int y = 0; y < iFeildY; y++) {
            
        }

    }
}
