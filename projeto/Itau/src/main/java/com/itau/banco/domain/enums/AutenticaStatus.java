package com.itau.banco.domain.enums;

public enum AutenticaStatus {
    AUTENTICADO(1),
    NAO_AUTENTICADO(0);

    private int status;

    private AutenticaStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static AutenticaStatus valueOf(int status, String name) {
        for (AutenticaStatus value : AutenticaStatus.values()) {
            if(value.getStatus() == status) {
                return value;
            }
        }
        throw new IllegalArgumentException("Status inválido!");

    }

}
