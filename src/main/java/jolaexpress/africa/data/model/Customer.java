package jolaexpress.africa.data.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer extends  JolaExpressUser{
    @Id
    @SequenceGenerator(name = "customer_id_sequence",
    sequenceName = "customer_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private  Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
