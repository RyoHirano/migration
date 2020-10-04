import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class App {

    private static Map<Integer, Integer> m_mapBossId = new LinkedHashMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        final int iEmployeeNum = Integer.parseInt(sc.next());
        initBossId(iEmployeeNum);

        // 社員番号1が固定でいるため。
        for (int i = 1; i <= iEmployeeNum - 1; i++) {
            final int iBossId = Integer.parseInt(sc.next());
            int iSub = m_mapBossId.get(iBossId);
            iSub++;
            m_mapBossId.put(iBossId, iSub);
        }
        output();
    }

    private static void initBossId(final int iEmploy) {
        for (int id = 1; id <= iEmploy; id++) {
            m_mapBossId.put(id, 0);
        }
    }

    private static void output() {
        for (Entry entry : m_mapBossId.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
