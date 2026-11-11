package edu.course.lab04;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
class BookTest {

    @Test
    void booksWithSameIsbnShouldBeEqual() {
        Book first = new Book("978-123", "Java Basics");
        Book second = new Book("978-123", "Advanced Java");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void booksWithDifferentIsbnShouldNotBeEqual() {
        Book first = new Book("978-123", "Java Basics");
        Book second = new Book("978-456", "Java Basics");

        assertNotEquals(first, second);
    }

    @Test
    void hashmapShouldFindBookByEqualKey() {
        Book first = new Book("978-123", "Java Basics");
        Book second = new Book("978-123", "Another title");

        Map<Book, String> books = new HashMap<>();
        books.put(first, "Found");

        assertEquals("Found", books.get(second));
    }
}
