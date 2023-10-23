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
@ToString
public class Reclamation implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    Long idReclamation ;
    @Column
    String object ;
    @Column
    String message ;
    @Column
    @Enumerated(EnumType.STRING)
    Status status;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime date;
}
