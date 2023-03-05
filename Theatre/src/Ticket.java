public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(int row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public int getRow(){
        return row;
    }
    public int getSeat(){
        return seat;
    }
    public double getPrice(){
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
