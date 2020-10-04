import java.util.List;

public class DeskB extends Desk {

  private int m_iBookNum = 0;
  private static DeskB m_Me;
  private List<Book> m_listBook;

  private DeskB() {
  }

  public static DeskB getInstance() {
    return m_Me = new DeskB();
  }

  public void setBookNum(final int iBookNum) {
    m_iBookNum = iBookNum;
  }

  public int getBookNum() {
    return m_iBookNum;
  }

  public void addBook(final Book book) {
    m_listBook.add(book);
  }

  public List<Book> getBookList() {
    return m_listBook;
  }
}
