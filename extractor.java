package exercice;
import java.util.*;
public class extractor {
    public static void main(String[] args){

        String email;
        String site;
        String word;
        int Index1;
        int Index2;
        int choiche;
        Scanner scanner = new Scanner(System.in);



        System.out.println("**************************************************");
        System.out.println("*       Welcome to the extractor tool v1.02       *"); //fixed infinite do while loop
        System.out.println("**************************************************");
        System.out.println("*Please enter your Email/Site to extract the name*");
        System.out.println("**************************************************");
        word = scanner.nextLine();

        word = word.trim();



        if(word.contains("@") && word.contains("//")){
            System.out.println("Did you enetr a site or an email ?");
            System.out.println("Type 0 for email or 1 for site.");

            do{
                choiche = scanner.nextInt();
            }while(choiche != 1 && choiche !=0);

            if(choiche == 0){
                email = word;
                Index1 = email.indexOf("@");
                Index2 = email.indexOf(".");
                ProcessEmail(email, Index1, Index2);
            }
            else if(choiche == 1){
                site = word;
                Index1 = site.indexOf("//");
                Index2 = site.indexOf(".");
                ProcessSites(site, Index1, Index2);
            }

        }

        else if(word.contains("@")){
            email = word;
            Index1 = email.indexOf("@");
            Index2 = email.indexOf(".");
            ProcessEmail(email, Index1, Index2);
        }

        else if(word.contains("//")){
            site = word;
            Index1 = site.indexOf("//");
            Index2 = site.indexOf(".");
            ProcessSites(site, Index1, Index2);
        }

        else{
            System.out.println("Error...");
        }



    }

    static void ProcessEmail(String email, int Index1, int Index2){
        String user;
        String domain;

        user = email.substring(0, Index1);
        domain = email.substring(Index1, Index2);
        System.out.printf("Username is %s and the domain is: %s" ,user ,domain);
    }

    static void ProcessSites(String site, int Index1, int Index2){
        String Name;
        Name = site.substring(Index1 + 2 , Index2); //fixed showing the name with //

        System.out.printf("The site's name is: %s" ,Name);
    }
}
