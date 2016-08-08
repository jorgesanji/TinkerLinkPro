package com.cronosgroup.tinkerlink.enums;

/**
 * Created by jorgesanmartin on 8/8/16.
 */
public enum PostType {

    SUGGESTION(0, "sugerencia"),
    RECOMMENDATION(1, "recomendacion"),
    SHARE(2, "compartir"),
    SHAREPROFILE(3, "compartirPerfil"),
    ADDCONTACT(4, "anadirContacto"),
    UPDATEPROFILE(5, "updateProfile"),
    UPDATEPHOTO(6, "updateFoto"),
    TINKER(7, "tinker"),
    LINKER(8, "linker"),
    STATUS(9, "estado"),
    COMMENT(10, "comentario"),
    NONE(11, ""),
    SHARE_RECOMMENDATION(12, "compartir_recomendacion"),
    SHARE_UPDATEPROFILE(13, "compartir_updateProfile"),
    SHARE_UPDATEPHOTO(14, "compartir_updateFoto"),
    SHARE_TINKER(16, "compartir_tinker"),
    SHARE_LINKER(17, "compartir_linker"),
    SHARE_STATUS(18, "compartir_estado"),
    LOAD(19, "loader");

    private final int type;
    private final String typeString;

    PostType(int type, String typeString) {
        this.type = type;
        this.typeString = typeString;
    }

    public int getType() {
        return type;
    }

    public String getTypeString() {
        return typeString;
    }

    public static PostType typeFromString(String typeString) {
        if (typeString.equalsIgnoreCase(SUGGESTION.getTypeString())) {
            return SUGGESTION;
        } else if (typeString.equalsIgnoreCase(RECOMMENDATION.getTypeString())) {
            return RECOMMENDATION;
        } else if (typeString.equalsIgnoreCase(SHARE.getTypeString())) {
            return SHARE;
        } else if (typeString.equalsIgnoreCase(SHAREPROFILE.getTypeString())) {
            return SHAREPROFILE;
        } else if (typeString.equalsIgnoreCase(ADDCONTACT.getTypeString())) {
            return ADDCONTACT;
        } else if (typeString.equalsIgnoreCase(UPDATEPROFILE.getTypeString())) {
            return UPDATEPROFILE;
        } else if (typeString.equalsIgnoreCase(UPDATEPHOTO.getTypeString())) {
            return UPDATEPHOTO;
        } else if (typeString.equalsIgnoreCase(TINKER.getTypeString())) {
            return TINKER;
        } else if (typeString.equalsIgnoreCase(LINKER.getTypeString())) {
            return LINKER;
        } else if (typeString.equalsIgnoreCase(STATUS.getTypeString())) {
            return STATUS;
        } else if (typeString.equalsIgnoreCase(LOAD.getTypeString())) {
            return LOAD;
        } else if (typeString.equalsIgnoreCase(SHARE_RECOMMENDATION.getTypeString())) {
            return SHARE_RECOMMENDATION;
        } else if (typeString.equalsIgnoreCase(SHARE_UPDATEPHOTO.getTypeString())) {
            return SHARE_UPDATEPHOTO;
        } else if (typeString.equalsIgnoreCase(SHARE_UPDATEPROFILE.getTypeString())) {
            return SHARE_UPDATEPROFILE;
        } else if (typeString.equalsIgnoreCase(SHARE_LINKER.getTypeString())) {
            return SHARE_LINKER;
        } else if (typeString.equalsIgnoreCase(SHARE_TINKER.getTypeString())) {
            return SHARE_TINKER;
        } else if (typeString.equalsIgnoreCase(SHARE_STATUS.getTypeString())) {
            return SHARE_STATUS;
        }

        return NONE;
    }

    public static PostType typeFromInt(int type) {
        if (type == (SUGGESTION.getType())) {
            return SUGGESTION;
        } else if (type == RECOMMENDATION.getType()) {
            return RECOMMENDATION;
        } else if (type == SHARE.getType()) {
            return SHARE;
        } else if (type == SHAREPROFILE.getType()) {
            return SHAREPROFILE;
        } else if (type == ADDCONTACT.getType()) {
            return ADDCONTACT;
        } else if (type == UPDATEPROFILE.getType()) {
            return UPDATEPROFILE;
        } else if (type == UPDATEPHOTO.getType()) {
            return UPDATEPHOTO;
        } else if (type == TINKER.getType()) {
            return TINKER;
        } else if (type == LINKER.getType()) {
            return LINKER;
        } else if (type == STATUS.getType()) {
            return STATUS;
        } else if (type == LOAD.getType()) {
            return LOAD;
        } else if (type == SHARE_RECOMMENDATION.getType()) {
            return SHARE_RECOMMENDATION;
        } else if (type == SHARE_UPDATEPHOTO.getType()) {
            return SHARE_UPDATEPHOTO;
        } else if (type == SHARE_UPDATEPROFILE.getType()) {
            return SHARE_UPDATEPROFILE;
        } else if (type == SHARE_LINKER.getType()) {
            return SHARE_LINKER;
        } else if (type == SHARE_TINKER.getType()) {
            return SHARE_TINKER;
        } else if (type == SHARE_STATUS.getType()) {
            return SHARE_STATUS;
        }

        return NONE;
    }
}
