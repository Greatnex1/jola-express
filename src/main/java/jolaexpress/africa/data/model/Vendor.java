package jolaexpress.africa.data.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ToString
public class Vendor extends JolaExpressUser{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


}
