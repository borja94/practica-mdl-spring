package es.upm.miw.documents.core;

public enum RoomType {

    SINGLE, DOUBLE, TRIPLE,SUITE ;

    public String roleName() {
        return "ROLE_" + this.toString();
    }

}
