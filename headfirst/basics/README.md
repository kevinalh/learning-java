# 1. Basics
These are basic example of classes in Java. Note that each file has to contain a single class, and that the entry point
of the application is the `main` function.

```java
public class BasicClass {
    public static void main(String[] args) {
        System.out.print("Hello, world!");
    }
}
```

To compile them, use `javac DooBee.java`, which will generate a `DooBee.class` byte-code file.
To run them on the JVM, use `java DooBee`.

While the compiler checks for syntax and type issues, many issues can still arise at runtime, for example when
casting inappropiately, in which case there's a `ClassCastException`.
This leeway is provided to allow the language to have interesting features like *dynamic binding*, which allows the
JVM to select the appropiate method to run at runtime, providing polymorphism.
