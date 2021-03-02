package online.shop.onlineshop.service;

import online.shop.onlineshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Service
public class EmailService implements EmailServiceImpl{

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Async
    @Override
    public void sendHtmlEmil(String to, String subject, User user, String link, String templateName, Locale locale) throws MessagingException {
        final Context ctx = new Context(locale);
        ctx.setVariable("user", user);
        ctx.setVariable("url", link);
        
        final String htmlContent = this.templateEngine.process(templateName, ctx);

        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8"); // true = multipart
        message.setSubject(subject);
        message.setFrom("thymeleaf@example.com");
        message.setTo(to);

        message.setText(htmlContent, true); // true = isHtml

        // Send mail
        this.javaMailSender.send(mimeMessage);
    }
}
