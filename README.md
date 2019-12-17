# AmountConverter
Amount converter from decimal to text

== Compilation and installation of the AmountConverter application ==


1. GO to the src directory and launch the source compilation
`javac ./com/exercice/converters/*.java ./com/exercice/converters/exceptions/*.java ./com/exercice/*.java`

2. Lauch the packaging :
`jar cmvf META-INF/MANIFEST.MF entretien-exercice.jar ./com/exercice/converters/*.class ./com/exercice/converters/exceptions/*.class ./com/exercice/*.class`

3. Execute the application and admire the result :
`java -cp entretien-exercice.jar com.exercice.AmountConverter 42

Input number is : [42]
Processing...
==========
Result : forty-two
==========
`