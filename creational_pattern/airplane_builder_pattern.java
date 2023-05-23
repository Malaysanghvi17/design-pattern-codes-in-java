//AIRPLANE BUILDER :
class AeroSpaceEngineer {
    private AirplaneBuilder airplaneBuilder;
    public void setAirplaneBuilder(AirplaneBuilder ab) {
        airplaneBuilder = ab;
    }
    public Airplane getAirplane() {
        return airplaneBuilder.getAirplane();
    }
    public void constructAirplane() {
        airplaneBuilder.createNewAirplane();
        airplaneBuilder.buildWings();
        airplaneBuilder.buildPowerplant();
        airplaneBuilder.buildAvionics();
        airplaneBuilder.buildSeats();
    }
}
abstract class AirplaneBuilder {
    protected Airplane airplane;
    protected String customer;
    protected String type;
    public Airplane getAirplane() {
        return airplane;
    }
    public void createNewAirplane() {
        airplane = new Airplane(customer, type);
    }
    public abstract void buildWings();
    public abstract void buildPowerplant();
    public abstract void buildAvionics();
    public abstract void buildSeats();
}
class Airplane {
    private final String type;
    private float wingspan;
    private String powerplant;
    private int crewSeats;
    private int passengerSeats;
    private String avionics;
    private final String customer;
    Airplane(String customer, String type) {
        this.customer = customer;
        this.type = type;
    }
    public void setWingspan(float wingspan) {
        this.wingspan = wingspan;
    }
    public void setPowerplant(String powerplant) {
        this.powerplant = powerplant;
    }
    public void setAvionics(String avionics) {
        this.avionics = avionics;
    }
    public void setNumberSeats(int crewSeats, int
            passengerSeats) {
        this.crewSeats = crewSeats;
        this.passengerSeats = passengerSeats;
    }
    public String getCustomer() {
        return customer;
    }
    public String getType() {
        return type;
    }
}
class CropDuster extends AirplaneBuilder {
    CropDuster(String customer) {
        super.customer = customer;
        super.type = "Crop Duster v3.4";
    }
    public void buildWings() {
        airplane.setWingspan(9f);
    }
    public void buildPowerplant() {
        airplane.setPowerplant("single piston");
    }
    public void buildAvionics() {
    }
    public void buildSeats() {
        airplane.setNumberSeats(1, 1);
    }
}
class FighterJet extends AirplaneBuilder {
    FighterJet(String customer) {
        super.customer = customer;
        super.type = "F-35 Lightning II";
    }
    public void buildWings() {
        airplane.setWingspan(35.0f);
    }
    public void buildPowerplant() {
        airplane.setPowerplant("dual thrust vectoring");
    }
    public void buildAvionics() {
        airplane.setAvionics("military");
    }
    public void buildSeats() {
        airplane.setNumberSeats(1, 0);
    }
}
class Glider extends AirplaneBuilder {
    Glider(String customer) {
        super.customer = customer;
        super.type = "Glider v9.0";
    }
    public void buildWings() {
        airplane.setWingspan(57.1f);
    }
    public void buildPowerplant() {
    }
    public void buildAvionics() {
    }
    public void buildSeats() {
        airplane.setNumberSeats(1, 0);
    }
}
class Airliner extends AirplaneBuilder {
    Airliner(String customer) {
        super.customer = customer;
        super.type = "787 Dreamliner";
    }
    public void buildWings() {
        airplane.setWingspan(197f);
    }
    public void buildPowerplant() {
        airplane.setPowerplant("dual turbofan");
    }
    public void buildAvionics() {
        airplane.setAvionics("commercial");
    }
    public void buildSeats() {
        airplane.setNumberSeats(8, 289);
    }
}
class airplane_Builder_pattern{
    public static void main(String[] args) {
// instantiate the director (hire the engineer)
        AeroSpaceEngineer aero = new AeroSpaceEngineer();
// instantiate each concrete builder (take orders)
        AirplaneBuilder crop = new CropDuster("Alice johnson");
        AirplaneBuilder fighter = new FighterJet("f22");
        AirplaneBuilder glider = new Glider("Tim Rice");
        AirplaneBuilder airliner = new Airliner("AirIndia");

        aero.setAirplaneBuilder(crop);
        aero.constructAirplane();
        Airplane completedCropDuster = aero.getAirplane();
        System.out.println(completedCropDuster.getType() + "is completed and ready for delivery to " +
        completedCropDuster.getCustomer());
    }
}