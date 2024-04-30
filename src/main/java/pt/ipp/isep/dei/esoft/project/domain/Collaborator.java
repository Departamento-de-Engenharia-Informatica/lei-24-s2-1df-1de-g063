package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Scanner;

public class Collaborator {
    private String name;
    private int age;
    private String jobTitle;
    private String address;
    private int cell_number;
    private int id_number;
    private int ano;
    private int mes;
    private int dia;
    private static final int ANO_POR_OMISSAO = 1;
    private static final int MES_POR_OMISSAO = 1;
    private static final int DIA_POR_OMISSAO = 1;
    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira",
            "Terça-feira", "Quarta-feira",
            "Quinta-feira", "Sexta-feira",
            "Sábado"};
    private static int[] diasPorMes = {  0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
            31, 30, 31};
    private static String[] nomeMes = {"Inválido", "Janeiro", "Fevereiro",
            "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro",
            "Outubro", "Novembro", "Dezembro"};
    public Collaborator(String name, int age, String jobTitle) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Job Title: " + jobTitle);
    }
}

class HRMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the HRM System");
        System.out.println("Please enter collaborator details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Job Title: ");
        String jobTitle = scanner.nextLine();

        Collaborator collaborator = new Collaborator(name, age, jobTitle);

        System.out.println("\nCollaborator registered successfully.");
        collaborator.displayInfo();

        scanner.close();
    }
}
