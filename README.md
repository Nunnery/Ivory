Ivory is licensed under the MIT License. You may modify, use, and distribute any code from any
"net.nunnerycode" packages, as long as you give credit to Richard Harrah, rmh4209, Nunnery,
or ToppleTheNun.

Ivory contains modified code from mkremins' Fanciful library for Bukkit.

Ivory is formatted after desht's dhutils project.

## Installation
Use Maven. Add the MythicDrops repository and dependency entries to your `pom.xml`.
This library is designed to be shaded into your plugin and used as needed.

```xml
<repository>
  <id>nunnerycode-repo</id>
  <url>http://repository-topplethenun.forge.cloudbees.com/snapshot/</url>
  <snapshots>
    <enabled>true</enabled>
    <updatePolicy>always</updatePolicy>
  </snapshots>
</repository>

<dependency>
  <groupId>net.nunnerycode.bukkit</groupId>
  <artifactId>ivory-lib</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```