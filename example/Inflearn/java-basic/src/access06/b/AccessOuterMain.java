package access06.b;

import access06.a.AccessData;

public class AccessOuterMain {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        // public
        data.publicField = 1;
        data.publicMethod();

        // default
        // data.defaultField = 2;
        // data.defaultMethod();

        // private
        // data.privateField = 3;
        // data.privateMethod();

        data.innerAccess();
    }
}
