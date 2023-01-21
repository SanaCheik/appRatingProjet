package bf.isge.gsn.rating.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Rating {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String denomination;

    private String description;

    @ManyToOne
    private User author;


    private LocalDate createdAt;

    @Column(columnDefinition = "boolean default false")
    private boolean archived;

    @PrePersist
    public void setup() {
        this.createdAt = LocalDate.now();
    }
}
