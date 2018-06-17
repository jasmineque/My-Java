<h1>

```diff

! JAVA BUILDING BLOCKS !
```

</h1>



<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-1.jpg" width="800" ></center>

* `main()` method's parameter list: can write `String[] args`, `String args[]`, or `String…args`
* All command-line arguments are treated as `String` objects

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-2.jpg" width="800"></center>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-3.jpg" width="800"></center>

<h3>

```diff
- Numbering System:
```
</h3>

* Decimal
* Octal, uses the number 0 as a prefix
* Hexadecimal, uses the number 0 followed by x or X as a prefix
* Binary, uses the number 0 followed by b or B as a prefix

**Underscores** can be used in numbers to make them easier to read. They can be added anywhere except:

* at the beginning of a literal, 
* the end of a literal, 
* right before a decimal point, 
* or right after a decimal point.

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-4.jpg" width="800"></center>
<br>

<h3>

```diff
- Key Differences between Object References and Primitives:
```
</h3>

|Object References|Primitives|
|-----------------|----------|
|Can be assigned _null_ (do not currently refer to an object)|Cannot be assigned null (compiler error)|
|Can be used to call _methods_ when they do not point to null|Do not have methods declared on them|
|All classes begin with _uppercase_|All the primitive types have _lowercase_ type names|

<h3>

```diff
- Java Identifiers:
```
</h3>

* Are used for identification purpose
* Can be a class name, method name, variable name, or a label

<h3>

```diff
- Rules for identifiers:
```
</h3>

* The only allowed characters for identifiers are _alphanumeric characters_, _dollar sign_ (\$)$ and _underscore_ (_).
* Identifiers should _not_ start with digits.
* Identifiers are _case-sensitive_.
* _Reserved words_ can't be used as an identifier.


---
<h2>

```diff

! Variables !
```

</h2>


<br>

<h3>

```diff
- Local Variables:
```
</h3>

* is a variable defined within a method. 
* Local variables must be _initialized_ before use.

<h3>

```diff
- Instance and Class Variables:
```
</h3>

* Variables that are not local are known as instance variables or class variables.
* Instance variables are also called fields.
* Class variables are shared across multiple objects. A class variable has the keyword `static` before it.


<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-5.jpg" width="800"></center>

<br>

<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/ClassElements.JPG" width="600"></center>

<span style="color:purple">___PIC (Order) - Package, Import, Class___</span>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-6.jpg" width="600" ></center>

<br>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-7.jpg" width="800"></center>

<br>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-8.jpg" width="600" ></center>

<br>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/C1-9.jpg" width="800"></center>

<br>

<br>
<center><img src="https://raw.githubusercontent.com/jasmineque/My-Java/master/Images/StackHeap.jpg" width="600" ></center>

<br>
