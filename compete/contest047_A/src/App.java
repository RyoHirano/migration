import java.util.Scanner;

public class App {

    private static final String CNT_UP_VAL = "+";

    private static final String CNT_DOWN_VAL = "-";

    public static void main(String[] args) throws Exception {

        crachCount();
    }

    private static void crachCount() {

        Scanner sc = new Scanner(System.in);
        TakahashiTab tab = TakahashiTab.getInstance();
        TabCrash crash = TabCrash.getInstance();

        int iMoveCnt = sc.nextInt();
        crash.setDifCrashCnt(sc.nextInt());
        sc.nextLine();
        String sMoveDetail = sc.next();
        String[] sMoveDetailArry = sMoveDetail.split("");
        for (int iDetailNum = 0; iDetailNum < sMoveDetailArry.length; iDetailNum++) {
            final String sDetail = sMoveDetailArry[iDetailNum];
            if (CNT_UP_VAL.equals(sDetail)) {
                tab.CountUpDispTab();
                crash.isTabCrash();
            } else if (CNT_DOWN_VAL.equals(sDetail)) {
                tab.CountDownDispTab();
            }
        }
        System.out.print(crash.getCrashCnt());
    }
}
