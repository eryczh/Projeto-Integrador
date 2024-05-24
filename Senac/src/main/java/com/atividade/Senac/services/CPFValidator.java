package com.atividade.Senac.services;

public class CPFValidator {
 
    
    public static boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") ) {
            return false;
        }

        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        int[] cpfArray = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += cpfArray[i] * (10 - i);
        }

        int firstVerifier = 11 - (sum % 11);
        if (firstVerifier == 10 || firstVerifier == 11) {
            firstVerifier = 0;
        }

        if (firstVerifier != cpfArray[9]) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += cpfArray[i] * (11 - i);
        }

        int secondVerifier = 11 - (sum % 11);
        if (secondVerifier == 10 || secondVerifier == 11) {
            secondVerifier = 0;
        }

        return secondVerifier == cpfArray[10];
    }
}
