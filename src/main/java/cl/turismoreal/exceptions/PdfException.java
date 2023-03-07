package cl.turismoreal.exceptions;

public class PdfException extends RuntimeException {
	
	private static final String DESCRIPTION = "Pdf. File exception";

    public PdfException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
	
	private static final long serialVersionUID = 1L;
}
