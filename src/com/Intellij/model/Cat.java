package com.Intellij.model;

@VeryImportant
public class Cat {
    @ImportantString
    private String name ;

    public Cat(String name){
        this.name = name ;
    }

    @RunImmediately(Times = 3)
    public void speak() {
        System.out.println("Meow!");
    }

    public void eat() {
        System.out.println("Munch!");
    }


}
