import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
	private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;


   public Task(String description) {
    mDescription = description;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
}


}