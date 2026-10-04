package org.example.ui;

import org.example.core.*;
import org.example.core.enums.Species;
import org.example.service.ShelterService;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleUI {
    private final ShelterService service;
    private final Scanner scanner = new Scanner(System.in);


    public ConsoleUI (ShelterService service){
        this.service = service;
    }

    public void run(){
        printHelp();
        while(true){
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split("\\s+");
            String cmd = p[0].toLowerCase();

            try{
                switch (cmd){
                    case "help" -> printHelp();
                    case "exit" -> {return;}
                    case "add" -> handleAdd(p);
                    case "list" -> handleList(p);
                    case "get" -> handleGet(p);
                    case "delete" -> handleDelete(p);
                    case "adopt" -> handleAdopt(p);
                    case "approve" -> handleApprove(p);
                    default -> System.out.println("Неизвестная команда. help");
                }

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

        }
    }


    private void printHelp(){
        System.out.println("""
            Доступные команды:
              help                                     - справка
              add animal <name> <species> <breed> <age> - добавить животное
              add adopter <ФИО> <телефон> <email>      - добавить усыновителя
              list animals                             - все животные
              list adopters                            - все усыновители
              list requests                            - все заявки
              get animal <id>                          - животное по id
              delete animal <id>                       - удалить животное
              adopt <animalId> <adopterId>             - создать заявку
              approve <requestId>                      - одобрить заявку
              exit                                     - выход
            """);
    }


    private void handleAdd(String[] p) {
        if (p.length < 2) {
            System.out.println("add animal|adopter ...");
            return;
        }

        if (p[1].equalsIgnoreCase("animal")) {
            if (p.length < 6) {
                System.out.println("add animal <name> <species> <breed> <age>");
                return;
            }

            Animal a = new Animal(p[2], Species.valueOf(p[3].toUpperCase()), p[4], Integer.parseInt(p[5]));
            service.addAnimal(a);
            System.out.println("Добавлено: " + a);

        } else if (p[1].equalsIgnoreCase("adopter")) {
            if (p.length < 5) {
                System.out.println("add adopter <ФИО> <телефон> <email>");
                return;
            }
            Adopter ad = new Adopter(p[2], p[3], p[4]);
            service.addAdopter(ad);
            System.out.println("Добавлено: " + ad);
        } else {
            System.out.println("Неизвестный тип: " + p[1]);
        }
    }

    private void handleList(String[] p){
        if (p.length < 2){
            System.out.println("list animals|adopters|requests");
            return; }

        switch (p[1].toLowerCase()){
            case "animals"  -> service.getAllAnimals().forEach(System.out::println);
            case "adopters" -> service.getAllAdopters().forEach(System.out::println);
            case "requests" -> service.getAllRequests().forEach(System.out::println);
            default -> System.out.println("Неизвестный список");
        }

    }

    private void handleGet(String[] p){
        if (p.length < 3){
            System.out.println("get animal <id>");
            return;
        }
        if (p[1].equalsIgnoreCase("animal")){
            System.out.println(service.getAnimal(Long.parseLong(p[2])));
        }

    }

    private void handleDelete(String[] p){
        if (p.length < 3){
            System.out.println("delete animal <id>");
            return;
        }
        if (p[1].equalsIgnoreCase("animal")){
            service.deleteAnimal(Long.parseLong(p[2]));
            System.out.println("Животное" + p[2] + "Удалено");
        }
    }


    private void handleAdopt(String[] p){
        if (p.length < 3) {
            System.out.println("adopt <animalId> <adopterId>");
            return;}
        AdoptionRequest req = service.createRequest(Long.parseLong(p[1]), Long.parseLong(p[2]));
        System.out.println("Создана заявка: " + req);

    }

    private void handleApprove(String[] p){
        if (p.length<2){
            System.out.println("approve <requestId>");
            return;}
        service.approveRequest(Long.parseLong(p[1]));
        System.out.println("Заявка одобрена");
    }


}
