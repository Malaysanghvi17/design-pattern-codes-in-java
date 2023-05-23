import java.util.ArrayList;
import java.util.List;

class originator_object {
    private int volume;
    private int temperature;

    public originator_object(int t, int v) {
        temperature = t;
        volume = v;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return volume;
    }
    public memento_object save_state() {
        return new memento_object(temperature, volume);
    }
    public void restore_state(memento_object mo) {
        temperature = mo.getTemperature();
        volume = mo.getVolume();
    }
    public String toString() {
        return "Temperature: " + temperature + " Volume: " + volume;
    }
}

class memento_object {
    int volume, temperature;

    memento_object(int v, int t) {
        volume = v;
        temperature = t;
    }
    public int getTemperature() {
        return temperature;
    }
    public int getVolume() {
        return volume;
    }
}

class caretaker_object {
    List<memento_object> lm = new ArrayList<>();
    public void add_memento_object(memento_object mo) {
        lm.add(mo);
    }
    public memento_object get_memento_object(int i) {
        return lm.get(i);
    }
}

public class memento_pattern {
    public static void main(String[] args) {
        originator_object oo1 = new originator_object(15, 20);
        caretaker_object co1 = new caretaker_object();

        memento_object m1 = oo1.save_state();
        System.out.println("storing object.....");
        co1.add_memento_object(m1);
        oo1.setTemperature(55);
        oo1.setVolume(75);
        System.out.println(oo1.toString());

        memento_object m2 = oo1.save_state();
        System.out.println("storing object.....");
        co1.add_memento_object(m2);
        oo1.setTemperature(35);
        oo1.setVolume(95);
        System.out.println(oo1.toString());

        memento_object m3 = oo1.save_state();
        System.out.println("storing object.....");
        co1.add_memento_object(m3);

        System.out.println("retrieving object 0.....");
        System.out.println("Temperature: " + co1.get_memento_object(0).temperature + " Volume: "
                + co1.get_memento_object(0).volume);
        System.out.println("retrieving object 1.....");
        System.out.println("Temperature: " + co1.get_memento_object(1).temperature + " Volume: "
                + co1.get_memento_object(0).volume);
        System.out.println("retrieving object 2.....");
        System.out.println("Temperature: " + co1.get_memento_object(2).temperature + " Volume: "
                + co1.get_memento_object(2).volume);
    }
}
