import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class HeroTest {

	 @After
  public void tearDown() {
    Her.clear();
  }

	 @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero myHero = new Hero("Superman");
    assertEquals(true, mHero instanceof Hero);
  }

  @Test
  public void Hero_instantiatesWithDescription_String() {
    Hero myHero = new Hero("Superman");
    assertEquals("Superman", myHero.getDescription());
  }

  @Test
public void isCompleted_isFalseAfterInstantiation_false() {
  Hero myHero = new Hero("Superman");
  assertEquals(false, myHero.isCompleted());
}

@Test
public void getCreatedAt_instantiatesWithCurrentTime_today() {
  Hero myHero = new Hero("Superman");
  assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreatedAt().getDayOfWeek());
}

@Test
  public void all_returnsAllInstancesOfHero_true() {
    Hero firstHero = new Hero("Superman");
    Hero secondHero = new Hero("Batman");
    assertEquals(true, Hero.all().contains(firstHero));
    assertEquals(true, Hero.all().contains(secondHero));
  }

  @Test
public void clear_emptiesAllHeroesFromArrayList_0() {
  Hero myHero = new Hero("Superman");
  assertEquals(Hero.all().size(), 0);
}

@Test
public void getId_HeroesInstantiateWithAnID_1() {
    // Remember, the test will fail without this line! We need to empty leftover Heros from previous tests!
  Hero myHero = new Hero("Superman");
  assertEquals(1, myHero.getId());
}

@Test
public void find_returnsHeroWithSameId_secondHero() {
  Hero firstHero = new Hero("Superman");
  Hero secondHero = new Hero("Batman");
  assertEquals(Hero.find(secondHero.getId()), secondHero);
}

}