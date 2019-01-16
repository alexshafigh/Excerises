package mytests.ProxyClass.Classes;

import mytests.ProxyClass.Interfaces.I;

public class Client {
    public static void main(String[] args) {
        getService().m();

    }

    public static I getService() {
        return (I) IHandler.createProxyForMe(new Target());
    }
}
