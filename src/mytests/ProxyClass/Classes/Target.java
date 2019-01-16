package mytests.ProxyClass.Classes;

import mytests.ProxyClass.Interfaces.I;

public class Target implements I {

    @Override
    public void m() {
        System.out.println(" m() in Target ");
    }
}
