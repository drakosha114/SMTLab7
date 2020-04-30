package com.company;

public class CalculationResalt {

     private int _total;
     private int _succesed;

     public int getTotal() {
         return this._total;
     }

     public int getSuccesed() {
         return this._succesed;
     }

     CalculationResalt(int total, int succesed) {
         this._total = total;
         this._succesed = succesed;
     }
}
