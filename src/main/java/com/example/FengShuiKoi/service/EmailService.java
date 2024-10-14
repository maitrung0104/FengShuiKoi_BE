package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.model.EmailDetail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
    @Autowired
    TemplateEngine templateEngine;      //convert giao diện

    @Autowired
    JavaMailSender javaMailSender;      //dùng để đẩy mail

    public void sendEmail(EmailDetail emailDetail){

        try{
            Context context= new Context();
            context.setVariable("name",emailDetail.getReceiver().getEmail());
            context.setVariable("button","go to homepage");
            context.setVariable("link",emailDetail.getLink());

            String template= templateEngine.process("welcome-template",context);
            //Creating a simple mail mes
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage);

            //Setting up necessary details
            mimeMessageHelper.setFrom("maitrung0104@gmail.com");
            mimeMessageHelper.setTo(emailDetail.getReceiver().getEmail());
            mimeMessageHelper.setText(template,true);
            mimeMessageHelper.setSubject(emailDetail.getSubject());
            //Send mail
            javaMailSender.send(mimeMessage);
        }catch (MessagingException e){
            System.out.println("ERROR SENT MAIL!!!");
        }

    }
}
