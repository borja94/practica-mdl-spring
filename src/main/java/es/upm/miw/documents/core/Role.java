package es.upm.miw.documents.core;

public enum Role {

    CLIENT, HOTEL_RESP;

    public String roleName() {
        return "ROLE_" + this.toString();
    }

}
