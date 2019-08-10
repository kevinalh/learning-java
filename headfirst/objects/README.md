# 2. Objects
The book covers the benefits of inheritance as well as the notions of instance variables and methods.
To create an object from a class, the syntax used is:
```java
ExampleClass = new ExampleClass();
```
For distributing a Java application, it's possible to use a _Java Archive_ (`.jar`) file, based on the _pkzip_ format,
which contains a _manifest_ defining the class in which the `main` function is located.

Variables can be **primitives** or **references**. Think of references as remote controls, which can control objects
in the heap. They can point to different objects during runtime, unless declared as `final`.
References can be assigned as `null`, which means the reference points nowhere.

In the GuessGame example, there are three players guessing a number from 0 to 9.
