package dev.josephalvarez.proyectointegrador.model.constant;

public enum Purpose {

    SERVICIO("servicio"),
    PROGRAMA_EDIFICA("programa EDIFICA"),
    SHOWS_Y_CONFERENCIAS("shows y conferencias"),;

    private final String displayName;

    Purpose(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {return displayName;}
}
