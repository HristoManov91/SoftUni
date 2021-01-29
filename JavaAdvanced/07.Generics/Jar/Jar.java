package Jar;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Jar<Type> {
    private ArrayDeque<Type> elements;

    public Jar(){
        this.elements = new ArrayDeque<>();
    }

    public void add (Type element){
        this.elements.push(element);
    }

    public Type remove(){
        return this.elements.pop();
    }
}
