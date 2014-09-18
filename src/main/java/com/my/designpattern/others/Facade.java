package com.my.designpattern.others;

class Scanner {
	public void scan() {
		System.out.println("Lexical analysis");
	}
}

class Parser {
	public void parse() {
		System.out.println("Syntax analysis");
	}
}

class IntermediateCode {
	public void genCode() {
		System.out.println("Generate intermediate code");
	}
}

class MachineCode {
	public void genCode() {
		System.out.println("Generate machine code");
	}
}

class Compiler{
	
	private Scanner scanner;
	private Parser parser;
	private IntermediateCode inCode;
	private MachineCode mCode;
	
	public Compiler(){
		scanner = new Scanner();
		parser = new Parser();
		inCode = new IntermediateCode();
		mCode = new MachineCode();
	}
	
	public void Run(){
		scanner.scan();
		parser.parse();
		inCode.genCode();
		mCode.genCode();
	}
}

public class Facade {

	public static void main(String[] args){
		Compiler compiler = new Compiler();
		compiler.Run();
	}
}
