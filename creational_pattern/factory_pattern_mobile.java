package creational_pattern;

class mobilefactory{
public mobile createmobile(String mobilecompany){
    if(mobilecompany == null){
        return null;
    }
    if(mobilecompany.equalsIgnoreCase("samsung")){
        return new samsungcreation();

    } else if(mobilecompany.equalsIgnoreCase("apple")){
        return new applecreation();

    } else if(mobilecompany.equalsIgnoreCase("nokia")){
        return new nokiacreation();
    }
    return null;
}
}

interface mobile{       //1
    public void osname();
    public void playmusic();
    public void sendmessage();
}

class samsungcreation implements mobile{

    @Override
    public void osname() {
        System.out.println("one ui");
    }

    @Override
    public void playmusic() {
        System.out.println("music playing");
    }

    @Override
    public void sendmessage() {
        System.out.println("whatsapp");
    }
}
class applecreation implements mobile{
    @Override
    public void osname() {
        System.out.println("ios");
    }

    @Override
    public void playmusic() {
        System.out.println("imusic");
    }

    @Override
    public void sendmessage() {
        System.out.println("whatsapp");
    }
}

class nokiacreation implements mobile{
    @Override
    public void osname() {
        System.out.println("nokia os");
    }

    @Override
    public void playmusic() {
        System.out.println("music playing");
    }

    @Override
    public void sendmessage() {
        System.out.println("text messaging");
    }
}


public class factory_pattern_mobile {
    public static void main(String[] args) {
mobilefactory mobilefactory = new mobilefactory();
mobile s = mobilefactory.createmobile("samsung");
s.osname();
s.playmusic();
s.sendmessage();

mobile a = mobilefactory.createmobile("apple");
a.sendmessage();
a.osname();
a.playmusic();

mobile n = mobilefactory.createmobile("nokia");
n.playmusic();
n.sendmessage();
n.osname();
    }
}
