//package com.itau.banco.Status;
//
//public enum OrderStatus {
//    ATIVO(1),
//    DESATIVO(0);
//
//    private int status;
//
//    private OrderStatus(int status) {
//        this.status = status;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public static OrderStatus valueOf(int status) {
//        for(OrderStatus value : OrderStatus.values()) {
//            if(value.getStatus() == status) {
//                return value;
//            }
//        }
//        throw new IllegalArgumentException("Esse status é inválido");
//    }
//}
