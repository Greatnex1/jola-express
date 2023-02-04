package jolaexpress.africa.data.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  PaymentType paymentType;
    private BigDecimal amount;
}
