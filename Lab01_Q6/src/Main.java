//import java.util.*;
// 
//public class Main{
// 
//    public static void main(String [] args) 
//    {   
//        Scanner in = new Scanner(System.in);
//         
//        Customer c1, c2;
//        Shop s1,s2;
//         
//        c1 = new Customer(200);
//        c2 = new Customer(200);
//        s1 = new Shop();
//        s2 = new Shop();
// 
//        s1.earn(c1, 30); //s1 earns and get $30 from c1
//        s2.earn(c1, 40); //s2 earns and get $40 from c1
//        s2.earn(c2, 50); //s2 earns and get $50 from c2
// 
//        System.out.println(c1.getAmount()); //expected output: 130
//        System.out.println(c2.getAmount()); //expected output: 150
//        System.out.println(s1.getProfit()); //expected output: 30
//        System.out.println(s2.getProfit()); //expected output: 90
// 
//        in.close();
//    }
//}
//
//PartB
import java.util.*;

public class Main{
 
    public static void main(String [] args) 
    {   
        Scanner in = new Scanner(System.in);
         
        Customer c1, c2;
        c1 = new Customer(200);
        c2 = new Customer(200);
         
        Group g1 = new Group();
         
        g1.add(c1);
        g1.add(c2);
 
        Shop s1 = new Shop();
        s1.earn(g1, 300); //s1 earns and get totally $300 from the group
        s1.earn(c1, 30);
        System.out.println(s1.getProfit()); //expected output: 330
        System.out.println(c1.getAmount()); //expected output: 20
 
        in.close();
    }
}