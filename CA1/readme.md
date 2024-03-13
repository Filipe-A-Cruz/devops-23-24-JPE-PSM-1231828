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
[placeholder]