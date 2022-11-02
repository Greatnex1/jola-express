package jolaexpress.africa.data.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CustomerRegistrationRequest {

   private String firstName;
   private String lastName;
  private  String email;
  private String phoneNumber;


}
