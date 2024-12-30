package Assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student oneStudent = new Student();

        //System.out.println(oneStudent.toString());

        System.out.print("Email: ");
        String loginEmail = scanner.nextLine();
        System.out.print("Password: ");
        String loginPassword = scanner.nextLine();

        int status = oneStudent.login(loginEmail, loginPassword);
        System.out.println(status);            
        
        if(status == 1){
            System.out.printf("\n\n\nWelcome %s !\n", oneStudent.getName());

            System.out.printf("Student Portal\n");
            System.out.printf("---------------\n");
            System.out.printf("1. Academic Page\n");
            System.out.printf("2. Co-curriculum Page\n");
            System.out.printf("Selection: ");

            if(scanner.hasNextInt()){ // Check validation first before getting the int
                int input = scanner.nextInt();
                scanner.nextLine(); // Clear the selection input

                switch(input){
                    case 1: 
                        // Goes to Academic Page
                        System.out.printf("Academic Page\n");
                        
                        break;
                    case 2: 
                        //Goes to Cocu Page
                        System.out.printf("Co-curriculum Page\n");
                        String badanNo= oneStudent.getCocuNo().get(0);
                        String societyNo= oneStudent.getCocuNo().get(1);
                        String sportNo= oneStudent.getCocuNo().get(2);
                        String badanName= "";
                        String societyName= "";
                        String sportName= "";
                            try{
                                File cocu= new File("ClubSocieties.txt"); //read file from club text
                                Scanner fileReader= new Scanner(cocu);
                                while (fileReader.hasNextLine()){
                                    String line= fileReader.nextLine();
                                    String [] Clubs= line.split(",");
                                    if (Clubs[0].equals(societyNo)){
                                        societyName=Clubs[1];
                                    }
                                    if (Clubs[0].equals(badanNo)){
                                        badanName=Clubs[1];
                                    }
                                    if (Clubs[0].equals(sportNo)){
                                        sportName=Clubs[1];
                                    }
                                }
                                fileReader.close();
                            }catch (FileNotFoundException e){
                                System.out.println("An error occurred");
                                e.printStackTrace();
                            }
                        System.out.println("Your Cocurricular Clubs:"); //Generate Cocu Page
                        String line= "=";
                        System.out.println(line.repeat(50));
                        System.out.printf("%-13s %4s - %-20s\n","Societies:",societyNo,societyName);
                        System.out.printf("%-13s %4s - %-20s\n","Uniform Body:",badanNo,badanName);
                        System.out.printf("%-13s %4s - %-20s\n","Sports Club:",sportNo,sportName);
                        System.out.println(line.repeat(50));
                        System.out.print("Generate Transcript? (Press 1 for Yes, 0 for No)");
                        if (scanner.hasNextInt()){
                            int generate= scanner.nextInt();
                            scanner.nextLine();
                            switch(generate){
                                case 1:
                                    System.out.println("Wiiren next");
                                    break;
                                case 0:
                                    System.out.println("Back to home page");
                                    break;
                                default:
                                    System.out.println("\nInvalid");
                                    break;
                            }
                        }
                        break;

                    default: 
                        System.out.println("\n\nInvalid");
                        break;
                }

            }else{
                System.out.printf("Please enter a valid integer. ");
                scanner.next(); // Clear the invalid input
            }
        scanner.close();
        }
        
        
    }
    
}
