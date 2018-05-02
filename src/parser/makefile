all: clean compile-grammar test-contract

compile-grammar:
	antlr4 ContractsToLarva.g4
	javac -cp $CLASSPATH:/usr/share/java/antlr-complete.jar:. *.java

test-contract:
	grun ContractsToLarva s -gui

clean:
	rm -rf *.java *.class *.tokens *.interp
