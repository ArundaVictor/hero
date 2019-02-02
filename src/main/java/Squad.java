import java.util.List;
import java.util.ArrayList;

public class Squad {
  private String mName;
  private static List<Squad> instances = new ArrayList<Squad>();
  private int mId;
  private List<Task> mTasks;

  public Squad(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mTasks = new ArrayList<Task>();
  }

  public String getName() {
    return mName;
  }

  public static List<Squad> all() {
    return instances;
  }

   public static void clear() {
    instances.clear();
  }

   public int getId() {
    return mId;
  }

   

   public List<Hero> getHeroes() {
    return mTasks;
  }

  public void addHero(Task hero) {
  mHeroes.add(heroes);
}

public static Squad find(int id) {
  try {
    return instances.get(id - 1);
  } catch (IndexOutOfBoundsException exception) {
    return null;
  }
}





}