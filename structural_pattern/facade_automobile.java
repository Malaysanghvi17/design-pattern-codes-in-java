import java.util.Scanner;
interface Automobile {
    public void start();
    public void stop();
    public void accelerate(float acceleration);
}

class Car implements Automobile { @Override
public void start() {
    System.out.println("Starting the Car ..."); }
    @Override
    public void stop() {
        System.out.println("Applying hydraulic brakes ..."); }
    @Override
    public void accelerate(float acceleration) {
        System.out.println("Accelerating at "+acceleration+" m/s"); }
}
class Truck implements Automobile { @Override
public void start() {
    System.out.println("Starting the Truck ..."); }
    @Override
    public void stop() {
        System.out.println("Applying manual brakes ..."); }
    @Override
    public void accelerate(float acceleration) {
        System.out.println("Accelerating at "+acceleration+" kmph"); }
}
class Scooter implements Automobile { @Override
public void start() {
    System.out.println("Starting the Scooter ..."); }
    @Override
    public void stop() {
        System.out.println("Applying disk brakes ..."); }
    @Override
    public void accelerate(float acceleration){
        System.out.println("Accelerating at "+acceleration+" mph"); }
}
class AutomobileFacade {
    Scanner sc = new Scanner(System.in); Car c = new Car();
    Truck t = new Truck();
    Scooter s = new Scooter();
    public Automobile buildVehicle(String vehicleType) { if(vehicleType.equalsIgnoreCase("car")) {
        return c;
    } else if(vehicleType.equalsIgnoreCase("truck")) {
        return t; } else {
        return s; }
    }
    public void operateVehicle(String vehicle) {
        if(vehicle.equalsIgnoreCase("car")) { c.start();
            System.out.println("How much do you want to accelerate?"); float acc = sc.nextFloat();
            c.accelerate(acc);
            c.stop();
        } else if(vehicle.equalsIgnoreCase("truck")) { t.start();
            System.out.println("How much do you want to accelerate?"); float acc = sc.nextFloat();
            t.accelerate(acc);
            t.stop();
        } else { s.start();
            System.out.println("How much do you want to accelerate?"); float acc = sc.nextFloat();
            s.accelerate(acc);
            s.stop();
        } }
}
public class facade_automobile{
    public static void main(String[] args) {
        AutomobileFacade af = new AutomobileFacade();
        af.buildVehicle("car");
        af.operateVehicle("car");
    }
}