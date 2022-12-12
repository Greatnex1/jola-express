package jolaexpress.africa.service.notification;

import jolaexpress.africa.data.dto.request.MailNotificationRequest;

public interface MailNotificationService {
    String sendEmail(MailNotificationRequest mailDetails);
}
