package com.Exercise11.Class;

import com.Exercise11.Annotation.I2;
import com.Exercise11.Annotation.Transactional;

import java.net.MalformedURLException;

public class Service implements I2 {

    @Override
    public void m1() {
        System.out.println("M1 In Service");
    }

    @Override
    @Transactional
    public void m2() throws MalformedURLException {
        throw new MalformedURLException();
    }

    @Transactional
    public void m3() {
        throw new IndexOutOfBoundsException();
    }

    @Transactional
    public void m4() {
    }

    @Transactional
    public void m5() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    public void m6() {
    }

    @Transactional
    public void m7() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

}
