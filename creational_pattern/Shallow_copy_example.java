class shallow_Address {
private String street;
private String city;

public shallow_Address(String street, String city) {
        this.street = street;
        this.city = city;
        }

public String getStreet() {
        return street;
        }

public void setStreet(String street) {
        this.street = street;
        }

public String getCity() {
        return city;
        }

public void setCity(String city) {
        this.city = city;
        }

@Override
public Object clone() throws CloneNotSupportedException {
        return new shallow_Address(street, city);
}
}

class shallow_Person implements Cloneable {
    private String name;
    private int age;
    private shallow_Address address;

    public shallow_Person(String name, int age, shallow_Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public shallow_Address getAddress() {
        return address;
    }

    public void setAddress(shallow_Address address) {
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        shallow_Address clonedAddress = (shallow_Address) address.clone();
        return new shallow_Person(name, age, clonedAddress);
    }
}

public class Shallow_copy_example {
    public static void main(String[] args) {

    }
}
