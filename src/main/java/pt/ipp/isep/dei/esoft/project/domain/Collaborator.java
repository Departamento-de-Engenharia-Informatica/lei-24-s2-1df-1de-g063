package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Scanner;

public class Collaborator {
    private String name;
    private int age;
    private String jobTitle;
    private String address;
    private int cell_number;
    private int id_number;
    private String id_doc_type;
    private int ano;
    private int mes;
    private int dia;
    private String email;
    public Collaborator(String name,int ano, int mes, int dia, String jobTitle, String address, int cell_number, int id_number, String id_doc_type) {
        this.name = name;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.email = email;
        this.jobTitle = jobTitle;
        this.address = address;
        this.cell_number = cell_number;
        this.id_number = id_number;
        this.id_doc_type = id_doc_type;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println(ano + "/" + mes + "/" + dia);
        System.out.println("Email: " + email);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Address: " + address);
        System.out.println("Cellphone number: " + cell_number);
        System.out.println("ID number: " + id_number);
        System.out.println("ID document type: " + id_doc_type);
    }
}
