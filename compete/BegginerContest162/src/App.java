import java.util.Scanner;

public class App {

    static final int FIZZ_VAL = 3;
    static final int BUZZ_VAL = 5;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int iInputVal = Integer.parseInt(sc.next());
        long lResult = 0;
        for (int iColumn = 1; iColumn <= iInputVal; iColumn++) {
            if (0 == isFizz(iColumn)) {
                continue;
            } else if (0 == isBuzz(iColumn)) {
                continue;
            } else if (0 == isFizz(iColumn) && 0 == isBuzz(iColumn)) {
                continue;
            }
            lResult += iColumn;
        }

        System.out.print(lResult);
    }

    private static int isFizz(final int iVal) {
        return iVal % FIZZ_VAL;
    }

    private static int isBuzz(final int iVal) {
        return iVal % BUZZ_VAL;
    }

}
