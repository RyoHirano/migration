import java.util.LinkedList;

public class BookShelf implements Aggreate {
  private LinkedList<Book> m_Books;
  private int m_iLast = 0;

  public BookShelf() {
    m_Books = new LinkedList<Book>();
  }

  public Book getBookAt(int iIndex) {
    return m_Books.get(iIndex);
  }

  public void appendBook(Book book) {
    m_Books.add(book);
    m_iLast++;
  }

  public int getLength() {
    return m_iLast;
  }

  @Override
  public Iterator iterator() {

    return new BookShelfIterator(this);
  }

}
