import java.util.Scanner;

public class submit {

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

  /**
   * TabCrash
   */
  static class TabCrash {

    private final static TabCrash m_Me = new TabCrash();
    private int m_iTabCrashCnt = 0;

    private int m_iDifCrashCnt = 0;

    private TakahashiTab m_taTakahashiTab = null;

    private TabCrash() {
    }

    public static TabCrash getInstance() {
      return m_Me;
    }

    public void setDifCrashCnt(final int iDifCrashCnt) {
      m_iDifCrashCnt = iDifCrashCnt;
    }

    public int getDifCrashCnt() {
      return m_iDifCrashCnt;
    }

    public int getCrashCnt() {
      return m_iTabCrashCnt;
    }

    public void isTabCrash() {
      m_taTakahashiTab = TakahashiTab.getInstance();
      if (m_iDifCrashCnt < m_taTakahashiTab.getDispTab()) {
        crash();
      }
    }

    private void crash() {
      initTab();
      m_iTabCrashCnt++;
    }

    private void initTab() {
      m_taTakahashiTab = TakahashiTab.getInstance();
      m_taTakahashiTab.initDispTab();
    }
  }

  static class TakahashiTab {
    private static final int INIT_VAL = 1;

    private int m_iDispTab = INIT_VAL;

    private TakahashiTab() {
    }

    public void initDispTab() {
      m_iDispTab = INIT_VAL;
    }

    public void CountUpDispTab() {
      m_iDispTab++;
    }

    public void CountDownDispTab() {
      m_iDispTab--;
    }

    public int getDispTab() {
      return m_iDispTab;
    }

    public static TakahashiTab getInstance() {
      return TabInstanceHolder.me;
    }

    public static class TabInstanceHolder {
      static TakahashiTab me = new TakahashiTab();
    }
  }

}
