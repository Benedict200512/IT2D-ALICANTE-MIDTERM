package it2d.alicante.midterm;
 
import java.util.Scanner;

public class IT2DALICANTEMIDTERM {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        IT2DALICANTEMIDTERM patient = new IT2DALICANTEMIDTERM ();

        switch(action){
            case 1:
                patient.addPatients();           
                break;
            case 2:       
                patient.viewPatients();
                break;
            case 3:
                patient.viewPatients();
                patient.updatePatients();
                patient.viewPatients();
                break;
            case 4:
                patient.viewPatients();
                patient.deletePatients();
                patient.viewPatients();    
                break;
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }
    
    
    public void addPatients(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Date of Birth: ");
        String db = sc.next();
        System.out.print("Contact Number: ");
        String cn = sc.next();
        System.out.print("Address: ");
        String add = sc.next();

        String sql = "INSERT INTO tbl_patient (p_fname, p_lname, p_dateofbirth, p_contactnumber, p_address) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, db, cn, add);


    }

    private void viewPatients() {
        config conf = new config();
        String Query = "SELECT * FROM tbl_patient";
        String[] Headers = {"Patient_ID","FirstName", "LastName", "DateofBirth", "ContactNumber", "Address"};
        String[] Columns = {"p_id", "p_fname", "p_lname", "p_dateofbirth", "p_contactnumber", "p_address"};
        
        
        conf.viewRecords(Query, Headers, Columns);
    }
    private void updatePatients() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the ID to update: ");
        int id = sc.nextInt();
        
        System.out.println("New First Name: ");
        String nfname = sc.next();
        
        System.out.println("New Last Name: ");
        String nlname = sc.next();
        
        System.out.println("New Date of Birth: ");
        String ndb = sc.next();
        
        System.out.println("New Contact Number: ");
        String ncn = sc.next();
        
        System.out.println("New Address: ");
        String nadd = sc.next();
        
        String qry = "UPDATE tbl_patient SET p_fname = ?, p_lname = ?, p_dateofbirth = ?, p_contactnumber = ?, p_address = ? WHERE p_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, ndb, ncn, nadd, id);         
        
        
    }
    
    private void deletePatients() {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter the ID  to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_patient WHERE p_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
    
}
