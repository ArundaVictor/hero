import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
	private String mDescription;
  private String mAge;
  private String mPower;
  private String mWeakness;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
   private static List<Hero> instances = new ArrayList<Hero>();
   private int mId;


   public Hero(String description, String age, String power, String weakness) {
    mDescription = description;
    mAge = age;
    mPower = power;
    mWeakness = weakness;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
}

   
    public String getDescription() {
    return mDescription;
  }
      
     public String getAge(){
      return mAge;
   }

   public String getPower(){
      return mPower;
   }

   public String getWeakness(){
      return mWeakness;
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