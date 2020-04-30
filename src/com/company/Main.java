package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число потоков");
        int numOfThreads = in.nextInt();
        System.out.println("Введите число итераций");
        int numOfIterations = in.nextInt();

        List<Future<CalculationResalt>> threadsList = new ArrayList<Future<CalculationResalt>>();
        List<CalculationResalt> resultsList = new ArrayList<CalculationResalt>();

        ExecutorService calculations = Executors.newFixedThreadPool(numOfThreads);
        Callable calc = new MonteCarloCalculation(numOfIterations);
        for(int i = 0; i < numOfThreads; i += 1) {

            Future<CalculationResalt> futureCalc = calculations.submit(calc);
            threadsList.add(futureCalc);

        }


        for(Future<CalculationResalt> fut : threadsList){
            try {
                resultsList.add(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        calculations.shutdown();

        int submited = 0;
        int total = 0;

        for(CalculationResalt calcul: resultsList) {
            submited += calcul.getSuccesed();
            total += calcul.getTotal();
        }

        double p = 4. * submited / total;
        System.out.println("Threads was stoped. Resalt is " + p);
    }
}
