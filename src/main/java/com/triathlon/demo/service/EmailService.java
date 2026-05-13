package com.triathlon.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
/**
 * Esta clase se encarga de todo lo que tiene que ver con mandar correos.
 * se usa para avisar a la gente cuando se registra o cuando pasa algo importante.
 */
@Service
public class EmailService {
    /**
     * Esta es la herramienta de Spring que realmente manda el email.
     * Se conecta con el servidor de correo que configurado en las propiedades.
     */
    @Autowired
    private JavaMailSender mailSender;
    /**
     * Este método arma un correo de bienvenida muy sencillo.
     */
    public void enviarCorreoRegistro(String destinatario, String nombre) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject("Bienvenido al Triatlón");
        mensaje.setText("Hola " + nombre + ", tu registro en la competencia de Triatlón fue exitoso.");
        mailSender.send(mensaje);//manda el mensaje
    }
}