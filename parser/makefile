all: clean compile-grammar test-contract

compile-utils:
	javac ParserUtils/*.java

compile-grammar: compile-utils
	antlr4 ContractsToLarva.g4
	javac -cp /usr/share/java/antlr-complete.jar:. *.java

test-contract: 
	grun ContractsToLarva s -gui

clean:
	rm -rf *.java *.class *.tokens *.interp ParserUtils/*.class
