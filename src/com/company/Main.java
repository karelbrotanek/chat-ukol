package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej jméno:");
        String jmeno = sc.nextLine();
        int pocetzprav = 0;
        String file = "zpravy.txt";
        ArrayList<String> zpravy = new ArrayList<String>();
        File f = new File(file);
        if (!f.exists()) {
            f.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String zprava;
        while ((zprava = br.readLine()) != null) {
            zpravy.add(zprava);
        }
        br.close();
        int pocetstarychzprav = zpravy.size();
        boolean pokracovat = true;
        System.out.println("V databázi máš " + zpravy.size() + " zprávy:");
        System.out.println("------------------------");
        if (zpravy.size() == 0) {
            System.out.println("-- Žádné předchozí zprávy --");
        }
        for (int i = 0; i < zpravy.size(); i++) {
            System.out.println(zpravy.get(i));
        }
        System.out.println("------------------------");
        System.out.println("Pro ukončení zápisu zpráv zadej `!konec`");
        while (pokracovat) {
            System.out.print("> ");
            zprava = sc.nextLine();
            if (zprava.equals("!konec")) {
                pokracovat = false;
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (int i = 0; i < pocetstarychzprav; i++) {
                    bw.write(zpravy.get(i));
                    bw.newLine();
                }
                for (int i = pocetstarychzprav; i < zpravy.size(); i++) {
                    bw.write(jmeno + ": " + zpravy.get(i));
                    bw.newLine();
                }
                bw.close();
            } else {
                zpravy.add(zprava);
            }
        }
    }
}
