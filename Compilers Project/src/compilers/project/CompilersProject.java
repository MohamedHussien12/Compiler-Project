package compilers.project;

import java.util.regex.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompilersProject {

    
    public static void main(String[] args) {
        
         Scanner();
         
    }
    static String identiferRegularExperssion = "[_][0-9][_a-zA-Z]+";
    static String constant = "[0-9]+";
    static String comment = "[/][*][_a-zA-Z]*";
    static String Output="\'[a-zA-Z]+\'";
    
    static String token;
    static Scanner inputCode;
    static String Filename = "Test.txt";
  
    static List keywords = new ArrayList();
    //static List comment = new ArrayList();
    static List symbols = new ArrayList();
    static List ArithmeticOP = new ArrayList();
    static List logialOP = new ArrayList();
    static List relationalOP = new ArrayList();
    static List AssignOP = new ArrayList();
    static List AccessOP = new ArrayList();
    static List Braces = new ArrayList();
    static List condition = new ArrayList();
    static List integer = new ArrayList();
    static List SInteger = new ArrayList();
    static List Character = new ArrayList();
    static List String = new ArrayList();
    static List Float = new ArrayList();
    static List SFloat = new ArrayList();
    static List Void = new ArrayList();
    static List Loop = new ArrayList();
    static List Return = new ArrayList();
    static List Break = new ArrayList();
    static List Struct = new ArrayList();
    static List Inclusion = new ArrayList();
    static List Start = new ArrayList();
    static List End = new ArrayList();

  
   
    public static void Scanner() {
        
        keywords.add("if");keywords.add("else");keywords.add("elseif");
        keywords.add("for");keywords.add("while");keywords.add("do");
        keywords.add("return");keywords.add("public");keywords.add("privte");
        keywords.add("protect");keywords.add("package");keywords.add("new");
        keywords.add("int");keywords.add("double");keywords.add("float");
        keywords.add("static");keywords.add("const");keywords.add("char");
        keywords.add("goto");keywords.add("boolean");keywords.add("long");
        keywords.add("void");keywords.add("this");keywords.add("try");
        keywords.add("catch");keywords.add("true");keywords.add("print");
        keywords.add("enter");
        
        condition.add("Yesif-Otherwise");
        integer.add("Omw");
        SInteger.add("SIMww");
        Character.add("Chji");
        String.add("Seriestl");
        Float.add("IMwf");
        SFloat.add("SIMwf");
        Void.add("NOReturn");
        Loop.add("RepeatWhen");Loop.add("Reiterate");
        Return.add("GetBack");
        Break.add("OutLoop");
        Struct.add("Loli");
        Inclusion.add("Include");
        Start.add("Start");
        End.add("Last");
        
         
        //comment.add("/*");
        //comment.add("//");
        //comment.add("/^");

        symbols.add("!");symbols.add("&");symbols.add("%");
        symbols.add("$");symbols.add("#");symbols.add("@");symbols.add("?");
        symbols.add(";");symbols.add(":");
        symbols.add("'");
        symbols.add("^");
        
        Braces.add("("); Braces.add("[");
        Braces.add(")"); Braces.add("]");
        Braces.add("{"); 
        Braces.add("}"); 
         
       
        ArithmeticOP.add("+");
        ArithmeticOP.add("-");
        ArithmeticOP.add("*");
        ArithmeticOP.add("/");
       
        logialOP.add("||");
        logialOP.add("~");
        logialOP.add("&&");
        
        relationalOP.add("==");
        relationalOP.add("<=");
        relationalOP.add(">=");
        relationalOP.add(">");
        relationalOP.add("<");
        relationalOP.add("!=");
        relationalOP.add("%");
        
        AssignOP.add("=");
        
        AccessOP.add("->");
        
            
        String tokenCategory;
        int line = 1;
        try {
            inputCode = new Scanner(new File(Filename));
            while (inputCode.hasNext()) {
                token = inputCode.next();
                if (keywords.contains(token)) {
                    tokenCategory = "Keyword";
                } 
                else if (symbols.contains(token)) {
                    tokenCategory = "Symbol";
                }
                else if (integer.contains(token)) {
                    tokenCategory = "Integer";
                }
                else if (SInteger.contains(token)) {
                    tokenCategory = "SInteger";
                }
                else if (Character.contains(token)) {
                    tokenCategory = "Character";
                }
                else if (String.contains(token)) {
                    tokenCategory = "String";
                }
                else if (Float.contains(token)) {
                    tokenCategory = "Float";
                } 
                else if (Void.contains(token)) {
                    tokenCategory = "Void";
                }
                else if (Loop.contains(token)) {
                    tokenCategory = "Loop";
                }
                else if (Return.contains(token)) {
                    tokenCategory = "Return";
                }
                else if (Break.contains(token)) {
                    tokenCategory = "Break";
                }
                else if (Inclusion.contains(token)) {
                    tokenCategory = "Inclusion";
                }
                else if (Start.contains(token)) {
                    tokenCategory = "Start";
                }
                else if (End.contains(token)) {
                    tokenCategory = "Last";
                }
                else if (SFloat.contains(token)) {
                    tokenCategory = "SFloat";
                }         
                else if (Braces.contains(token)) {
                    tokenCategory = "Braces";
                } 
                else if (ArithmeticOP.contains(token)) {
                    tokenCategory = "Arithmetic Operation";
                } 
                else if (logialOP.contains(token)) {
                    tokenCategory = "Logical Operation";
                } 
                else if (Pattern.matches(identiferRegularExperssion, token)) {
                    tokenCategory = "Identifire";
                } 
                /*else if (comment.contains(token)) {
                    tokenCategory = "Comment";
                }*/
                else if (Pattern.matches(comment, token)) {
                    tokenCategory = "Comment";
                }
                else if (Pattern.matches(constant, token)) {
                    tokenCategory = "Constant";
                } 
                else if (condition.contains(token)) {
                    tokenCategory = "Condition";
                } 
                else if (relationalOP.contains(token)) {
                    tokenCategory = "Relational Operation";
                } 
                else if (AssignOP.contains(token)) {
                    tokenCategory = "Assign Operation";
                }
                else if (AccessOP.contains(token)) {
                    tokenCategory = "Access Operation";
                } 
                else if (Pattern.matches(Output, token)) {
                    tokenCategory = "Output to the user";
                }
                else {
                    tokenCategory = "there an error in token !!! in line :" + line;
                }
                System.out.println("<" + token + "," + tokenCategory + ">");
                if (token.endsWith(";")) {
                    line++;
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File code not found !!");
        }
    }
}
