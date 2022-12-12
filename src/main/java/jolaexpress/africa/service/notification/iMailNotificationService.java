package jolaexpress.africa.service.notification;

import jolaexpress.africa.data.dto.request.MailNotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@Slf4j
public class iMailNotificationService implements MailNotificationService{
    private  final JavaMailSender javaMailSender;
    @Override
    public String sendEmail(MailNotificationRequest mailDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try{
            mimeMessageHelper.setFrom("noreply@gmail.jola");
            mimeMessageHelper.setTo(mailDetails.getUserEmail());
            mimeMessageHelper.setText(mailDetails.getMailContext(),true);
            javaMailSender.send(mimeMessage);
            return String.format("email sent successfully  to  %s", mailDetails.getUserEmail());

        }
        catch(MessagingException e){
            e.printStackTrace();
        }
        return String.format("email not sent to %s ",mailDetails.getUserEmail());
    }
}
