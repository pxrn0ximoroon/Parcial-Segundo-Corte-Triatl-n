package com.triathlon.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoRegistro(String destinatario, String nombre) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject("Bienvenido al Triatlón");
        mensaje.setText("Hola " + nombre + ", tu registro en la competencia de Triatlón fue exitoso.");
        mailSender.send(mensaje);
    }
}