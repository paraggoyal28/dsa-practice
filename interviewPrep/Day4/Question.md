Day 4: Exception Handling

Reference:
https://github.com/atharvaM89/Complet_Core_Java/blob/main/5_Exception_handling/Exception%20Handling.md

Throwable
| - Error (Serious JVM/system problems)
|   |-OutOfMemoryError
|   |-StackOverflowError
|
| - Exception 
    |-RuntimeException (unchecked)
    | |-NullPointerException
    | |-ArithmeticException
    | |-ArrayIndexOutOfBoundsException
    | |-.... 
    | 
    |-CheckedException (compiler forces handling)
      |-IOException
      |-SQLException
      |-FileNotFoundException
      |...

Throwable root class for all errors and exceptions that can be thrown and caught

Throwable
|-Error
|-Exception

Common Methods:
* getMessage() - returns error message
* printStackTrace() - prints stack trace
* toString() - class name + message
* getCause() - returns underlying cause

Not catch Throwable directly

Error
Represents serious problems that applications generally should not try to recover from.

Examples:
OutOfMemoryError
StackOverflowError
NoClassDefFoundError

Example:
public static void recursive() {
    recursive();
}

This can produce;
StackOverflowError

Error != Exception
Errors are generally caused by JVM/system-level problems rather than normal application logic

## Exception
Conditions that an application may be able to handle.

|-RuntimeException
|-Other checked exception

Examples:
-IOException
-SQLException
-NullPointerException
-ArithmeticException

try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}

## RuntimeException
Parent class of most common unchecked exceptions

NullPointerException
ArithmeticException
ArrayIndexOutOfBoundsException
ClassCastException
NumberFormatException
IllegalArgumentException

Example:
String s = null;
System.out.println(s.length()); // NullPointerException

Compiler does not forces us to handle it.

## CheckedException
Exceptions that compiler forces us to handle or declare.
They are subclasses of Exception but not subclasses of RuntimeException

Examples:
IOException
SQLException
FileNotFoundException
ClassNotFoundException
InterruptedException

We need to either handle it or declared using throws

Handle it:
try {
    FileReader file = new FileReader("data.txt");
} catch (IOException ex) {
    System.out.println("File Error");
}

Or declare it:

public void readFile() throws IOException {
    FileReader file = new FileReader("data.txt");
}

## UncheckedException

Compiler does not force us to handle.
They include:
1. RuntimeException and its subclasses
2. Error and its subclasses are also unchecked

Common unchecked exceptions:
* NullPointerException
* ArithmeticException
* ArrayIndexOutOfBoundException
 

Checked Vs Unchecked:
IOException - compiler forces us to handle (checked),
NullPointerException, IllegalArgumentException - our bug, runtime (unchecked)

try-with-resources: Auto closes Closeable things. No more finally { close() } leaks

