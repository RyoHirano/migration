import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int iAbsoluteVal = Integer.parseInt(sc.next(sc.next()));
        int iLength = Integer.parseInt(sc.next(sc.next()));
        LinkedList<Integer> valList = new LinkedList<Integer>();
        for (int i = 0; i < iLength; i++) {
            valList.add(Integer.parseInt(sc.next()));
        }

        while (true) {
            int iRoopCnt = 0;
            int iSerachVal = iAbsoluteVal - 1;
            if  (iSerachVal == valList.get(iRoopCnt)) {
                continue;
            }
            

            iAbsoluteVal = iSerachVal;
        }
}
