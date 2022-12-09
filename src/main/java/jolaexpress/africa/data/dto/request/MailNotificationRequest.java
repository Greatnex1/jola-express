package jolaexpress.africa.data.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class MailNotificationRequest {
    private String userEmail;
    private String mailContext;
}
