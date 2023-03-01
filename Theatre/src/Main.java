import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static int[] row1 = new int[12];
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];

    static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");




        while (true){
            System.out.println("-----------------------------------------------------");
            System.out.println("1) Buy a ticket \n2) Print seating area \n3) Cancel ticket \n4) List available seats \n5) Save to file \n6) Load from file \n7) Print ticket information and total price \n8) Sort tickets by price \n  0) Quit");
            System.out.println("-----------------------------------------------------");
            System.out.print("Enter option: ");
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    show_available();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;
                case 7:
                    show_tickets();
                    break;
                case 0:
                    System.exit(0);
                }
            }



    }
    public static void buy_ticket(){
        System.out.println("Enter row number");
        int row_no = in.nextInt();
        while (row_no > 3 || row_no < 1){
            System.out.println("Please enter the correct row number");
            row_no = in.nextInt();
        }
        System.out.println("Enter seat number");
        int seat_no = in.nextInt();
        double price = 0;
        switch (row_no) {
            case 1:
                    while(seat_no>row1.length || seat_no < 1){
                        System.out.println("Please enter the correct seat number");
                        seat_no = in.nextInt();
                    }
                    row1[seat_no - 1] = 1;
                    price = 30;
                    break;
            case 2:
                while(seat_no>row2.length || seat_no < 1){
                    System.out.println("Please enter the correct seat number");
                    seat_no = in.nextInt();
                }
                    row2[seat_no - 1] = 1;
                    price = 20;
                    break;
            case 3:
                while(seat_no>row3.length || seat_no < 1){
                    System.out.println("Please enter the correct seat number");
                    seat_no = in.nextInt();
                }
                    row3[seat_no - 1] = 1;
                    price = 10;
                    break;
        }
        System.out.println("Enter your first name: ");
        String firstname = in.next();
        System.out.println("Enter your surname: ");
        String lastname = in.next();
        System.out.println("Enter your email: ");
        String email = in.next();

        Random rand = new Random();
        int user_id = rand.nextInt(0,10);
        int ticket_id = rand.nextInt(0,100);

        Person user = new Person(firstname, lastname, email);
        Ticket new_ticket = new Ticket(row_no,seat_no,price, user);
        tickets.add(new_ticket);
        System.out.println(tickets.size());



    }
    public static void print_seating_area(){
        System.out.println("     ***********");
        System.out.println();
        System.out.println("     *  STAGE  *");
        System.out.println();
        System.out.println("     ***********");
        System.out.print("    ");
        for (int i=0; i < (row1.length); i++){
            /*System.out.println(i);*/
            if (i == 6){
                System.out.print(" ");
            }
            if (row1[i] == 0){
                System.out.print('O');
            }
            else {
                System.out.print('X');
            }
        }
        System.out.println();
        System.out.print("  ");
        for (int j=0; j < (row2.length); j++){
            /*System.out.println(j);*/
            if (j == 8){
                System.out.print(" ");
            }
            if (row2[j] == 0){
                System.out.print('O');
            }
            else{
                System.out.print('X');
            }
        }
        System.out.println();
        for (int k=0; k < (row3.length); k++){
            /*System.out.println(k);*/
            if (k == 10){
                System.out.print(" ");
            }
            if (row3[k] == 0){
                System.out.print('O');
            }
            else{
                System.out.print('X');
            }

        }
        System.out.println();
    }

    public static void cancel_ticket(){
        System.out.println("Please enter row number: ");
        int row_cancel = in.nextInt();
        while ( row_cancel > 3 || row_cancel < 1){
            System.out.println("Please enter correct row number");
            row_cancel = in.nextInt();
        }
        System.out.println("Please enter seat number: ");
        int seat_cancel = in.nextInt();

        switch(row_cancel){
            case 1:
                while(seat_cancel > row1.length || seat_cancel < 1){
                    System.out.println("Please enter correct seat number");
                    seat_cancel = in.nextInt();
                }
                row1[seat_cancel-1] = 0;
            case 2:
                while(seat_cancel > row2.length || seat_cancel < 1){
                    System.out.println("Please enter correct seat number");
                    seat_cancel = in.nextInt();
                }
                row2[seat_cancel-1] = 0;
            case 3:
                while(seat_cancel > row3.length || seat_cancel < 1){
                    System.out.println("Please enter correct seat number");
                    seat_cancel = in.nextInt();
                }
                row3[seat_cancel-1] = 0;
        }
    }
    public static void show_available() {
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                System.out.print(" " + (i+1) + ",");
            }
        }
        System.out.println();
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {
                System.out.print(" " + (i+1) + ",");
            }
        }
        System.out.println();
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0) {
                System.out.print(" " + (i+1) + ",");
            }
        }
        System.out.println();
    }
    public static void save(){
        File tickets = new File("C:\\Users\\aronf\\Desktop\\Java\\Project1\\Coursework\\Theatre\\src\\Tickets.txt");
        try{
            FileWriter file_write = new FileWriter(tickets);
            file_write.write("Seats available in row 1: ");
            for (int i=0;i< row1.length;i++){
                if (row1[i] == 0){
                    file_write.write(" "+(i+1)+",");
                }
            }
            file_write.write("\n");
            file_write.write("Seats available in row 2: ");
            for (int i=0;i< row2.length;i++){
                if (row2[i] == 0){
                    file_write.write(" "+(i+1)+",");
                }
            }
            file_write.write("\n");
            file_write.write("Seats available in row 3: ");
            for (int i=0;i< row3.length;i++){
                if (row3[i] == 0){
                    file_write.write(" "+(i+1)+",");
                }
            }
            file_write.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void load(){
        File tickets = new File("C:\\Users\\aronf\\Desktop\\Java\\Project1\\Coursework\\Theatre\\src\\Tickets.txt");
        try{
            Scanner read_file = new Scanner(tickets);
            while (read_file.hasNextLine()){
                String data = read_file.nextLine();
                System.out.println(data);
            }
        }catch (FileNotFoundException e){
            System.out.println("An error occurred");
        }

    }
    public static void show_tickets(){
        for (Ticket ticket : tickets) {
            ticket.print();
        }


    }
}