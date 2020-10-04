import java.util.Scanner;

public class App {

    private enum hon {
        HON_2(2),

        HON_4(4),

        HON_5(5),

        HON_7(7),

        HON_9(9);

        private int m_iHon;

        hon(int i) {
            m_iHon = i;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String sInput = sc.nextLine();
        String[] sInputArray = sInput.split("");
        String sCompVal = sInputArray[sInput.length() - 1];
        int iComp = Integer.parseInt(sCompVal);

        String sResult = "";
        for (hon h : hon.values()) {
            if (h.m_iHon == iComp) {
                sResult = "hon";
            }
        }

        if (!sResult.isEmpty()) {
            System.out.print(sResult);
            return;
        }

        if (3 == iComp) {
            sResult = "bon";
        } else {
            sResult = "pon";
        }

        System.out.print(sResult);

    }
}
