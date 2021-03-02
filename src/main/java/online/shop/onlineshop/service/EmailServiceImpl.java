package online.shop.onlineshop.service;

import online.shop.onlineshop.model.User;

import javax.mail.MessagingException;
import java.util.Locale;

public interface EmailServiceImpl {

    public void sendHtmlEmil(String to, String subject, User user, String link, String templateName, Locale locale) throws MessagingException;

}
