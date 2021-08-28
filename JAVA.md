# Prop Course

## Table of contents

In this course you will see and learn the following contents. In this readme file you can find all the documentation 
you will need.
* PROP : Quick introduction about the subject
* Introduction to UML
* Introduction and basics for GIT
* JAVA lang introduction
  * Basics that you will need to know			
  * Introduction to three-layer architecture
  * Manage of files inside IntelliJ
  * Controller implementation and interaction between different layers   

* SWING								


## JAVA LANGUAGE

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

### Try / Catch

The **try** statement allows you to define a block of code to be tested for errors while it is being executed.

The **catch** statement allows you to define a block of code to be executed, if an error occurs in the try block.

The try and catch keywords come in pairs:
````java
try {
  //  Block of code to try
}
catch(Exception e) {
  //  Block of code to handle errors
}
````

#### Exemple
````java
public class Main {
  public static void main(String[ ] args) {
    try {
      int[] myNumbers = {1, 2, 3};
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }
}
````

### Finally

The finally statement lets you execute code, after try...catch, regardless of the result:

````java
public class Main {
  public static void main(String[] args) {
    try {
      int[] myNumbers = {1, 2, 3};
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    } finally {
      System.out.println("The 'try catch' is finished.");
    }
  }
}
````

#### Output

````
Something went wrong.
The 'try catch' is finished.
````

### Implementation of exceptions

For implement our exceptions we will use The throw statement  that allows to create a custom error.
The throw statement is used together with an exception type. 
There are many exception types available in Java: ArithmeticException, 
FileNotFoundException, ArrayIndexOutOfBoundsException, SecurityException, etc...

#### Exemple

````java
public class Main {
  static void checkAge(int age) {
    if (age < 18) {
      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }

  public static void main(String[] args) {
    checkAge(15); // Set age to 15 (which is below 18...)
  }
}
````

If we have some exceptions that are the same we can create a specific file for exceptions.

If you need to use or override some exceptions, you can refer to the following documentation to create your specific exceptions.
[Documentation custom-exception](https://www.javatpoint.com/custom-exception)

## Input/Output streaming and file management

When we work with files , I/O we need to understand what are paths. We can see two different types of paths. Absolute 
path and abstract path. In simple words, an absolute path refers to the same location in a file system relative 
to the root directory, whereas a relative path points to a specific location in a file system relative to the current directory you are working on.

### Files

**Package**: java.io.File . This package contains a functions that we could need for manage files or folders.

In the following link we can find all documentation about functions that contain this package. Remember read and ask us if you have any doubt. [Documentation](https://docs.oracle.com/javase/7/docs/api/java/io/File.html)

First of all we need to create a new instance of File object. 


````java
        File files = new File(path); # String that its the path of our file or folder
````
* We can check if file is directory or not using this function
````java
public Boolean isDirectory(String path) {
        File aux = new File(path);
        if(aux.isDirectory()) return true;
        else return false;
    }
````

* Or we can check if is file or not

````java
public Boolean isFile(String path) {
        File aux = new File(path);
        if(aux.isFile()) return true;
        else return false;
    }
````

* Creating a new Directory

````java
public Boolean createDirectory(String path_abs) {

        File aux = new File(path_abs);
        return aux.mkdir();

    }
````
* Read and Write files
  * For read and write files we need to import **FileInputStream** / **FileOutputStream**

    * Writing and reading file array of bytes
````java
public void saveFile(String path_out , ArrayList<Byte> s) throws IOException {
		FileOutputStream f = new FileOutputStream(path_out);
		byte[] bytes = new byte[s.size()];
		for(int i = 0; i < s.size(); ++i) {
			bytes[i] = s.get(i);
		}
		f.write(bytes, 0, bytes.length);
		f.close();
	}
````
````java
import java.nio.file.Paths;
import java.nio.file.Path;

public ArrayList<Byte> getArrayList(String path) throws IOException {
		Path rn_demo = Paths.get(path);
		ArrayList<Byte> aux = new ArrayList<Byte>();
		try (InputStream in = Files.newInputStream(rn_demo)) {
			byte[] bytes = new byte[(int)Files.size(rn_demo)];
			in.read(bytes);
			for(int i = 0; i < bytes.length; ++i) {
				aux.add((Byte)bytes[i]);
			}

			in.close();
		}
		return aux;
	}
````
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
