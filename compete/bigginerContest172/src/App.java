import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Desk m_deskA;
    private static Desk m_deskB;

    public static void main(final String[] args) throws Exception {
        m_deskA = DeskA.getInstance();
        m_deskB = DeskB.getInstance();
        final Scanner sc = new Scanner(System.in);
        m_deskA.setBookNum(Integer.parseInt(sc.next()));
        m_deskB.setBookNum(Integer.parseInt(sc.next()));
        int iTotalReadTime = Integer.parseInt(sc.next());

        setTundoku(m_deskA, sc);
        setTundoku(m_deskB, sc);

        int iReadCnt = 0;
        while (true) {
            iTotalReadTime -= read().getReadTime();
            iReadCnt++;
            if (0 > iTotalReadTime) {
                break;
            }
        }

        System.out.print(iReadCnt);
    }

    private static void setTundoku(final Desk desk, final Scanner sc) {
        for (int i = 0; i < desk.getBookNum(); i++) {
            final int iReadTime = Integer.parseInt(sc.next());
            desk.addBook(new Book(iReadTime));
        }
    }

    private static Book read() {
        final List<Book> DeskABookList = m_deskA.getBookList();
        final List<Book> DeskBBookList = m_deskB.getBookList();
        Book readBook = null;

        final Book farstDeskABook = DeskABookList.get(0);
        final Book farstDeskBBook = DeskBBookList.get(0);
        if (isAllReadBook(DeskABookList)) {
            readBook = farstDeskBBook;
        } else if (isAllReadBook(DeskBBookList)) {
            readBook = farstDeskABook;
        }

        if (null == readBook) {
            readBook = isDeskBookRead(farstDeskABook, farstDeskBBook);
            if (farstDeskABook.getReadTime() < farstDeskBBook.getReadTime()) {
                readBook = farstDeskABook;
                m_deskA.getBookList().remove(0);
            } else {
                readBook = farstDeskBBook;
                m_deskB.getBookList().remove(0);
            }
        }
        return readBook;
    }

    private static boolean isAllReadBook(final List<Book> bookList) {
        if (bookList.isEmpty()) {
            return true;
        }
        return false;
    }

    private static Book isDeskBookRead(final Book DeskABook, final Book DeskBBook) {
        if (DeskABook.getReadTime() < DeskBBook.getReadTime()) {
            return DeskABook;
        } else {
            return DeskBBook;
        }

    }
}
