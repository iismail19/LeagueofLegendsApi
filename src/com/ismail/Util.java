package com.ismail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {

    public static void createQuickMapIdToNameForChampions(String fileName) throws IOException {
        // "D:\\Code\\LeagueofLegendsApi\\src\\com\\ismail\\keytoName.txt"
        File keytoName = new File(fileName);
        Scanner file = new Scanner(keytoName);
        BufferedWriter writer = new BufferedWriter(new FileWriter("KeyOutPutsToMap.txt"));
        while (file.hasNextLine()) {
            String curLine = file.nextLine();
            String fullS = "championIdtoName.put(" + curLine + ");\n";
            writer.write(fullS);
        }
        writer.close();
    }
}
