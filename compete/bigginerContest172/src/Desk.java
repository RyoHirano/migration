import java.util.List;

public abstract class Desk {

  private int m_iBookNum = 0;

  Desk() {
  }

  abstract protected int getBookNum();

  abstract protected void setBookNum(final int iBookNum);

  abstract protected List<Book> getBookList();

  abstract protected void addBook(final Book book);

}
