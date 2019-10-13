/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ktu.ds.lab1b.Zilinskas;

import edu.ktu.ds.lab1b.demo.SimpleBenchmark;
import edu.ktu.ds.lab1b.util.Ks;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

/**
 *
 * @author Rio
 */
public class Benchmark {
    
      public static void main(String[] args) {
        arraylinked();
        
    }
      
      //Tiriama Math.Sqrt ir Math.Hypot
public static void sqrthypot(int x, int y){
        long t0 = System.nanoTime();
        Math.sqrt(x*x+y*y);
        long t1 = System.nanoTime();
        Math.hypot(x,y);
        long t2 = System.nanoTime();
        
         Ks.ouf("SQRT: %7.4f ms HYPOT: %7.4f ms \n",
                (t1 - t0)*1.0 / 1000000.0, (t2 - t1)*1.0 / 1000000.0);
    }
      
      //Tiriama LinkedList ir ArrayList
public static void arraylinked(){
        LinkedList<Integer> lints = new LinkedList<>();
        lints.add(1);
        lints.add(9);
        lints.add(4105);
        lints.add(390);
        lints.add(204778);
        lints.add(36);
        lints.add(390);
        lints.add(390);
        lints.add(18);
        lints.add(390);
        lints.add(14);
        
        
        ArrayList<Integer> aints = new ArrayList<>();
        aints.add(1);
        aints.add(9);
        aints.add(390);
        aints.add(14);
        aints.add(4105);
        aints.add(390);
        aints.add(204778);
        aints.add(36);
        aints.add(18);
        aints.add(390);
        aints.add(390);
        
        
        long t0 = System.nanoTime();
        lints.containsAll(lints);
        long t1 = System.nanoTime();
        aints.containsAll(aints);
        long t2 = System.nanoTime();
        
         Ks.ouf("LinkedList: %7.4f ms ArrayList: %7.4f ms \n",
                (t1 - t0)*1.0 / 1000000.0, (t2 - t1)*1.0 / 1000000.0);
        
    }
    
}
