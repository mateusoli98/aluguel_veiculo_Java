package model;

import java.util.Properties;
import javax.mail.Address;

import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    public static void enviar() {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("admloccontato@gmail.com", "*adm1234");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("admloccontato@gmail.com")); //Remetente
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("amauri2015gg@gmail.com")); //Destinatário(s)
            message.setSubject("Enviando email com JavaMail");//Assunto
            message.setText("Enviei este email utilizando JavaMail com minha conta Hotmail!");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            System.out.println("Feito!!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static void enviarHotmail() {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Hotmail
         */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("admloccontato@outlook.com", "*adm1234");
            }
        });
        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("admloccontato@outlook.com")); //Remetente
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("amauri.souza2014@outlook.com")); //Destinatário(s)
            message.setSubject("Enviando email com JavaMail");//Assunto
            message.setText("Enviei este email utilizando JavaMail com minha conta Hotmail!");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            System.out.println("Feito!!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
