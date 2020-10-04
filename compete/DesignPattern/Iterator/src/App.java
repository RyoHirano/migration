import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BookShelf bookShelf = new BookShelf();

        while (true) {
            final String sName = sc.next();
            if ("End".equals(sName)) {
                break;
            }
            bookShelf.appendBook(new Book(sName));
        }

        Iterator it = bookShelf.iterator();

        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
