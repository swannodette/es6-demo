# Running It

```
mvn -q dependency:build-classpath -Dmdep.outputFile=classpath.txt
rlwrap java -cp `cat classpath.txt` clojure.main ./script/figwheel.clj
```