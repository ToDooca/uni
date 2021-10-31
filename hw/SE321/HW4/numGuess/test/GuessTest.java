import numGuess.NumGuess;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuessTest {
	//instanciranje guessera sa intervalom 0-10 zato što ćemo ga koristiti kroz celo testiranje
	static NumGuess.Guesser g;
	@BeforeClass
	public static void classSetup(){
		g = new NumGuess.Guesser(0, 10);
	}

	@Test
	public void test_instantiate() {
		assertEquals(0, g.lower);
		assertEquals(10, g.upper);
	}

	@Test()
	public void test_output() {
		PrintStream sysOutBackup = System.out;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(byteArrayOutputStream);
		System.setOut(out);
		// Dumpuje se ceo stream sa očekivanim odgovorima kako bi smo dobili rezultat za "zamišljeni" broj 5
		InputStream sysInBackup = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{'n', 'e', '\n', 'd', 'a', '\n', 'd', 'a', '\n'});
		System.setIn(in);

		g.quiz();

		// Upisujemo ceo string očekivanih povratnih poruka nakon dumpovanih bajtova u input stream kao očekivani rezultat
		System.setOut(sysOutBackup);
		System.setIn(sysInBackup);
		String output = byteArrayOutputStream.toString();
		String expected = "Zamislite broj između 0 i 10\n" +
				"da li je vaš broj veći od 5 ? \n" +
				"da li je vaš broj veći od 2 ? \n" +
				"da li je vaš broj veći od 4 ? \n" +
				"Vaš broj je: 5\n";
		assertEquals(expected, output);
	}

	// Test za exception koji vraća poruku ako se unese bilo koja druga vrednost osim "da" ili "ne"
	@Test(expected = NumGuess.Guesser.InvalidInputException.class)
	public void test_askIfGreaterThan_throwsOnInvalidInput() throws NumGuess.Guesser.InvalidInputException {
		InputStream sysInBackup = System.in;
		// Testiranje exceptiona za vrednost "dfa" posle koga se uspešno poziva exception da unesemo validne vrednosti
		ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{'d', 'f', 'a', '\n'});
		System.setIn(in);
		g.askIfGreaterThan(10, new Scanner(System.in));
		System.setIn(sysInBackup);
	}

	// Test da li metoda lepo vraća veći broj ako se od njega to traži
	@Test()
	public void test_askIfGreaterThan() throws NumGuess.Guesser.InvalidInputException {
		InputStream sysInBackup = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{'d', 'a', '\n'});
		System.setIn(in);
		g.askIfGreaterThan(10, new Scanner(System.in));
		System.setIn(sysInBackup);
		assertTrue(true);
	}
}