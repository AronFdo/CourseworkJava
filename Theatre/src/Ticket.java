public class Ticket {
    private static int row;
    private static int seat;
    private static double price;
    private static Person person;

    public Ticket(int row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public static int getRow(){
        return row;
    }
    public static int getSeat(){
        return seat;
    }
    public static double getPrice(){
        return price;
    }
    public Person getPerson() {
        return person;
    }

    public void print(){
        System.out.println("Name : "+ getPerson().getName());
        System.out.println("Surname : "+ getPerson().getSurname());
        System.out.println("Row no : "+ getRow());
        System.out.println("Seat no : "+ getSeat());
        System.out.println("Price : "+ getPrice());
        System.out.println();

    }
}
