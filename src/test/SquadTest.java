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
    Squad testCategory = new Squad("Super");
    assertEquals("Super", testSquad.getName());
  }

  @Test
  public void all_returnsAllInstancesOfSquad_true() {
    Squad firstSquad = new Squad("Super");
    Squad secondSquad = new Category("Villain");
    assertEquals(true, Squad.all().contains(firstSquad));
    assertEquals(true, Squad.all().contains(secondSquad));
  }

   @Test
  public void clear_emptiesAllSquadsFromList_0() {
    Squad testSquad = new Category("Home");
    Category.clear();
    assertEquals(Category.all().size(), 0);
  }

   @Test
  public void getId_categoriesInstantiateWithAnId_1() {
    Category testCategory = new Category("Home");
    assertEquals(1, testCategory.getId());
  }

  @Test
  public void find_returnsCategoryWithSameId_secondCategory() {
    Category.clear();
    Category firstCategory = new Category("Home");
    Category secondCategory = new Category("Work");
    assertEquals(Category.find(secondCategory.getId()), secondCategory);
  }

  @Test
public void getTasks_initiallyReturnsEmptyList_ArrayList() {
  Category.clear();
  Category testCategory = new Category("Home");
  assertEquals(0, testCategory.getTasks().size());
}

@Test
public void addTask_addsTaskToList_true() {
  Category testCategory = new Category("Home");
  Task testTask = new Task("Mow the lawn");
  testCategory.addTask(testTask);
  assertTrue(testCategory.getTasks().contains(testTask));
}

 @Test
  public void find_returnsNullWhenNoTaskFound_null() {
    assertTrue(Category.find(999) == null);
  }








}