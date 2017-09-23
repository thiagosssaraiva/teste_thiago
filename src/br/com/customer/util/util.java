/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.customer.util;

/**
 *
 * @author Thiago
 */
import java.text.DecimalFormat;
import java.util.Random;

public class util {

    private static Random rand = new Random();

    public static String generateName() {
        String[] names = {"Thiago", "Matheus", "Luis", "Marcello", "Felipe", "David", "Rodrigo", "Henry", "Pilar",
            "Andre", "Paulo", "Fernand", "Marco", "Michael", "Emanuel", "Pietro", "Igor", "Samuel", "Diego", "Lima",
            "Filipe", "Nathan", "Filipe", "Nathan", "Cauã", "Marcelo"};

        String[] last_names = {"Barbosa", "Carvalho", "Alves", "César", "Thales", "Carvalho", "Francisco", "Lucca",
            "Gomes", "Julio", "Caio", " Samuel", "Alves", "Ian", "Antonio", "Gomes", "Bruno", "Santos", "Bernardo", "Fernandes",
            "Caio", "Martins", "Anthony", "Carvalho"};

        Random ran = new Random();
        String gen = names[ran.nextInt(names.length)] + " " + last_names[ran.nextInt(last_names.length)];

        return gen;
    }

    public static String generateCPF() {
        int digito1 = 0, digito2 = 0, resto = 0;
        String nDigResult;
        String numerosContatenados;
        String numeroGerado;
        Random numeroAleatorio = new Random();

        int n1 = numeroAleatorio.nextInt(10);
        int n2 = numeroAleatorio.nextInt(10);
        int n3 = numeroAleatorio.nextInt(10);
        int n4 = numeroAleatorio.nextInt(10);
        int n5 = numeroAleatorio.nextInt(10);
        int n6 = numeroAleatorio.nextInt(10);
        int n7 = numeroAleatorio.nextInt(10);
        int n8 = numeroAleatorio.nextInt(10);
        int n9 = numeroAleatorio.nextInt(10);
        int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;
        int valor = (soma / 11) * 11;
        digito1 = soma - valor;

        resto = (digito1 % 11);
        if (digito1 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;
        int valor2 = (soma2 / 11) * 11;
        digito2 = soma2 - valor2;

        resto = (digito2 % 11);
        if (digito2 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + "." + String.valueOf(n4)
                + String.valueOf(n5) + String.valueOf(n6) + "." + String.valueOf(n7) + String.valueOf(n8)
                + String.valueOf(n9) + "-";
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        numeroGerado = numerosContatenados + nDigResult;

        return numeroGerado;
    }

    public static String generateCNPJ() {
        int digito1 = 0, digito2 = 0, resto = 0;
        String nDigResult;
        String numerosContatenados;
        String numeroGerado;
        Random numeroAleatorio = new Random();

        int n1 = numeroAleatorio.nextInt(10);
        int n2 = numeroAleatorio.nextInt(10);
        int n3 = numeroAleatorio.nextInt(10);
        int n4 = numeroAleatorio.nextInt(10);
        int n5 = numeroAleatorio.nextInt(10);
        int n6 = numeroAleatorio.nextInt(10);
        int n7 = numeroAleatorio.nextInt(10);
        int n8 = numeroAleatorio.nextInt(10);
        int n9 = numeroAleatorio.nextInt(10);
        int n10 = numeroAleatorio.nextInt(10);
        int n11 = numeroAleatorio.nextInt(10);
        int n12 = numeroAleatorio.nextInt(10);
        int soma = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;
        int valor = (soma / 11) * 11;
        digito1 = soma - valor;

        resto = (digito1 % 11);
        if (digito1 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        int soma2 = digito1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;
        int valor2 = (soma2 / 11) * 11;
        digito2 = soma2 - valor2;

        resto = (digito2 % 11);
        if (digito2 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
        numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + "." + String.valueOf(n3) + String.valueOf(n4)
                + String.valueOf(n5) + "." + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8) + "/"
                + String.valueOf(n9) + String.valueOf(n10) + String.valueOf(n11)
                + String.valueOf(n12) + "-";

        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        numeroGerado = numerosContatenados + nDigResult;
        return numeroGerado;
    }

    public static float generateValue() {
        float value = (1 + (float) (Math.random() * 1000));

        return value;
    }

    public static boolean generateBoolean() {
        Random random = new Random();

        return random.nextBoolean();
    }
}
