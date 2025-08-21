package info.shkryl.aboutGabageCollector;

class Node {
    Node next;
}

public class Main {
    public static void main(String[] args) {
        Node a = new Node();
        Node b = new Node();

        a.next = b;
        b.next = a;

        a = null;
        b = null;

        // Теперь объекты a и b недостижимы
    }
}
