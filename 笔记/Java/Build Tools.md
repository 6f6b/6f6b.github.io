#Installation And Usage of Build Tools

### 一、maven

##### Install maven

Maven is downloadable as a zip file at https://maven.apache.org/download.cgi. Only the binaries are required, so look for the link to apache-maven-*{version}*-bin.zip or apache-maven-*{version}*-bin.tar.gz.

Once you have downloaded the zip file, unzip it to your computer. Then add the *bin* folder to your path.

To test the Maven installation, run `mvn` from the command-line:

```
mvn -v
```

##### Usage

1. pom.xml

   > Project Object Model

### 二、gradle

##### Install Gradle

Now that you have a project that you can build with Gradle, you can install Gradle.

It’s highly recommended to use an installer:

- [SDKMAN](https://sdkman.io/)
- [Homebrew](https://brew.sh/) (brew install gradle)

As a last resort, if neither of these tools suit your needs, you can download the binaries from https://www.gradle.org/downloads. Only the binaries are required, so look for the link to gradle-*version*-bin.zip. (You can also choose gradle-*version*-all.zip to get the sources and documentation as well as the binaries.)

Unzip the file to your computer, and add the bin folder to your path.

To test the Gradle installation, run Gradle from the command-line:

```
gradle
```

