import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GFG {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int t= scan.nextInt();
        while(t-->0){
            String s=scan.next();
            Pattern p=Pattern.compile("^([a-zA-Z]+[a-zA-Z0-9@#%&?]+[a-zA-Z]).{10,}$");
            Matcher d1=p.matcher(s);
            boolean d=d1.matches();
//            if(s.length()<10)System.out.println("NO");
            System.out.println(d?"YES":"NO");
            
        }
    }
}
