package Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Student {
    private String name;
    private String email;
    private String matrixNo;
    private String password;
    private ArrayList<String> academicSubjects = new ArrayList<String>();
    private ArrayList<String> cocuNo = new ArrayList<String>();

    // Constructor
    public Student(){
        this(" ", " ", " ", " ");
    }
    public Student(String name, String email, String matrixNo, String password){
        this.name = name;
        this.email = email;
        this.matrixNo = matrixNo;
        this.password = password;
    }


    // Getter
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getMatrixNo(){
        return matrixNo;
    }
    public String getPassword(){
        return password;
    }
    public String getStudentSubjectName(){
        return academicSubjects.toString();
    }
    public ArrayList<String> getCocuNo(){
        return cocuNo;
    }


    // Setter
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setMatrixNo(String matrixNo){
        this.matrixNo = matrixNo;
    }
    public void setPassword(String password){
        this.password = password;
    }


    // Method
    public String toString(){
        return name + " is using email: " + email;
    }

    public int login(String loginEmail, String loginPassword){
        int found = 0;
        int status = 0;


        try{
            File myObj = new File("UserData.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine() && found == 0) {

                email = myReader.nextLine();
                matrixNo = myReader.nextLine();
                password = myReader.nextLine();
                
                academicSubjects.clear();
                String line = myReader.nextLine();
                String[] data = line.split(",");
                for (String subjectNo : data) {
                    academicSubjects.add(subjectNo);
                }
                
                cocuNo.clear();
                line = myReader.nextLine();
                data = line.split(",");
                for (String cocu : data) {
                    cocuNo.add(cocu);
                }


                if(loginEmail.equals(email)){
                    found = 1;
                    if(loginPassword.equals(password)){
                        status = 1;
                        System.out.println("Login successful");
                    }else{
                        status = 0;
                        System.out.println("Incorrect user / password");
                    }
                }
                if (myReader.hasNextLine()){
                    myReader.nextLine();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }


        return status;
    }
    
}
