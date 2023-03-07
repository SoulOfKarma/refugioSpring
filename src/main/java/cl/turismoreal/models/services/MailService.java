package cl.turismoreal.models.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.itextpdf.io.IOException;

import cl.turismoreal.models.entity.Cliente;

@Service
public class MailService {

	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Autowired
	private PdfResource pdfResource;

	/**
	 * This function is used to send mail without attachment.
	 * @param user
	 * @throws MailException
	 */
	
	public void sendEmail(Cliente cliente) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(cliente.getUsername());
		mail.setSubject("Prueba desde API RestFul Refugio");
		mail.setText("Este email esta siendo enviado automaticamente como prueba desde la aplicacion BackEnd de Refugio");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}

	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param user
	 * @throws MailException
	 * @throws MessagingException
	 * @throws javax.mail.MessagingException 
	 */
	public void sendEmailWithAttachment(Cliente cliente, String codigoRes) throws MailException, MessagingException, javax.mail.MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(cliente.getUsername());
		helper.setSubject("Prueba desde API RestFul Refugio");
		helper.setText("Este email está siendo enviado automáticamente como prueba desde la aplicación BackEnd de Refugio");
		
		FileSystemResource fileSystemResource = null;
		
		this.pdfResource.pdf(codigoRes);
		
		try {
			fileSystemResource = new FileSystemResource("/Users/gonan/pdf/Documento-Activación.pdf");
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

		helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

		javaMailSender.send(mimeMessage);
	}
}
