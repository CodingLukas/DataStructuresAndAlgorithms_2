/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ktu.ds.lab1b.Zilinskas;

/**
 *
 * @author lukzil2
 */
import edu.ktu.ds.lab1b.util.Ks;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import edu.ktu.ds.lab1b.util.Parsable;

public class Motorcycle implements Parsable<Motorcycle> {

    // bendri duomenys visiems automobiliams (visai klasei)
    final static private int minYear = 1994;

    final static private double minPrice = 200.0;
    final static private double maxPrice = 120_000.0;

    // kiekvieno automobilio individualūs duomenys
    private int mileage;
    private double price;
    private String make;
    private String model;
    private int year;


    public Motorcycle() {
    }
    
   
    public Motorcycle(String make, String model,
            int year, int mileage, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public Motorcycle(String data) {
        parse(data);
    }

    @Override
    public final void parse(String data) {
        try {   // ed - tai elementarūs duomenys, atskirti tarpais
            Scanner ed = new Scanner(data);
            make = ed.next();
            model = ed.next();
            year = ed.nextInt();
            mileage = ed.nextInt();
            setPrice(ed.nextDouble());
        } catch (InputMismatchException e) {
            Ks.ern("Blogas duomenų formatas apie auto -> " + data);
        } catch (NoSuchElementException e) {
            Ks.ern("Trūksta duomenų apie auto -> " + data);
        }
    }

    public String validate() {
        String error = "";
        int currentYear = LocalDate.now().getYear();
        if (year < minYear || year > currentYear) {
            error = "Netinkami gamybos metai, turi būti ["
                    + minYear + ":" + currentYear + "]";
        }
        if (price < minPrice || price > maxPrice) {
            error += " Kaina už leistinų ribų [" + minPrice
                    + ":" + maxPrice + "]";
        }
        return error;
    }

    @Override
    public String toString() {  // surenkama visa reikalinga informacija
        return String.format("%-8s %-8s %4d %7d %8.1f %s",
                make, model, year, mileage, price, validate());
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }

    // keisti bus galima tik kainą - kiti parametrai pastovūs
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Motorcycle otherMotorcycle) {
        // lyginame pagal svarbiausią požymį - kainą
        double otherPrice = otherMotorcycle.getPrice();
        if (price < otherPrice) {
            return -1;
        }
        if (price > otherPrice) {
            return +1;
        }
        return 0;
    }
    // sarankiškai priderinkite prie Lambda funkcijų
    public final static Comparator<Motorcycle> byMakeAndModel
            = new Comparator<Motorcycle>() {
        @Override
        public int compare(Motorcycle Motorcycle1, Motorcycle Motorcycle2) {
            // pradžioje pagal markes, o po to pagal modelius
            int cmp = Motorcycle1.getMake().compareTo(Motorcycle2.getMake());
            if (cmp != 0) {
                return cmp;
            }
            return Motorcycle1.getModel().compareTo(Motorcycle2.getModel());
        }
    };
    public final static Comparator byPrice = new Comparator() {
        // sarankiškai priderinkite prie generic interfeiso ir Lambda funkcijų
        @Override
        public int compare(Object obj1, Object obj2) {
            double price1 = ((Motorcycle) obj1).getPrice();
            double price2 = ((Motorcycle) obj2).getPrice();
            // didėjanti tvarka, pradedant nuo mažiausios
            if (price1 < price2) {
                return -1;
            }
            if (price1 > price2) {
                return 1;
            }
            return 0;
        }
    };
    public final static Comparator byYearAndPrice = new Comparator() {
        // sarankiškai priderinkite prie generic interfeiso ir Lambda funkcijų
        @Override
        public int compare(Object obj1, Object obj2) {
            Motorcycle c1 = (Motorcycle) obj1;
            Motorcycle c2 = (Motorcycle) obj2;
            // metai mažėjančia tvarka, esant vienodiems lyginama price
            if (c1.getYear() < c2.getYear()) {
                return 1;
            }
            if (c1.getYear() > c2.getYear()) {
                return -1;
            }
            if (c1.getPrice() < c2.getPrice()) {
                return 1;
            }
            if (c1.getPrice() > c2.getPrice()) {
                return -1;
            }
            return 0;
        }
    };

    // metodas main = tiesiog paprastas pirminis automobilių išbandymas
    public static void main(String... args) {
        // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        Motorcycle a1 = new Motorcycle("Renault", "Laguna", 1997, 50000, 599);
        Motorcycle a2 = new Motorcycle("Renault", "Megane", 2015, 20000, 3500);
        Motorcycle a3 = new Motorcycle();
        Motorcycle a4 = new Motorcycle();
        a3.parse("Toyota Corolla 2001 20000 8500,8");
        a4.parse("Toyota Avensis 1990 20000  500,8");
        Ks.oun(a1);
        Ks.oun(a2);
        Ks.oun(a3);
        Ks.oun(a4);
    }
}
