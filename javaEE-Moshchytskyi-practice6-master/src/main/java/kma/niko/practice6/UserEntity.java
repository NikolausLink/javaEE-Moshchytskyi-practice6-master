package kma.niko.practice6;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(query = "SELECT u FROM UserEntity u WHERE u.lastName = :lastName", name = UserEntity.FIND_BY_LASTNAME)
})
public class UserEntity {

    public static final String FIND_BY_LASTNAME = "UserEntity.FIND_BY_LASTNAME";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

}

