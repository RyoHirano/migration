import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

  static final int COMP_ANSWER = 2;
  static final int LESS_REPLACE_CNT = 2;
  static int m_iIpuntVal = 0;

  public static void main(final String[] args) {

    Scanner sc = new Scanner(System.in);
    int iInput = sc.nextInt();

    List<Integer> listSerchVal = new LinkedList<Integer>();

    for (int ii = 0; ii < iInput; ii++) {
      listSerchVal = CreateSerchNum(sc, listSerchVal);
    }
    Map<Integer, Integer> serachMap = serachDumpNum(listSerchVal);

    System.out.print(dumpNumCntUp(serachMap));

  }

  private static List<Integer> CreateSerchNum(final Scanner sc, final List<Integer> listSerchVal) {
    m_iIpuntVal = sc.nextInt();
    listSerchVal.add(m_iIpuntVal);

    return listSerchVal;
  }

  private static Map<Integer, Integer> serachDumpNum(final List<Integer> listSerchNum) {
    final Map<Integer, Integer> serachMap = new HashMap<Integer, Integer>();

    for (final int iSelectNum : listSerchNum) {
      final Integer i = serachMap.get(iSelectNum);
      serachMap.put(iSelectNum, i == null ? 1 : i + 1);
    }
    return serachMap;
  }

  private static int dumpNumCntUp(final Map<Integer, Integer> serachMap) {
    int iCnt = 0;
    int iMapSize = serachMap.size();

    if (COMP_ANSWER > iMapSize) {
      iCnt = serachMap.get(m_iIpuntVal) / 2;
    } else if (COMP_ANSWER < iMapSize) {
      iCnt = iMapSize - COMP_ANSWER;
    }
    return iCnt;
  }
}
