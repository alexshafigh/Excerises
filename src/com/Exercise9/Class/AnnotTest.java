package com.Exercise9.Class;

import com.Exercise9.Annotations.Test;

import java.net.MalformedURLException;


public class AnnotTest {
    private int field1;
    private long field2;
    private String field3;

    public void m1() {
    }

    @Test
    public void m2() throws MalformedURLException {
        throw new MalformedURLException();
    }

    @Test
    public long m3() {
        return 4;
    }

    @Test
    //compile time exception
    public int m4() {
        int[] a = new int[2];
        return a[4];
    }

    @Test
    public void m5() {
        throw new ClassCastException();
    }

}
