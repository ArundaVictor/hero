import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

  @Test
  public void squad_instantiatesCorrectly_true() {
    Squad testSquad = new Squad("Super");
    assertEquals(true, testSquad instanceof Squad);
  }

  @Test
  public void getName_squadInstantiatesWithName_Super() {
    Squad testSquad = new Squad("Super");
    assertEquals("Super", testSquad.getName());
  }

  @Test
  public void all_returnsAllInstancesOfSquad_true() {
    Squad firstSquad = new Squad("Super");
    Squad secondSquad = new Squad("Villain");
    assertEquals(true, Squad.all().contains(firstSquad));
    assertEquals(true, Squad.all().contains(secondSquad));
  }

   @Test
  public void clear_emptiesAllSquadsFromList_0() {
    Squad testSquad = new Squad("Super");
    Squad.clear();
    assertEquals(Squad.all().size(), 0);
  }

   @Test
  public void getId_squadInstantiateWithAnId_1() {
    Squad testSquad = new Squad("Super");
    assertEquals(1, testSquad.getId());
  }

  @Test
  public void find_returnsSquadWithSameId_secondSquad() {
    Squad.clear();
    Squad firstSquad = new Squad("Super");
    Squad secondSquad = new Squad("Villain");
    assertEquals(Squad.find(secondSquad.getId()), secondSquad);
  }

  @Test
public void getHeroes_initiallyReturnsEmptyList_ArrayList() {
  Squad.clear();
  Squad testSquad = new Squad("Home");
  assertEquals(0, testSquad.getHeroes().size());
}

@Test
public void addTask_addsTaskToList_true() {
  Squad testSquad = new Squad("Super");
  Hero testHero = new Hero("Superman");
  testSquad.addHero(testHero);
  assertTrue(testSquad.getHeroes().contains(testHero));
}

 @Test
  public void find_returnsNullWhenNoHeroFound_null() {
    assertTrue(Squad.find(999) == null);
  }








}