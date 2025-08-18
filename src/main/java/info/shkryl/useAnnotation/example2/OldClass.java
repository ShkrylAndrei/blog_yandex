package info.shkryl.useAnnotation.example2;

public class OldClass {

    /**
     * @deprecated Используйте newMethod() вместо этого.
     */
    @Deprecated
    public void oldMethod() {
        System.out.println("Этот метод устарел!");
    }

    public void newMethod(){
        System.out.println("Этот метод нужно использовать");
    }
}
