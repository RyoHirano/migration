public class TakahashiTab {

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
