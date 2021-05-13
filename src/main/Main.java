package main;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


import static main.Euler.genGraphWithEuler;
import static main.WriteToTxt.writeToFile;

public class Main {
    public static void main(String[] args) {
        int vertex = 3;
        int measurement = 15;
        int jump = 1;
        int saturation;
        int saturation30 = 30;
        int saturation70 = 70;
        int saturation50 = 50;
        int[][] graph30;
        int[][] graph50;
        int[][] graph70;

        List<String[]> data = new ArrayList<>();


        int counter = 0;
        for (int i = vertex; i < vertex+(measurement*jump); i += jump) {
            //graph30 = genGraphWithEuler(i, saturation30);
            graph50 = genGraphWithEuler(i, saturation50);
            //graph70 = genGraphWithEuler(i, saturation70);

/*
            EulerCycle eulerCycle30 = new EulerCycle(i-1, graph30);

            System.out.println("E30 " + i);
            Instant startE30 = Instant.now();
            //TODO find cycle Eulera 30
            eulerCycle30.printEulerTour();
            Instant finishE30 = Instant.now();
            long timeE30 = Duration.between(startE30, finishE30).toMillis();
            data.add(new String[]{ "Euler", "30%", String.valueOf(i), String.valueOf(timeE30) });

            EulerCycle eulerCycle70 = new EulerCycle(i-1, graph70);

            System.out.println("E70 " + i);
            Instant startE70 = Instant.now();
            //TODO find cycle Eulera 70
            eulerCycle70.printEulerTour();
            Instant finishE70 = Instant.now();
            long timeE70 = Duration.between(startE70, finishE70).toMillis();
            data.add(new String[]{ "Euler", "70%", String.valueOf(i), String.valueOf(timeE70) });

            Hamilton hamilton = new Hamilton(i);
            //HamiltonianCycle hamilton = new HamiltonianCycle();

            System.out.println("H30 " + i);
            Instant startH30 = Instant.now();
            //TODO find cycle Hamiltona 30
            hamilton.findHamiltonianCycle(graph30);
            Instant finishH30 = Instant.now();
            long timeH30 = Duration.between(startH30, finishH30).toMillis();
            data.add(new String[]{ "Hamilton", "30%", String.valueOf(i), String.valueOf(timeH30) });

            System.out.println("H70 " + i);
            Instant startH70 = Instant.now();
            //TODO find cycle Hamiltona 70
            hamilton.findHamiltonianCycle(graph70);
            Instant finishH70 = Instant.now();
            long timeH70 = Duration.between(startH70, finishH70).toMillis();
            data.add(new String[]{ "Hamilton", "70%", String.valueOf(i), String.valueOf(timeH70) });
*/

            //graph50 = new int[][]{ { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 } };

            System.out.println("H50 " + i);
            Instant startH50 = Instant.now();
            //TODO find cycle Hamiltona 50
            HamiltonianCycle.findAllHamiltonianCycle(graph50);
            Instant finishH50 = Instant.now();
            long timeH50 = Duration.between(startH50, finishH50).toMillis();
            data.add(new String[]{ "Hamilton", "50%", String.valueOf(i), String.valueOf(timeH50) });

            counter++;
            int percent = (counter * 100 / measurement);
            System.out.println(percent + "% of work is done");
        }

        writeToFile(data, "results5_4.txt");

//        for (int i=0; i<vertex; i++){
//            System.out.println();
//            for (int j=0; j<vertex; j++) {
//                System.out.print(graph30[i][j] + " ");
//            }
//        }
//        System.out.println();
    }
}

