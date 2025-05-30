package model;

public class MainTestFile {
    public static void main(String[] args) {


        TestFile testFile = new TestFile();
        testFile.readCSV();
        testFile.createSQLQuery();
 //       System.out.println(testFile.replaceQuotation("I Don't Care (wit'h Justin Bieber)"));
    }
}
