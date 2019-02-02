import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
	private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
   private static List<Hero> instances = new ArrayList<Hero>();
   private int mId;


   public Hero(String description) {
    mDescription = description;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
}
    public String getDescription() {
    return mDescription;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static List<Hero> all() {
    return instances;
  }

  public static void clear() {
  instances.clear();
}

 public int getId() {
    return mId;
  }

  public static Hero find(int id) {
  return instances.get(id - 1);
}

}