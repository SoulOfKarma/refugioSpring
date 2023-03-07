package cl.turismoreal.models.services;

import org.springframework.stereotype.Service;

import cl.turismoreal.exceptions.PdfException;

@Service
public class PdfResource {
	
	String url = "http://192.168.43.176:8080/api/v1/reservas/activar/";
	//String url = "http://localhost:8080/api/v1/reservas/activar/";
	//String url = "http://li2100-58.members.linode.com:8080/refugio/api/v1/reservas/activar/";

	public byte[] pdf(String codigo) throws PdfException {
        return new PdfBuilder()
        		.image("logo.png")
                .paragraphEmphasized("Equipo Refugio").line()
                .paragraph("Código QR de activación para tu reserva")
                .qrCode(url + codigo).line()
                .build();
    }
}
