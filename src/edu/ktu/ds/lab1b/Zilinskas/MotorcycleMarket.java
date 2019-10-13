/*
 * Tai yra automobilių sąrašų kūrimo ir tolimesnių taikomųjų veiksmų klasė.
   *  IŠSIAIŠKINKITE metodų sudarymą, jų paskirtį.
   *  PASIRINKITE savo objektų klasę ir sudarykite analogiškus metodus
   *  GERESNIAM ĮSISAVINIMUI rekomenduojame pradėti nuo tuščios klasės
   ****************************************************************************/
package edu.ktu.ds.lab1b.Zilinskas;

import edu.ktu.ds.lab1b.demo.*;

public class MotorcycleMarket {

    public MotorcycleList allMotorcycles = new MotorcycleList();

    // suformuojamas sąrašas automobilių, kurie pagaminti vėliau nei riba
    public MotorcycleList getNewerMotorcycles(int fromYear) {
        MotorcycleList cars = new MotorcycleList();
        for (Motorcycle c : allMotorcycles) {
            if (c.getYear() >= fromYear) {
                cars.add(c);
            }
        }
        return cars;
    }

    // suformuojamas sąrašas automobilių, kurių kaina yra tarp ribų
    public MotorcycleList getByPrice(int fromPrice, int toPrice) {
        MotorcycleList cars = new MotorcycleList();
        for (Motorcycle c : allMotorcycles) {
            if (c.getPrice() >= fromPrice && c.getPrice() <= toPrice) {
                cars.add(c);
            }
        }
        return cars;
    }

    // suformuojamas sąrašas automobilių, turinčių didžiausią ridą
    public MotorcycleList getHighestMileageMotorcycles() {
        MotorcycleList cars = new MotorcycleList();
        // formuojamas sąrašas su maksimalia reikšme vienos peržiūros metu
        double maxMileage = 0;
        for (Motorcycle c : allMotorcycles) {
            double mileage = c.getMileage();
            if (mileage >= maxMileage) {
                if (mileage > maxMileage) {
                    cars.clear();
                    maxMileage = mileage;
                }
                cars.add(c);
            }
        }
        return cars;
    }

    // suformuojams sąrašas automobilių, kurių modelio kodas atitinka nurodytą
    public MotorcycleList getByMakeAndModel(String makeAndModel) {
        MotorcycleList cars = new MotorcycleList();
        for (Motorcycle c : allMotorcycles) {
            String carMakeAndModel = c.getMake() + " " + c.getModel();
            if (carMakeAndModel.startsWith(makeAndModel)) {
                cars.add(c);
            }
        }
        return cars;
    }
    // metodo main nėra -> demo bandymai klasėje AutomobiliuBandymai
}
