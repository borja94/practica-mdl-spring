package es.upm.miw.resources.exceptions;

public class CadenahoteleraNotExistException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = -7997837445112792727L;
    public static final String DESCRIPTION = "CadenaHotelera nombre not Exist";

    public CadenahoteleraNotExistException() {
        super(DESCRIPTION);
    }

    public CadenahoteleraNotExistException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
