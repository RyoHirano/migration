public class BookShelfIterator implements Iterator {
  private BookShelf m_BookShelf;
  private int m_iIndex;

  public BookShelfIterator(BookShelf bookShelf) {
    m_BookShelf = bookShelf;
    m_iIndex = 0;
  }

  @Override
  public boolean hasNext() {
    if (m_iIndex < m_BookShelf.getLength()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Object next() {
    Book book = m_BookShelf.getBookAt(m_iIndex);
    m_iIndex++;
    return book;
  }
}
