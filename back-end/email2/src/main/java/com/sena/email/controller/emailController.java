package com.sena.email.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@CrossOrigin
public class emailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@PostMapping("/Enviar")
	public String enviarCorreoRegistro(@RequestBody Map<String, String> datos) {
		try {
			String Destinatario=datos.get("destinatario");;
			String asunto=" SEREMOS GRANDE!";
			String cuerpo= datos.get("texto");

			var retorno=enviarCorreo(Destinatario,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}
			
		}catch (Exception e) {
			
			return "Erro al envíar "+e.getMessage();
		}
	}
	
	@GetMapping ("/NuevaClave")
	public String InicioDeSesion() {
		try {
			String Destinatario="grupo8699@gmail.com";
			String Asunto="SEREMOS GRANDE";
			String Cuerpo=""
					+ "\r\n"
					+ "<body style=\"font-family: 'Times New Roman', Times, serif;display: flex;justify-content: center;min-height: 100vh;background:blanchedalmond;background-size: cover; background-position: center;\">\r\n"
					+ "    <div  style=\"border-radius: 10px ;padding: 30px 40px;border: 2px solid black;backdrop-filter: blur(20px);margin-left: 150px;\">\r\n"
					+ "        <a href=\"#\">\r\n"
					+ "            <h1 style=\"text-align:center;color:black; text-decoration:none; margin-right: 60px;\">NARPY</h1>\r\n"
					+ "            <img src=\"https://i.postimg.cc/8CpDWSb6/Tri-Cir-Simbolo.png\" style=\"width: 20%; margin-left: 400px;\">\r\n"
					+ "        </a>\r\n"
					+ "        <div>\r\n"
					+ "            <h5>ASUNTO:CAMBIO DE CONTRASEÑA</h5>\r\n"
					+ "            <h5>Estimad@ USUARIO</h5>\r\n"
					+ "        </div>\r\n"
					+ "        <div>\r\n"
					+ "            <p>\r\n"
					+ "                Queremos informarte que la contraseña de tu cuenta <a href=\"\">NARPY</a> ha sido cambiada\r\n"
					+ "                exitosamente. Si tú realizaste este cambio, ignora este correo electrónico. <br>\r\n"
					+ "                <br>\r\n"
					+ "                Si no fuiste tú quien solicitó el cambio de contraseña, te recomendamos que te pongas en contacto con\r\n"
					+ "                nuestro equipo de soporte de inmediato <a href=\"\">NARPY@soporte.uni</a> tomaremos las medidas necesarias. <br>\r\n"
					+ "                <br>\r\n"
					+ "                Agradecemos tu atención y colaboración.\r\n"
					+ "                Atentamente! <br>\r\n"
					+ "                <a href=\"#\">NARPY/COMPANY</a>\r\n"
					+ "            </p>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "</body>\r\n"
					+ " ";
			var Retorno = enviarCorreo(Destinatario,Asunto,Cuerpo);
			if(Retorno) {
				return "ENVIO EXITOSO";
			}else {
				return "ENVIO FRACASADO";
			}
		}catch (Exception e) {
			// TODO:handle exception
			return "ERROR ENVIAR"+ e.getMessage();
		}
	}
	

	
	@GetMapping("/Recuperar-Contraseña")
	public String RecuperarContraseña() {
		try {
			String Destinatario="grupo8699@gmail.com";
			String Asunto="SEREMOS GRANDES";
			String Cuerpo=""
					+ "<body\r\n"
					+ "    style=\"font-family: 'Times New Roman', Times, serif;display: flex;justify-content: center;min-height: 100vh;background:blanchedalmond;background-size: cover; background-position: center;\">\r\n"
					+ "    <div\r\n"
					+ "        style=\"border-radius: 10px;padding: 30px 40px;border: 2px solid black;backdrop-filter: blur(20px);\">\r\n"
					+ "\r\n"
					+ "        <a href=\"#\">\r\n"
					+ "            <h1 style=\"text-align:center;color:black; text-decoration:none; margin-right: 60px;\">NARPY</h1>\r\n"
					+ "            <img src=\"https://i.postimg.cc/8CpDWSb6/Tri-Cir-Simbolo.png\" style=\"width: 20%; margin-left: 400px;\">\r\n"
					+ "        </a>\r\n"
					+ "        <div>\r\n"
					+ "            <h5>ASUNTO: Recuperación de Contraseña</h5>\r\n"
					+ "            <h5>Estimad@ USUARIO</h5>\r\n"
					+ "        </div>\r\n"
					+ "        <div>\r\n"
					+ "            <p>\r\n"
					+ "                Hemos recibido una solicitud para restablecer la contraseña de tu cuenta en [Nombre de la Plataforma].\r\n"
					+ "                Si no realizaste esta solicitud, puedes ignorar este correo electrónico. <br>\r\n"
					+ "<br>\r\n"
					+ "                Para restablecer tu contraseña, haz clic en el siguiente enlace: <a href=\"#\">www.NARPY/RestableceTuContraseña.com</a> <br>\r\n"
					+ "<br>\r\n"
					+ "                Si el enlace no funciona, cópialo y pégalo en la barra de direcciones de tu navegador. Una vez que hayas\r\n"
					+ "                completado este proceso, podrás acceder nuevamente a tu cuenta con la nueva contraseña. <br>\r\n"
					+ "<br>\r\n"
					+ "                Recuerda mantener tus credenciales de inicio de sesión de forma segura y no compartirlas con nadie. Si\r\n"
					+ "                necesitas ayuda adicional, no dudes en contactarnos a nuestro correo. <a href=\"\">NARPY@gmail.com</a> <br>\r\n"
					+ "<br>\r\n"
					+ "                Atentamente!<br> \r\n"
					+ "                <a href=\"#\">NARPY/COMPANY</a>\r\n"
					+ "            </p>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "</body>";
			var retorno=enviarCorreo(Destinatario,Asunto,Cuerpo);
			if(retorno) {
				return "ENVIO EXITOSO";
			}else {
				return "ENVIO FRACASADO";
			}
		}catch (Exception e) {
			//TODO: handle exception
			return "" + e.getMessage();
		}
	}
	
	
	@GetMapping("/Notificacion")
	public String NotificacionCorreo() {
		try {
			String Destinatario="grupo8699@gmail.com";
			String Asunto="SEREMOS GRANDE";
			String Cuerpo=" "
					+ "<body style=\"display: flex; justify-content:center; min-height: 100vh; background-color: blanchedalmond; background-size: cover; background-position: center;\">\r\n"
					+ "    <div style=\" background: transparent; border-radius: 10px; padding: 30px 40px; border: 2px solid black; backdrop-filter: blur(50px); margin-top: 120px;\">\r\n"
					+ "        <a href=\"#\">\r\n"
					+ "            <h1 style=\"text-align:center;color:black; text-decoration:none;\">NARPY</h1>\r\n"
					+ "            <img src=\"https://i.postimg.cc/8CpDWSb6/Tri-Cir-Simbolo.png\" style=\"width: 250px; margin-left: 100px;\">\r\n"
					+ "        </a>\r\n"
					+ "        <hr>\r\n"
					+ "        <h1 style=\"font-size:28px;text-align:center;color: black;\">NOTIFICACION DE COMPRA</h1>\r\n"
					+ "        <div style=\"text-align: center;\">\r\n"
					+ "            <h3>ESTADO DE COMPRA</h3>\r\n"
					+ "            <p>EXITOSA</p>\r\n"
					+ "        </div>\r\n"
					+ "        <div >\r\n"
					+ "            <h4 style=\"text-align: center;\">DATOS PERSONALES</h4>\r\n"
					+ "            <div>\r\n"
					+ "                <h5>NOMBRE COMPLETO</h5>\r\n"
					+ "                <p id=\"\">PEDRO PABLO LEON JARAMILLO </p>\r\n"
					+ "                <h5>TELEFONO</h5>\r\n"
					+ "                <p id=\"\">123456</p>\r\n"
					+ "                <h5>CORREO ELECTRONICO</h5>\r\n"
					+ "                <p id=\"\">pedro@gmail.com</p>\r\n"
					+ "                <h5>DIRECCION</h5>\r\n"
					+ "                <p>CALLE 49 # debajo del puente</p>\r\n"
					+ "            </div>\r\n"
					+ "            <div style=\"display: flex;\">\r\n"
					+ "                <div style=\"width: 50%; text-align: center;\">\r\n"
					+ "                    <h4>PRODUCTO</h4>\r\n"
					+ "                    <p id=\"\">POLLO</p>\r\n"
					+ "                </div>\r\n"
					+ "                <div style=\"width: 50%; text-align: center; \">\r\n"
					+ "                    <h4>CANTIDAD</h4>\r\n"
					+ "                    <p>1L</p>\r\n"
					+ "                </div>\r\n"
					+ "            </div>\r\n"
					+ "            <h4 style=\"text-align: center;\">DINERO</h4>\r\n"
					+ "            <div style=\"display: flex;\">\r\n"
					+ "                <div style=\"width: 50%; text-align: center;\">\r\n"
					+ "                    <h4>APAGAR</h4>\r\n"
					+ "                    <p id=\"\">$1000</p>\r\n"
					+ "                </div>\r\n"
					+ "                <div style=\"width: 50%; text-align: center;\">\r\n"
					+ "                    <h4>ADEVOLVER</h4>\r\n"
					+ "                    <p id=\"\">$500</p>\r\n"
					+ "                </div>\r\n"
					+ "            </div>\r\n"
					+ "            <hr>\r\n"
					+ "            <div>\r\n"
					+ "                <p>SI TIENES ALGUN PROBLEMA O DUDA, CONTACTANOS A NUESTRO CORREO</p>\r\n"
					+ "                <a href=\"#\" style=\"text-decoration: none; padding-left: 130px;\">NARPY@gmail.com</a>\r\n"
					+ "            </div>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "</body> ";
			var retorno=enviarCorreo(Destinatario,Asunto,Cuerpo);
			if(retorno) {
				return "ENVIO EXITOSO";
			}else {
				return "ENVIO FRACASADO";
			}
		}catch (Exception e) {
			// TODO:handle exception
			return "ERROR ENVIAR"+ e.getMessage();
		}
	}
	
	
	public boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);
			
			javaMailSender.send(message);
			return true;
		}catch (Exception e) {

			return false;
		}
		
	}

}
