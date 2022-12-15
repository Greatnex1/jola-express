package jolaexpress.africa.service.notification;

import jolaexpress.africa.data.dto.request.MailNotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
 class iMailNotificationServiceTest {
    @Autowired
    private MailNotificationService mailSender;

    @Test
    void sendEmail() {
        MailNotificationRequest mailDetails = new MailNotificationRequest();
        mailDetails.setUserEmail("noahgreatakoni@gmail.com");
        mailDetails.setMailContext("Hi, You are logged in to Jola Express");
        String response = mailSender.sendEmail(mailDetails);
        assertThat(response.contains("successful")).isTrue();
        log.info("successful");
    }
}