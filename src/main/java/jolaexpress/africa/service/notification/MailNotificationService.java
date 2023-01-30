package jolaexpress.africa.service.notification;

import jolaexpress.africa.data.dto.request.MailNotificationRequest;
import org.springframework.mail.SimpleMailMessage;

public interface MailNotificationService {
    String sendEmail(MailNotificationRequest mailDetails);

//    void sendMail(SimpleMailMessage email);
}
