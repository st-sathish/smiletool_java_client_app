### First create jar
```shell
mvn clean package
```
## Create exe file
```shell
mvn jpackage:jpackage
```

###### This creates a native .exe or .msi in your target/installer/ directory.

#### Install Wix3 tool
```shell
https://github.com/wixtoolset/wix3/releases
```