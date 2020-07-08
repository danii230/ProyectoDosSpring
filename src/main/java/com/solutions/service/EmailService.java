package com.solutions.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender sender;

    public void studentSendRequest(String to){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sistemaucr@ucr.com");
        message.setTo(to);
        message.setSubject("Se ha ingresado la solicitud");
        message.setText("Buen día. Por este medio le informamos que se ha procesado su solicitud. En los próximos días le informaremos la respuesta.");

        sender.send(message);
    }

    public void studentApprove(String to){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sistemaucr@ucr.com");
        message.setTo(to);
        message.setSubject("Se ha aceptado su solicitud");
        message.setText("Buen día. Por este medio le informamos que se ha aceptado su solicitud.");

        sender.send(message);
    }

    public void studentDenny(String to){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sistemaucr@ucr.com");
        message.setTo(to);
        message.setSubject("Se ha rechazado su solicitud");
        message.setText("Buen día. Por este medio le informamos que se ha rechazado su solicitud.");

        sender.send(message);
    }

    public void professorNewRequest(String to){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sistemaucr@ucr.com");
        message.setTo(to);
        message.setSubject("Se ha ingresado al sistema");
        message.setText("Buen día. Por este medio le informamos que nuestros administradores lo han registrado en la plataforma universitaria.");

        sender.send(message);
    }
}
