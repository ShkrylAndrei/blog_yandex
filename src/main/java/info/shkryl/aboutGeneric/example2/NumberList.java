package info.shkryl.aboutGeneric.example2;

import java.util.List;

class NumberList {
    public void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }
}
