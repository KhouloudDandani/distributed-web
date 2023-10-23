package tn.esprit.reclamation_ms.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Discussion")
@ToString
public class Discussion implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    Long idDisc ;
    @Column
    String msg ;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime date;
    @ManyToOne (cascade = CascadeType.ALL)
    Reclamation reclamation;

}
