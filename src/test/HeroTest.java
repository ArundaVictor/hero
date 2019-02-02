import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class HeroTest {

	 @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero myHero = new Hero("Superman");
    assertEquals(true, mHero instanceof Hero);
  }
}