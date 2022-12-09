package jolaexpress.africa.data.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@Table
@ToString
@NoArgsConstructor
public class Admin extends JolaExpressUser{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


}
