class computer{
    private int HDD;
    private int RAM_SIZE;
    private String PROCESSOR_MAKE;
    private String PROCESSOR_TYPE;
    private float MONITOR_SIZE;
    private String MONITOR_TYPE;
    private String OSCONFIG;
    private String DEVICE_DRIVER;

    public int getHDD() {
        return HDD;
    }
    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public int getRAM_SIZE() {
        return RAM_SIZE;
    }

    public void setRAM_SIZE(int RAM_SIZE) {
        this.RAM_SIZE = RAM_SIZE;
    }

    public String getPROCESSOR_MAKE() {
        return PROCESSOR_MAKE;
    }

    public void setPROCESSOR_MAKE(String PROCESSOR_MAKE) {
        this.PROCESSOR_MAKE = PROCESSOR_MAKE;
    }

    public String getPROCESSOR_TYPE() {
        return PROCESSOR_TYPE;
    }

    public void setPROCESSOR_TYPE(String PROCESSOR_TYPE) {
        this.PROCESSOR_TYPE = PROCESSOR_TYPE;
    }

    public float getMONITOR_SIZE() {
        return MONITOR_SIZE;
    }

    public void setMONITOR_SIZE(float MONITOR_SIZE) {
        this.MONITOR_SIZE = MONITOR_SIZE;
    }
    public String getMONITOR_TYPE(){
        return MONITOR_TYPE;
    }
    public void setMONITOR_TYPE(String MONITOR_TYPE) {
        this.MONITOR_TYPE = MONITOR_TYPE;
    }

    public String getOSCONFIG() {
        return OSCONFIG;
    }
    public void setOSCONFIG(String OSCONFIG) {
        this.OSCONFIG = OSCONFIG;
    }

    public String getDEVICE_DRIVER() {
        return DEVICE_DRIVER;
    }

    public void setDEVICE_DRIVER(String DEVICE_DRIVER) {
        this.DEVICE_DRIVER = DEVICE_DRIVER;
    }

    public void print_details() {
        System.out.println("hdd size: " + getHDD());
        System.out.println("processor make: " + getPROCESSOR_MAKE());
        System.out.println("processor type: " + getPROCESSOR_TYPE());
        System.out.println("monitor size: " + getMONITOR_SIZE());
        System.out.println("monitor type: " + getMONITOR_TYPE());
        System.out.println("os configuration: " + getOSCONFIG());
        System.out.println("ram size: " + getRAM_SIZE());
        System.out.println("device driver: " + getDEVICE_DRIVER());
    }

}

abstract class computer_builder{
    computer cp1;
    public void new_computer_builder(){
        cp1 = new computer();
    }
    public abstract void buildHDD();
    public abstract void buildRAM_SIZE();
    public abstract void buildPROCESSOR_MAKE();
    public abstract void buildPROCESSOR_TYPE();
    public abstract void buildMONITOR_SIZE();
    public abstract void buildMONITOR_TYPE();
    public abstract void buildOSCONFIG();
    public abstract void buildDEVICEDRIVER();
    public abstract computer getcomputer();
}

class personalcomputer extends computer_builder{

    @Override
    public void buildHDD() {
        cp1.setHDD(1024);
    }

    @Override
    public void buildRAM_SIZE() {
        cp1.setRAM_SIZE(16);
    }

    @Override
    public void buildPROCESSOR_MAKE() {
        cp1.setPROCESSOR_MAKE("intel");
    }

    @Override
    public void buildPROCESSOR_TYPE() {
        cp1.setPROCESSOR_TYPE("octacore");
    }

    @Override
    public void buildMONITOR_SIZE() {
        cp1.setMONITOR_SIZE(25.5f);
    }

    @Override
    public void buildMONITOR_TYPE() {
        cp1.setMONITOR_TYPE("oled 4k");
    }

    @Override
    public void buildOSCONFIG() {
        cp1.setOSCONFIG("windows");
    }

    @Override
    public void buildDEVICEDRIVER() {
        cp1.setDEVICE_DRIVER("device driver");
    }

    @Override
    public computer getcomputer() {
        return cp1;
    }
}

class servercomputer extends computer_builder{

    @Override
    public void buildHDD() {
        cp1.setHDD(4096);
    }

    @Override
    public void buildRAM_SIZE() {
        cp1.setRAM_SIZE(64);
    }

    @Override
    public void buildPROCESSOR_MAKE() {
        cp1.setPROCESSOR_MAKE("AMD");
    }

    @Override
    public void buildPROCESSOR_TYPE() {
        cp1.setPROCESSOR_TYPE("multicore");
    }

    @Override
    public void buildMONITOR_SIZE() {
        cp1.setMONITOR_SIZE(25.5f);
    }

    @Override
    public void buildMONITOR_TYPE() {
        cp1.setMONITOR_TYPE("oled 4k");
    }

    @Override
    public void buildOSCONFIG() {
        cp1.setOSCONFIG("unix");
    }

    @Override
    public void buildDEVICEDRIVER() {
        cp1.setDEVICE_DRIVER("device driver");
    }

    @Override
    public computer getcomputer() {
        return cp1;
    }

}

class Hardware_engineer{
private computer_builder cb;
public void setComputer_builder(computer_builder cb1){
        cb = cb1;
}
public void configure_computer(){
    cb.buildDEVICEDRIVER();
    cb.buildHDD();
    cb.buildMONITOR_SIZE();
    cb.buildMONITOR_TYPE();
    cb.buildOSCONFIG();
    cb.buildPROCESSOR_MAKE();
    cb.buildPROCESSOR_TYPE();
    cb.buildRAM_SIZE();
}
public computer getcomputer(){
    return cb.getcomputer();
}
}

public class builder_design_pattern {
    public static void main(String[] args) {

        Hardware_engineer he1 = new Hardware_engineer();

        computer_builder personal = new personalcomputer();
        personal.new_computer_builder();
        he1.setComputer_builder(personal);
        he1.configure_computer();
        computer cp1 = he1.getcomputer();
        cp1.print_details();

        System.out.println("");

        computer_builder server = new servercomputer();
        server.new_computer_builder();
        he1.setComputer_builder(server);
        he1.configure_computer();
        computer cp2 = he1.getcomputer();
        cp2.print_details();
    }
}
