package es.upm.miw.resources.exceptions;

public class CadenahoteleraAlreadyExistException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final String DESCRIPTION = "CadenaHotelera Field Already Exist";

    public CadenahoteleraAlreadyExistException() {
        super(DESCRIPTION);
    }

    public CadenahoteleraAlreadyExistException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}

