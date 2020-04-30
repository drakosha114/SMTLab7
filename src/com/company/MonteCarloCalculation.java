package com.company;

import java.util.concurrent.Callable;

public class MonteCarloCalculation implements Callable<CalculationResalt> {
    private int _numOfIterations;
    public MonteCarloCalculation(int numOfIterations) {
        this._numOfIterations = numOfIterations;
    }

    @Override
    public CalculationResalt call() {
        int p = this._calculatePi();
        System.out.println(p);
        return new CalculationResalt(this._numOfIterations, p);
    }

    private int _calculatePi() {
        double x,y;
        int k=0;
        for(int i = 1; i <= this._numOfIterations; i++){
            x = Math.random();
            y = Math.random();
            if(x*x+y*y<=1) {
                k++;
            }
        }
        return k;
    }

}
