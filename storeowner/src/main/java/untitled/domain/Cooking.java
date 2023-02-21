package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.StoreownerApplication;
import untitled.domain.Rejected;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreownerApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void acceptOrReject() {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public void strat() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    public void finish() {
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }
}
