import java.util.Scanner;

public class App {

    private static int m_iTotalTaskDays;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        final int iVacationDay = Integer.parseInt(sc.next());
        final int iTaskNum = Integer.parseInt(sc.next());
        for (int i = 0; i < iTaskNum; i++) {
            final int iTaskDays = Integer.parseInt(sc.next());
            calcTotalTaskDays(iTaskDays);
        }
        int iResult = iVacationDay - m_iTotalTaskDays;
        if (0 > (iResult)) {
            iResult = -1;
        }
        System.out.print(iResult);
    }

    private static void calcTotalTaskDays(final int iTaskDays) {
        m_iTotalTaskDays += iTaskDays;
    }
}
