package com.Exercise8;

import com.Exercise8.Annotations.MyAnnotation;
import com.Exercise8.Exceptions.MyOutOfBoundException;

import java.lang.reflect.Field;


public class Excercise8Main {
    public static void main(String[] args) {
        try {
            runValidation(new Entity(9, 230));
            System.out.println(" Validation Checked. Nothing Found");
        } catch (Exception e) {
            System.out.printf(" A Field Out Of Bound Found in ");
            System.out.println(e.toString());
        }
    }

    public static void runValidation(Entity entity) throws MyOutOfBoundException, IllegalAccessException {
        Class aClass = entity.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation[] annotations = field.getDeclaredAnnotationsByType(MyAnnotation.class);
                if (field.getInt(entity) >= annotations[0].min_value() && field.getInt(entity) <= annotations[0].max_value())
                    ;
                else throw new MyOutOfBoundException(field.getName());
            }
        }

    }
}
