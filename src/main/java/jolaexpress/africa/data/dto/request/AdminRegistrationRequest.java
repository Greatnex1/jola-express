package jolaexpress.africa.data.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class AdminRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
