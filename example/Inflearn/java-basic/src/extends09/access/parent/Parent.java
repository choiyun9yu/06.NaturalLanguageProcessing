package extends09.access.parent;

public class Parent {

    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod() {
        System.out.println("Parent.publicMethod");
    }

    protected void protectedMethod(){
        System.out.println("Parent.protectedMethod");
    }

    void defaultMethod(){
        System.out.println("Parent.defaultMethod");
    }

    private void privateMethod(){
        System.out.println("privateMethod");
    }

    public void printParent() {
        System.out.println("==Parent 메서드 내부==");
        System.out.println("publicValue = " + publicValue);
        System.out.println("publicValue = " + protectedValue);
        System.out.println("publicValue = " + defaultValue);
        System.out.println("publicValue = " + privateValue);

        defaultMethod();
        privateMethod();
    }

}
