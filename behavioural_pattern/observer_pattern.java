package behavioural_pattern;
import java.util.ArrayList;
import java.util.List;

class SubjectEntity
{
    private int numberState;
    private List<ObserverEntity> lm = new ArrayList<ObserverEntity>();

    public void setNumberState(int numberState)
    {
        this.numberState = numberState;
        notifyAllObservers();
    }

    public int getNumberState()
    {
        return numberState;
    }

    public void subscribeObserver(ObserverEntity e)
    {
        lm.add(e);
    }

    public void unsubscribeObserver(ObserverEntity e)
    {
        lm.remove(e);
    }

    public void notifyAllObservers()
    {
        for(ObserverEntity ob : lm)
        {
            ob.update();
        }
    }
}

abstract class ObserverEntity
{
    SubjectEntity se;
    abstract public void update();
}

class BinaryObserverEntity extends ObserverEntity
{
    public BinaryObserverEntity(SubjectEntity e)
    {
        se = e;
    }
    @Override
    public void update()
    {
        int n = se.getNumberState();
        System.out.println("Binary Observer represents number : " + n + " to Binary : " + Integer.toBinaryString(n));
    }
}

class HexObserver extends ObserverEntity
{
    public HexObserver(SubjectEntity e)
    {
        se = e;
    }
    @Override
    public void update()
    {
        int n = se.getNumberState();
        System.out.println("Hex Observer represents number : " + n + " to Hexadecimal : " + Integer.toHexString(n));
    }
}

class OctalObserver extends ObserverEntity
{
    public OctalObserver(SubjectEntity e)
    {
        se = e;
    }
    @Override
    public void update()
    {
        int n = se.getNumberState();
        System.out.println("Octal Observer represents number : " + n + " to Octal : " + Integer.toOctalString(n));
    }
}

class observer_pattern
{
    public static void main(String[] args)
    {
        SubjectEntity se = new SubjectEntity();
        ObserverEntity ob1 = new BinaryObserverEntity(se);
        ObserverEntity ob2 = new HexObserver(se);
        ObserverEntity ob3 = new OctalObserver(se);

        se.subscribeObserver(ob1);
        se.subscribeObserver(ob2);
        se.subscribeObserver(ob3);
        se.setNumberState(45);
    }
}

//package behavioural_pattern;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class subjectentity {
//    private int numberstate;
//    private List<observer_entity> loe = new ArrayList<>();
//
//
//    public void setNumberstate(int n) {
//        numberstate = n;
//        notify_all_observer();
//    }
//
//    public int getNumberstate() {
//        return numberstate;
//    }
//
//    public void subscribe_observer(observer_entity oe) {
//        loe.add(oe);
//    }
//    public void unsubscribe_observer(observer_entity oe) {
//        loe.remove(oe);
//    }
//    public void notify_all_observer(){
//        for(observer_entity l : loe){
//            l.update();
//        }
//    }
//}
//
//abstract class observer_entity{
//    subjectentity se;
//    abstract public void update();
//
//}
//
//class binary_observer_entity extends observer_entity{
//    public binary_observer_entity(subjectentity e){
//        se = e;
//    }
//
//    @Override
//    public void update() {
//        int n = se.getNumberstate();
//        System.out.println("binary observer represent number: " + n + " to binary: " + Integer.toBinaryString(n));
//    }
//}
//class hex_observer_entity extends observer_entity{
//    public hex_observer_entity(subjectentity e){
//        se = e;
//    }
//
//    @Override
//    public void update() {
//        int n = se.getNumberstate();
//        System.out.println("binary observer represent number: " + n + " to hex: " + Integer.toHexString(n));
//    }
//}
//
//public class observer_pattern {
//    public static void main(String[] args) {
//        subjectentity se = new subjectentity();
//        observer_entity oe1 = new binary_observer_entity(se);
//        observer_entity oe2 = new hex_observer_entity(se);
//
//        se.subscribe_observer(oe1);
//        se.setNumberstate(20);
//        se.subscribe_observer(oe2);
//        se.setNumberstate(20);
//
//    }
//}
