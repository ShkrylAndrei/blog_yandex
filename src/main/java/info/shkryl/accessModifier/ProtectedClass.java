package info.shkryl.accessModifier;

public class ProtectedClass {
    protected int data; // Доступно в подклассах и в том же пакете
    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }
}