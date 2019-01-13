package com.Exercise8;

import com.Exercise8.Annotations.MyAnnotation;

public class Entity {
    @MyAnnotation(min_value = 1, max_value = 11)
    int field1;
    @MyAnnotation(min_value = 100, max_value = 210)
    int field2;


    public Entity(int field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

}
