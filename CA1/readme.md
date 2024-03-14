<h1>Class Assignment 1</h1>

---

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

---

<h2>Part 2</h2>
The modifications needed to add support for the email field were similar to those of part 1, as evidenced by the successful addition:

```console
$ curl -X POST localhost:8080/api/employees -d "{\"firstName\": \"Bilbo\", \"lastName\": \"Baggins\", \"description\": \"burglar\", \"jobTitle\": \"adventurer\", \"jobYears\": \"100\", \"email\": \"bilbo.baggins@theshire.com\"}" -H "Content-Type:application/json"
```

As requested, the work leading to the addition of the email field was done on branch email-field, which was later merged with main and deleted.
Same for the branch fix-invalid-email, although I was unable to add the required validation of the email.
I modified the constructor of class Employee to throw an exception should any of the arguments be invalid, however Spring seems to ignore this exception and proceeds with the creation of Employee objects.
I made further attempts to enforce this validation using annotations and bean validation, but I got stuck on where and how to configure beans.

The tag v1.3.0 was added after the addition of support for the email field, and the tag v1.3.1 was added after the attempted enforcement of argument validation.

The repository was marked with tag ca1-part2.

---

<h2>Alternative Solution</h2>
Mercurial SCM is a distributed version control solution, available for Linux, Windows and MacOS.
Most commands and features are similar to those of Git.

1. [Downloading Mercurial SCM](#tag1)
2. [Configuring username and email](#tag2)
3. [Creating a repository](#tag3)
   1. [Cloning a repository](#tag3.1)
   2. [Self-publishing](#tag3.2)
4. [Adding files to the staging area and committing](#tag4)
5. [Pushing and pulling](#tag5)
6. [Branching](#tag6)
7. [Tagging](#tag7)

<br/>

<strong>1. Downloading Mercurial SCM:</strong> <a id="tag1"></a>

The .msi installer is available on the main page of the Mercurial project website, https://www.mercurial-scm.org/.
This will install TortoiseHg on your system, which also comes with a GUI, although this tutorial will use the command line interface.
Other releases are listed on the downloads section of the website, https://www.mercurial-scm.org/downloads.

<br/>

<strong>2. Configuring username and email:</strong> <a id="tag2"></a>

```console
$ hg config --edit
```

This will open mercurial.txt.
You will need to configure your username and email before committing to a remote repository.

<br/>

<strong>3. Creating a repository:</strong> <a id="tag3"></a>

```console
$ hg init <project-directory>
```

Or simply run ```$ hg init``` from within your project directory.

<br/>

<strong>3.1. Cloning a repository:</strong> <a id="tag3.1"></a>

Alternatively, if you'd like to clone an existing repository,

```console
$ hg clone <project-URL>
```

For example, run ```$ hg clone https://www.mercurial-scm.org/repo/hello``` to clone Mercurial's default sample repository.
A number of websites support hosting of Mercurial repositories, see https://wiki.mercurial-scm.org/MercurialHosting for a complete list.
You'll need to create an account on the appropriate website to access these repositories.
For repositories with access control, the admin of the repository will have to grant you appropriate permissions.
Once this is done, if you'd like to clone e.g. a SourgeForge repository,

```console
$ hg clone ssh://<username>@hg.code.sf.net/p/<projectname>/<repository>
```

The default repository name on SourceForge is "code". Alternatively, using https,

```console
$ hg clone https://<username>@hg.code.sf.net/p/<projectname>/<repository>
```

Either way, you'll be asked for your password.

<br/>

<strong>3.2. Self-publishing:</strong> <a id="tag3.2"></a>

Mercurial comes packaged with an instant-webserver, allowing you to self-publish your local repository.

```console
$ hg serve
```

This will create a web version of your local repository, which you can view on http://127.0.0.1:8000.
You may share this repository using http://<your-IP>:8000.

<br/>

<strong>4. Adding files to the staging area and committing:</strong> <a id="tag4"></a>

Create a demo file in your local repository. For example,

```console
$ hg echo 'print("Hello World!")' > hello.py
```

You can check that the file has not been added to the staging area.

```console
$ hg status
? hello.py
```

The status command on Mercurial serves a similar purpose the status command on Git, however the output is more concise.
Add the newly created file to the staging area,

```console
$ hg add hello.py
$ hg status
A hello.py
```

Commit the staged file,

```console
$ hg commit -m "Demo commit."
$ hg log
changeset:   1:cac89e495d57
tag:         tip
user:        Filipe Cruz <filipeacruz@outlook.com>
date:        Thu Mar 14 17:10:03 2024 +0000
summary:     Demo commit.
```

The log command will show you an abbreviated commit history.

<br/>

<strong>5. Pushing and pulling:</strong> <a id="tag5"></a>

To push changes, specify the appropriate URL.

```console
$ hg push https://example.com
```

Alternatively, you may predefine a number of remote URLs in the .hg/hgrc configuration file, located in your local repository (you may need to create this file, or copy it from the sample repository mentioned earlier).

```console
[paths]
default = https://defaultExample.com
remote1 = https://example1.com
remote2 = https://example2.com
```

To push to the default remote repository,

```console
$ hg push
```

Alternatively, to push to remote2,

```console
$ hg push remote2
```

Pulling follows a similar logic, you may either specify the URL or predefine a set of remote repositories.
For example, to pull from remote1,

```console
$ hg pull remote1
```

<br/>

<strong>6. Branching:</strong> <a id="tag6"></a>

To create a branch,

```console
$ hg branch <branch-name>
```

Mercurial will automatically switch the working directory to the new branch.
Once you've made and committed some changes, you can return to the default branch and merge,

```console
$ hg update default
$ hg merge <branch-name>
$ hg commit -m "Merge new branch."
```

The ```$ hg update``` command is analogous to ```$ git checkout```.
Note that the "base" branch is named default in Mercurial, not main or master.

Branches cannot be completely deleted in Mercurial.
Whereas in Git a branch is a pointer, in Mercurial a branch is a changeset.
However, branches can be closed,

```console
$ hg commit --close-branch
```

To see the list of open branches,
```console
$ hg branches
```

<br/>

<strong>7. Tagging:</strong> <a id="tag7"></a>

Mercurial allows to you associate tags with a specific commit, even years into the future.
Recall the command used to check the commit history,

```console
$ hg log
...
changeset:   2:313317f70d52
branch:      newfeature
user:        Filipe Cruz <filipeacruz@outlook.com>
date:        Thu Mar 14 17:33:47 2024 +0000
summary:     branch test
...
```

Each commit has a corresponding changeset, designated by a number:hashcode.
To add a tag to changeset 2,

```console
$ hg tag -r 2 v1.0
$ hg tags
tip                               11:f8f1bb601f08
v1.0                               2:313317f70d52
```

```$ hg tags``` shows all tags.
The tag <em>tip</em> marks the most recent changeset.
The newly created tag will now appear in the log,

```console
$ hg log
...
changeset:   2:313317f70d52
branch:      newfeature
tag:         v1.0
user:        Filipe Cruz <filipeacruz@outlook.com>
date:        Thu Mar 14 17:33:47 2024 +0000
summary:     branch test
...
```

Tags may be deleted,

```console
$ hg tag --remove v1.0
``` 

or overwritten, 

```console
$ hg tag -r 2 -f v1.0
```

Additionally, tags allow the developer to return to the tagged version of the project and work from there,

```console
$ hg update v1.0
```

Tags are automatically committed but need to be pushed, pulled or merged by the user.
The standard commands ```$ hg push```, ```$ hg pull``` and ```$ hg merge <branch-name>``` will accomplish this.

---
