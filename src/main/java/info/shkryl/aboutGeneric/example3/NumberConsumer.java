package info.shkryl.aboutGeneric.example3;

import java.util.List;

class NumberConsumer {
    public void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
}
