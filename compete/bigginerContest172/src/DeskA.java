import java.util.List;

public class DeskA extends Desk {

  private int m_iBookNum = 0;
  private static DeskA m_Me;
  private List<Book> m_listBook;

  public DeskA() {
  }

  public static DeskA getInstance() {
    return m_Me = new DeskA();
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
