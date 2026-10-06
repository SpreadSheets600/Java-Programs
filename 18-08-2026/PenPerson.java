class Pen {

    String type;
    String ink_color;

    Pen(String type, String ink_color) {
        this.type = type;
        this.ink_color = ink_color;
    }
}

class Person {

    String name;
    String position;

    Person(String name, String position) {
        this.name = name;
        this.position = position;
    }

    void writing(Pen pen) {
        System.out.println(
            position +
                " " +
                name +
                " Is Writing With A " +
                pen.ink_color +
                " " +
                pen.type +
                " Pen."
        );
    }
}

public class PenPerson {

    public static void main(String[] args) {
        Person p1 = new Person("BM", "Teacher");
        Person p2 = new Person("ABC", "Student");

        Pen pt1 = new Pen("Marker", "Black");
        Pen pt2 = new Pen("Ball", "Blue");

        p1.writing(pt1);
        p2.writing(pt2);
    }
}
