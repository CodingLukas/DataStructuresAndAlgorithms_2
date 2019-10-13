/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ktu.ds.lab1b.util;

import static edu.ktu.ds.lab1b.Zilinskas.Benchmark.arraylinked;
import edu.ktu.ds.lab1b.Zilinskas.Motorcycle;

/**
 *
 * @author lukzil2
 */
public class Main {
    public static void main(String[] args) {
        
        LinkedList<Motorcycle> list = new LinkedList<Motorcycle>();
        list.add(new Motorcycle("BMW", "Audi",
            2010, 100, 100));
        
         LinkedList<Motorcycle> list2 = new LinkedList<Motorcycle>();
        list2.add(new Motorcycle("BMW", "Audi",
            2010, 100, 100));
        
        
         LinkedList<Motorcycle> list3 = new LinkedList<Motorcycle>();
        list3.add(new Motorcycle("BMW", "Audi",
            2010, 100, 100));
        list3.add(new Motorcycle("BMW", "Audi",
            2010, 100, 100));
        System.out.print(list.containsAll(list3));
        
    }
}
