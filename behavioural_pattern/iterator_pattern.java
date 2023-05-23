//package BehaviouralPattern;

import java.util.ArrayList;
import java.util.List;

class student {
    int id;
    String name;
    double percentage;

    public student(int i, String n, double pr) {
        id = i;
        name = n;
        percentage = pr;
    }

    public String toString() {
        return "Student: id : "+id+" name : "+name+" percentage : "+percentage;
    }
}

class StudentCollection {
    List<student> ls = new ArrayList<student>();
    public void addStudent(student s) {
        ls.add(s);
    }
    public void removeStudent(student s) {
        ls.remove(s);
    }
    public List<student> getList() {
        return ls;
    }
    public Iterator getIterator() {
        return new StandardIterator(ls);
    }
}

interface Iterator {
    public student next();
    public boolean hasNext();
}

class StandardIterator implements Iterator {
    List<student> ls;
    public StandardIterator(List<student> s1) {
        ls = s1;
    }
    int position = 0;

    @Override
    public student next() {
        student s = ls.get(position);
        position++;
        return s;
    }

    @Override
    public boolean hasNext() {
        return position < ls.size();
    }
}
public class iterator_pattern {
    public static void main(String[] args) {
        student s1 = new student(503,"Sd3",70);
        student s2 = new student(504,"Sd4",75);
        student s3 = new student(505,"Sd5",80);
        student s4 = new student(506,"Sd6",85);
        student s5 = new student(507,"Sd7",80);

        StudentCollection sc = new StudentCollection();
        sc.addStudent(s1);
        sc.addStudent(s2);
        sc.addStudent(s3);
        sc.addStudent(s4);
        sc.addStudent(s5);

        Iterator is = new StandardIterator(sc.getList());
        while(is.hasNext()) {
            student s = is.next();
            System.out.println(s.toString());
        }
    }
}
