Three types or operators: **unary, binary, ternary**.

<h3>

```diff

- Order of operator precedence:

```
</h3>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/OperatorPrecedence.JPG" width = "600" ></center>

The `instanceof` operator is useful for determining whether an arbitrary object is a
member of a particular class or interface.

<h3>

```diff

- Numeric Promotion Rules:

```
</h3>

1. If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
2. If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value’s data type.
3. Smaller data types, namely byte, short, and char, are first promoted to int any time they’re used with a Java binary arithmetic operator, even if neither of the operands is int.
4. After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands.

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-10.jpg" width = "600" ></center>

<h3>

```diff

- instanceof Comparison:

```
</h3>

* used for object reference variables only
* used to check whether an object is of a particular type (class or interface)
* can be used to test an object reference against its own class type or any of its superclasses
* An object is said to be of a particular interface type (meaning it will pass the instanceof test) if any of the object's superclasses implement the interface
* can't be used to test across two different class hierarchies (compilation fails)

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-11.jpg" width = "600" ></center>
<br>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-12.jpg" width = "800" ></center>
<br>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-13.jpg" width = "800" ></center>
