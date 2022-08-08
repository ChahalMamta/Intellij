package com.Intellij;


import com.Intellij.model.Cat;
import com.Intellij.model.ImportantString;
import com.Intellij.model.RunImmediately;
import com.Intellij.model.VeryImportant;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat myCat = new Cat("Kitty");
        myCat.speak();

        //Custom annotations - ElementType.TYPE -- Class
        if(myCat.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("This is very important");
        }else{
            System.out.println("This is not important");
        }

        //Custom annotations - ElementType.METHOD -- Method
        for(Method method : myCat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for(int i = 0 ;i < annotation.Times(); i++) {
                    method.invoke(myCat);
                }
            }
        }

        //Custom annotations - ElementType.FIELD -- Field
        for(Field field : myCat.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportantString.class)){
                Object objectValue = field.get(myCat);

               /* if(objectValue instanceof String stringValue){
                    String value = (String) objectValue;
                    System.out.println(stringValue.toUpperCase());
                }*/
            }
        }
    }
    


}
