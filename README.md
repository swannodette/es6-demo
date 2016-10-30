# Running It

Checkout ClojureScript master, switch into the repo and run:

```
./script/build
```

Take note of the version number. Edit the ClojureScript dependency in *this*
project's pom.xml to match.

From *this* project's repo run:

```
mvn -q dependency:build-classpath -Dmdep.outputFile=classpath.txt
rlwrap java -cp `cat classpath.txt` clojure.main ./script/figwheel.clj
```