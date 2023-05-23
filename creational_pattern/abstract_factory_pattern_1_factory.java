package creational_pattern;

interface Abstract_factory{
public table table_factory(String mat_type);
public chair chair_factory(String mat_type);
}

class wooden_factory implements Abstract_factory{

    @Override
    public wooden_table table_factory(String mat_type) {
        if (mat_type.equalsIgnoreCase("wooden")) {
            return new wooden_table();
        }
        else{
            return null;
        }
    }
    @Override
    public wooden_chair chair_factory(String mat_type) {
        if (mat_type.equalsIgnoreCase("wooden")) {
            return new wooden_chair();
        }
        else{
            return null;
        }
    }
}

class plastic_factory implements Abstract_factory{

    @Override
    public plastic_table table_factory(String mat_type) {

        if (mat_type.equalsIgnoreCase("plastic")) {

            return new plastic_table();
        }
        else{
            return null;
        }
    }

    @Override
    public plastic_chair chair_factory(String mat_type) {

        if (mat_type.equalsIgnoreCase("plastic")) {
            return new plastic_chair();
        }
        else{
            return null;
        }
    }
}


interface table{
    public void design_table();
}
interface chair{
    public void design_chair();
}

class plastic_table implements table{
    @Override
    public void design_table() {
        System.out.println("designing plastic table!");
    }
}
class wooden_table implements table{
    @Override
    public void design_table() {
        System.out.println("designing wooden table!");
    }
}
class plastic_chair implements chair{
    @Override
    public void design_chair() {
        System.out.println("designing plastic chair!");
    }
}
class wooden_chair implements chair{
    @Override
    public void design_chair() {
        System.out.println("designing wooden chair!");
    }
}



class abstact_factory_pattern_1_factory {
    public static void main(String[] args) {
          Abstract_factory wfp = new wooden_factory();
          Abstract_factory pfp = new plastic_factory();
          chair c1 = wfp.chair_factory("wooden");
          c1.design_chair();
          chair c2 = pfp.chair_factory("plastic");
          c2.design_chair();
          table t1 = wfp.table_factory("wooden");
          t1.design_table();
          table t2 = pfp.table_factory("plastic");
          t2.design_table();
    }
}
