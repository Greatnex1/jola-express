package jolaexpress.africa.data.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
