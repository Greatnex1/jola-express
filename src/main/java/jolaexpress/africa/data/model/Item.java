package jolaexpress.africa.data.model;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private int quantity;

    @OneToOne(fetch =FetchType.EAGER)
    private Product product;


}