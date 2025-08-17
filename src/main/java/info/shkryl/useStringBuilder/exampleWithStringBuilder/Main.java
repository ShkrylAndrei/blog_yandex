package info.shkryl.useStringBuilder.exampleWithStringBuilder;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Hello");
        builder.append(", World!");
        String result = builder.toString();
        System.out.println(result);
    }
}
