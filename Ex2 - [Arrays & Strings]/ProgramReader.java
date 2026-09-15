package EX2;
import java.util.*;
import java.util.regex.*;

//-----------------------------
// Class: StringOperations
// Purpose: Perform different operations on a given Java source code
//-----------------------------
class StringOperations 
{
    // Original Java source code entered by user
    final private String sourceCode;

    // List to hold tokens (words/symbols) from source code
    final private List<String> tokenList;

    // Set of Java reserved keywords
    private final Set<String> javaKeywords = new HashSet<>(Arrays.asList(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch",
        "char", "class", "const", "continue", "default", "do", "double", "else",
        "enum", "extends", "final", "finally", "float", "for", "goto", "if",
        "implements", "import", "instanceof", "int", "interface", "long", "native",
        "new", "package", "private", "protected", "public", "return", "short",
        "static", "strictfp", "super", "switch", "synchronized", "this", "throw",
        "throws", "transient", "try", "void", "volatile", "while"
    ));

    // Constructor: stores input Java code
    public StringOperations(String input) 
    {
        this.sourceCode = input;
        this.tokenList = new ArrayList<>();
    }

    // Run all operations one by one
    public void runAll() 
    {
        splitIntoTokens();
        displaySortedKeywords();
        changePublicToPrivate();
        tweakIntAndClassName();
        inspectPrintlnWord();
        showTokenCount();
    }

    //-----------------------------
    // a) Split source code into tokens
    //-----------------------------
    private void splitIntoTokens() 
    {
        // Using StringTokenizer with delimiters
        StringTokenizer tokenizer = new StringTokenizer(
            sourceCode, " \t\n\r\f{}();.,[]=\"", false
        );

        // Store each token into tokenList
        while (tokenizer.hasMoreTokens()) 
        {
            tokenList.add(tokenizer.nextToken());
        }
    }

    //-----------------------------
    // b) Display all keywords found in sorted order
    //-----------------------------
    private void displaySortedKeywords() 
    {
        List<String> found = new ArrayList<>();
        for (String word : tokenList) 
        {
            if (javaKeywords.contains(word)) 
            {
                found.add(word);
            }
        }

        Collections.sort(found);
        System.out.println("\na) Keywords found (sorted):");
        for (String keyword : found) 
        {
            System.out.print(keyword + " ");
        }
        System.out.println("\n"); 
    }

    //-----------------------------
    // c) Replace 'public' with 'private'
    //-----------------------------
    private void changePublicToPrivate() 
    {
        String updated = sourceCode.replaceAll("\\bpublic\\b", "private");
        System.out.println("b) After changing 'public' to 'private':\n" + updated);
    }

    //-----------------------------
    // d) Replace 'int' with 'INT' and make class name lowercase
    //-----------------------------
    private void tweakIntAndClassName() 
    {
        // Replace all "int" with "INT"
        String updated = sourceCode.replaceAll("\\bint\\b", "INT");

        // Find class name using regex and change it to lowercase
        Pattern p = Pattern.compile("class\\s+(\\w+)");
        Matcher m = p.matcher(updated);
        if (m.find()) 
        {
            String cls = m.group(1);  // extract class name
            updated = updated.replaceAll("\\b" + cls + "\\b", cls.toLowerCase());
        }

        System.out.println("\nc) After changing 'int' to 'INT' and class name to lowercase:\n" + updated);
    }

    //-----------------------------
    // e) Inspect word "println"
    //-----------------------------
    private void inspectPrintlnWord() 
    {
        String word = "println";
        int pos = word.indexOf('l');         // index of first 'l'
        String sub = word.substring(0, 5);   // substring "print"
        System.out.println("\nd) Index of 'l' in 'println': " + pos);
        System.out.println("   Substring 'print' from 'println': " + sub);
    }

    //-----------------------------
    // f) Show total number of tokens
    //-----------------------------
    private void showTokenCount()
    {
        System.out.println("\ne) Total tokens counted: " + tokenList.size());
    }
}


//-----------------------------
// Class: ProgramReader (Driver Class)
// Purpose: Read Java code from user input and call StringOperations
//-----------------------------
public class ProgramReader 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            StringBuilder inputCode = new StringBuilder();
        
            System.out.println("Enter your Java code (type END to finish):");
            
            // Read lines of code until user types "END"
            while (true) 
            {
                String line = sc.nextLine();
                if (line.equals("END")) break;
                inputCode.append(line).append("\n");
            }
        
            // Store input in String and pass to StringOperations
            String finalCode = inputCode.toString();
            StringOperations analyzer = new StringOperations(finalCode);
            
            // Perform all analysis
            analyzer.runAll();
        } // Scanner auto-closed here
    }
}