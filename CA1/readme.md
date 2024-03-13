<h1>Class Assignment 1</h1>
<h2>Part 1</h2>

Modification of the app to support the new fields jobTitle and jobYears only required changes to the classes:
1. CA1\basic\src\main\java\com\greglturnquist\payroll\Employee.java
2. CA1\basic\src\main\java\com\greglturnquist\payroll\DatabaseLoader.java
3. CA1\basic\src\main\js\app.js

From the cmd line on windows, I was able to add a new employee with the new fields using:
```console
$ curl -X POST localhost:8080/api/employees -d "{\"firstName\": \"Bilbo\", \"lastName\": \"Baggins\", \"description\": \"burglar\", \"jobTitle\": \"adventurer\", \"jobYears\": \"100\"}" -H "Content-Type:application/json"
```

When checking the information on employees, the newly added employee appears correctly:
```console
$ curl localhost:8080/api/employees
```

Tags were added after cloning the React.js and Spring Data REST tutorial (v1.1.0), after adding support for jobTitle (v1.1.1) and after adding support for jobYears (v1.2.0).
Support for jobTitle was not required by the class assignment, but was listed as a training exercise in DevOps supporting materials.

The repository was marked with tag ca1-part1.

<h2>Part 2</h2>
The modifications needed to add support for the email field were similar to those of part 1, as evidenced by the successful addition:
```console
$ curl -X POST localhost:8080/api/employees -d "{\"firstName\": \"Bilbo\", \"lastName\": \"Baggins\", \"description\": \"burglar\", \"jobTitle\": \"adventurer\", \"jobYears\": \"100\", \"email\": \"bilbo.baggins@theshire.com\"}" -H "Content-Type:application/json"
```


As requested, the work leading to the addition of the email field was done on branch email-field, which was later merged with main.
Same for the branch fix-invalid-email, although I was unable to add the required validation of the email.
I modified the constructor of class Employee to throw an exception should any of the arguments be invalid, however Spring seems to ignore this exception and proceeds with the creation of Employee objects.
I made further attempts to enforce this validation using annotations, bean validation, but I got stuck on where and how to configure beans.

The tag v1.3.0 was added after the addition of support for the email field, and the tag v1.3.1 was added after the attempted enforcement of argument validation.

The repository was marked with tag ca1-part2.

<h2>Alternative Solution</h2>

