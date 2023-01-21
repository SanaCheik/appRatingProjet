package bf.isge.gsn.rating.model;

import bf.isge.gsn.rating.dto.CreateRatingDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Rate {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private int note;
    private String comment;


    @ManyToOne
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rating critere;

    private LocalDate createdAt;

    @Column(columnDefinition = "boolean default false")
    private boolean archived;

    @PrePersist
    public void setup() {
        this.createdAt = LocalDate.now();
    }
}
