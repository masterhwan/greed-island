package card.game.book;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	private Book book;

	@Before
	public void setup() {
		book = new Book();
	}

	@Test
	public void add() throws Exception {
		assertEquals(100, book.getAppointCardsSize());
		assertEquals(45, book.freeCardsSize());
		assertEquals(145, book.bookSize());
	}

}
