<h1>Class Assignment 5</h1>

---

<h2>Part 1</h2>

For part 1 of ca5, I was asked to implement a simple pipeline of my version of the gradle-basic-demo, 
developed in ca2-part1, using Jenkins. This pipeline should include the following stages: 
1. <strong>Checkout</strong> the code from the repository; 
2. <strong>Assemble</strong> the archive files of the application;
3. <strong>Test</strong> the code base;
4. <strong>Archive</strong> the assembled files in Jenkins.

After following the tutorial provided with the class assignment on how to install Jenkins, 
I first created ```Jenkinsfile``` in the ```CA2/part1``` directory with the following script, 

```
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out...'
                git 'https://github.com/Filipe-A-Cruz/devops-23-24-JPE-PSM-1231828'
            }
        }
        stage('Assemble') {
            steps {
                dir('CA2/part1') {
                   echo 'Assembling...'
                   sh 'chmod u+x gradlew'
                   sh './gradlew clean assemble'
                }
            }
        }
        stage('Test') {
            steps {
                dir('CA2/part1') {
                    echo 'Testing...'
                    sh 'chmod u+x gradlew'
                    sh './gradlew test'
                }
            }
        }
        stage('Archive') {
            steps {
                dir('CA2/part1') {
                    echo 'Archiving...'
                    archiveArtifacts 'build/distributions/*'
                }
            }
        }
    }
}
```

I opted for a declarative pipeline. Since the command ```$ cd``` is not support in Groovy, 
the steps in the stages Assemble, Test and Archive are ran inside a 
```dir('CA2/part1') {...}``` step. As requested, the Assemble stage does not use the
```build``` task.

Next I created a new job in Jenkins, named ca5-part1, with the following configuration, 

```
...
Pipeline
    Definition: Pipeline script from SCM
        SCM: Git
            Repositories:
                Repository URL: https://github.com/Filipe-A-Cruz/devops-23-24-JPE-PSM-1231828
                Credentials: - none -
            Branches to build:
                Branch Specifier (blank for 'any'): */master
            Repository Browser: (Auto)
        Script Path: CA2/part1/Jenkinsfile
        Lightweight checkout enabled.
```

Credentials were not required, the visibility of my repository has been 
set to public since ca3-part2, since the prompt for a password breaks the 
provision script in Vagrantfile.

Below is a screenshot showing the results of the job.

![alt text](jenkins-part1.png "Title")

As a side note, the default branch in my DevOps repository was named "main" instead of 
"master", which broke the job regardless of the parameters inserted in the 
```Branch Specifier``` pipeline field. It appears Jenkins assumes the default branch 
is named "master". I changed the default branch name in the repository accordingly.

---

<h2>Part 2</h2>

[placeholder]
