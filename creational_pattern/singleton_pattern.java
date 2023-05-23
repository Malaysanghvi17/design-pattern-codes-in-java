class SingletonBanker {
    private String id_value;
    private static SingletonBanker obj;
    private SingletonBanker(String id_value) {
        this.id_value = id_value;
    }

    public static SingletonBanker getInstance(String id_value) {
        if (obj == null){
            obj = new SingletonBanker(id_value);
            System.out.println("id_value" + id_value);
        }
    return obj;
    }

    public String getId_value(){
        return id_value;
    }
}


public class singleton_pattern {
    public static void main(String[] args) {
            SingletonBanker sb1 = SingletonBanker.getInstance("21BCP312");
        System.out.println(sb1.getId_value());
            SingletonBanker sb2 = SingletonBanker.getInstance("21BCP307");
        System.out.println(sb2.getId_value());
            SingletonBanker sb3 = SingletonBanker.getInstance("21BCP313");
        System.out.println(sb3.getId_value());
            SingletonBanker sb4 = SingletonBanker.getInstance("21BCP300");
        System.out.println(sb4.getId_value());
    }
}

