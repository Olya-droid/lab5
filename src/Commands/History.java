package Commands;

public class History {
    static String description ="history: вывести последние 13 команд (без их аргументов)";
    static final int n = 12;
    static String [] historyArray = new String[n];
public static void history (){
    for (int i = n-1; i>=0; i--) { if (historyArray[i] != null) System.out.println("   "+ (i+1) + "   " + historyArray[i]);}
}
public static void addInArray (String s1){
        for (int i = n-1; i>0; i--) {
            historyArray[i]=historyArray[i-1];
        }
        historyArray[0] = s1;
    }
}
