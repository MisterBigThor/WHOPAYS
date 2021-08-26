# JAVA LANGUAGE

Java is a object-oriented programming language, with the next main features:

* C-like syntax.

* Easier to develop code, compared with C/C++.
* The Java code is processed by the Java Virtual Machine. The compilation process checks the syntax but doesn't build a binary file.
* All objects and types at Java are derived from the Object class.

[TOC]

## Environment

Java offers a easy-to-install package with all the requirements to develop and launch Java applications, called **Java SE (Standard Edition)**. Inside this package there is the **JDK** (Java Development Kit) and the **JRE** (Java Runtime Environment). In our case, we will use the Open Development Kit, don't select the commercial version.

To install the packages, depending the OS you will use you can see the following webpage (https://www.java.com/en/download/). 

Ubuntu provides via Aptitude the openjdk packages:

```bash
sudo apt install openjdk-8-jre
sudo apt install openjdk-8-jdk
sudo apt-get install openjdk-8-doc #Optional -> documentation

java -version #check the java version
javac -version #check for the compiler version
```

Once we have the environment set up, we can run a hello world program:

```java
class HelloWorld{
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

By convention, the name of the file is the name of the main class of the file, in this case *HelloWorld.java* .We can compile using:

````bash
#Generate the .java file:
javac helloworld.java	
#Run the "program", use the class name. The class needs to have a main method.
java helloworld
````

## Language Basics

### Basic types

Named primitive data types, the next types are allowed:

| Type name | Definition                                      | Literal example                                              |
| --------- | ----------------------------------------------- | ------------------------------------------------------------ |
| byte      | 8-bit signed two's complementary                | byte b = 100;                                                |
| short     | 16-bit signed two's complement integer          | short s = 1234;                                              |
| int       | 32-bit signed two's complement integer          | int i = 6584;                                                |
| long      | 64-bit signed two's complement integer          | long l = 1090000;                                            |
| float     | Single-precision 32-bit IEEE 754 floating point | float f1  = 123.4f;                                          |
| double    | double-precision 64-bit IEEE 754 floating point | double d1 = 123.4; <br>double d2 = 1.234e2; <br>double d3 = 123.4d; |
| boolean   | true/false                                      | bool x = true;                                               |
| char      | 2 byte UNICODE encodingf                        | char c = 'a';<br>char c_unicode = '\u0108'                   |

> The string data type (String) can be considered a primitive data type. The compiler will create a new object if you use the double quotes without using the *new* builder. 
>
> The next special chars can be useful: `\b` (backspace), `\t` (tab), `\n` (line feed), `\f` (form feed), `\r` (carriage return), `\"` (double quote), `\'` (single quote), and `\\` (backslash)

> Is possible to use hexadecimal and binary literals to assign to integer-type variables:
> * `int dec_val = 26;`
> * `int hexVal = 0x1a;`
> * `int binVal = 0b11010;`

> The numeric literals can use underscores to be more readable:
>
> * `long hexBytes = 0xFF_EC_DE_5E;`
> * `long creditCardNumber = 1234_5678_9012_3456L;`

Many of this basic types have a wrapper class,  including all the support/useful methods. For example the class Integer is a wrapper for the int data type with some parsing methods and other useful functions.

### Variables

The variables at Java are declared in a C-style: `int i_myInt = 0;` for example. The important facts to take into account are:

* Case sensitive at the naming. By convention the camel-case is wide-used in this language to split variable and class names. Variables can start with underscore or $ symbol, but is a bad practice.

* Static type for the variables, not as Python.

* A variable is only a pointer to an object, a new object is created with the `new` reserved word.

  ````java
  int x = 23;
  Integer xx = 44; //Can use new Integer, but the method is deprecated.
  point2d alfa = new point2d(x, xx);
  
  System.out.println(alfa.toString());
  //-> [23, 44]
  
  xx = 56;
  x = 11;
  System.out.println(alfa.toString());
  //-> [23, 44]
  
  point2d a = new point2d(0, 0);
  point2d b = new point2d(1, 1);
  point2d c = new point2d(0, 1);
  point2d d = new point2d(1, 0);
  
  List<point2d> poly = Arrays.asList(new point2d[]{a,b,c,d});
  System.out.println(poly);
  //->[[0,0], [1,1], [0,1], [1,0]]
  
  a.setX(22);
  System.out.println(poly);
  //->[[22,0], [1,1], [0,1], [1,0]]
  ````

There are different kind of variables:

* Parameters : A variable used in a method .
* Local variables: Variables used inside a curly bracket. Only accessible inside this scope.
* Class variables (C++ static) : Declared with the `static` modifier.
* Instance variable (non-static): Declared without the `static` modifier.

> Remember that all variables in Java are inside an Object because all in Java is an Object () even the main method.

###  Arrays

We can declare and allocate arrays with the following syntax:

```java
int[] array;	 		//Declare
array = new int[10]; 	//Allocate memory, deallocated via garbage collector.
array[7] = 4; 			//Access with C-style, first element at 0.
array[10] = 24; 		//Out of bounds: Throw an exception and kill the program.
```

### Operators, expressions and blocks

The operators are equal than C. You can see a summary of the operators [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html).

Almost all the blocks have a C-syntax.

* If-then, If-then-else, switch-case, while and for statements are equal than C.
* The branching statements (break, continue) are equal than C, considered bad practice.

## Classes, objects and UML

### Object

### Class

### Interfaces and abstract classes

### Inheritance

### Parametric classes



## Exceptions

TODO: try/catch - throw.

TODO: try/catch/finally

TODO: User-defined exceptions

## Input/Output streaming and file management

JSON, XML.

## Java objects and packages

Java defines packages names (like the C++ *name spaces*) to avoid conflicts and duplicated names and to tidy-up the developing environment.

> The fundamentals of Java are inside the `java.lang` package, the I/O is inside the `java.io`. Notice that the packages have a tree design.

To define a package, is as simple as place at the first line of the source code `package <GlobalPackage.PackageName>`.  Attaching this line will require a folder directory with the same route.

The reserver word `import <GlobalPackage.PackageName>`  is use to include the desired elements.

### Predefined data structures

## Javadoc comments

To create documentation, the javadoc tools is the most used:

```bash
javadoc <packageName> -d <outputDirectory>
```

This will generate a web page.



To go further in Java, read about the next topics:

* JAVA annotations : https://docs.oracle.com/javase/tutorial/java/annotations/index.html
* 