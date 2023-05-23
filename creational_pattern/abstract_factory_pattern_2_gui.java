package creational_pattern;

//• GUI FACTORY :
interface Button {
    public void designButton();
}
interface CheckBox {
    public void designCheckBox();
}
class WinButton implements Button {
    @Override
    public void designButton() {
        System.out.println("Designing a button for Windows OS.");
    }
}
class MacButton implements Button {
    @Override
    public void designButton() {
        System.out.println("Designing a button for macOS X.");
    }
}
class WindCheckBox implements CheckBox {
    @Override
    public void designCheckBox() {
        System.out.println("Designing a checkbox for Windows OS.");
    }
}
class MacCheckBox implements CheckBox {
    @Override
    public void designCheckBox() {
        System.out.println("Designing a checkbox for macOS.");
    }
}
interface GUI_Factory {
    public Button createButton(String osName);
    public CheckBox createCheckBox(String osName);
}

class WinFactory implements GUI_Factory {
    @Override
    public Button createButton(String osName) {
        if(osName.equalsIgnoreCase("Windows")) {
            return new WinButton();
        }
        return null;
    }
    @Override
    public CheckBox createCheckBox(String osName) {
        if(osName.equalsIgnoreCase("Windows")) {
            return new WindCheckBox();
        }
        return null;
    }
}
class MacFactory implements GUI_Factory {
    @Override
    public Button createButton(String osName) {
        if(osName.equalsIgnoreCase("macOS")) {
            return new MacButton();
        }
        return null;
    }
    @Override
    public CheckBox createCheckBox(String osName) {
        if(osName.equalsIgnoreCase("macOS")) {
            return new MacCheckBox();
        }
        return null;
    }
}
class Application {
    Application(String OS_Name) {
        if(OS_Name.equalsIgnoreCase("Windows")) {
            GUI_Factory fac1 = new WinFactory();
            Button b1 = fac1.createButton("Windows");
            CheckBox c1 = fac1.createCheckBox("Windows");
            b1.designButton();
            c1.designCheckBox();
        }
        else if (OS_Name.equalsIgnoreCase("macOS")) {
            GUI_Factory fac2 = new MacFactory();
            Button b2 = fac2.createButton("macOS");
            CheckBox c2 = fac2.createCheckBox("macOS");
            b2.designButton();
            c2.designCheckBox();
        }
        else {
            return;
        }
    }
}
class  abstract_factory_pattern_2_gui{
    public static void main(String[] args) {

        Application a1 = new Application("Windows");
    }
}