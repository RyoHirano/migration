/**
 * TabCrash
 */
public class TabCrash {

  private int m_iTabCrashCnt = 0;

  private int m_iDifCrashCnt = 0;

  private TakahashiTab m_taTakahashiTab = null;

  private TabCrash() {
  }

  public static TabCrash getInstance() {
    return TabCrashInstanceHolder.me;
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

  public static class TabCrashInstanceHolder {
    static TabCrash me = new TabCrash();
  }
}
