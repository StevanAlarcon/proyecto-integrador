package dev.josephalvarez.proyectointegrador.model.constant;

public enum NewsStatus {

    STATE_DRAFT("Borrador"),
    STATE_PUBLISHED("Publicado");

    private final String displayName;

    NewsStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {return displayName;}
}
