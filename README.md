# AmountConverter
Amount converter from decimal to text

## Compilation and installation of the AmountConverter application


1. GO to the src directory and launch the source compilation

`javac ./com/exercice/converters/*.java ./com/exercice/converters/exceptions/*.java ./com/exercice/*.java`

2. Lauch the packaging :

`jar cmvf META-INF/MANIFEST.MF entretien-exercice.jar ./com/exercice/converters/*.class ./com/exercice/converters/exceptions/*.class ./com/exercice/*.class`

3. Execute the application and admire the result :

```
java -cp entretien-exercice.jar com.exercice.AmountConverter 42

Input number is : [42]
Processing...
==========
Result : forty-two
==========
```

4. Launch the JUnit tests :

4.1 Download the JUNIT console here : https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.4.2/junit-platform-console-standalone-1.4.2.jar

4.2 Build the packages
`javac -classpath junit-platform-console-standalone-1.4.2.jar ./com/exercice/converters/*.java ./com/exercice/converters/exceptions/*.java ./com/exercice/*.java ./com/exercice/tests/*.java`

4.3 Package :
`jar cmvf META-INF/MANIFEST.MF entretien-exercice-tests.jar ./com/exercice/converters/*.class ./com/exercice/converters/exceptions/*.class ./com/exercice/*.class ./com/exercice/tests/*.class`

4.4 Execute tests:
```
java -cp ./entretien-exercice-tests.jar;junit-platform-console-standalone-1.4.2.jar org.junit.runner.JUnitCore com.exercice.tests.NumberToTextConverterTest
JUnit version 4.12
......
Time: 0,063

OK (6 tests)

```
