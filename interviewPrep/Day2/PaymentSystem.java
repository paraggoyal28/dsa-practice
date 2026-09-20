

interface Payable {
    double getPayment();
}

class Employee implements Payable {
    double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    @Override
    public double getPayment() {
        return salary;
    }
}

class Freelancer implements Payable {
    int hours;
    double rate;

    Freelancer(int hours, double rate) {
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double getPayment() {
        return this.hours * this.rate;
    } 
}

public class PaymentSystem {

    public static void main(String[] args) {
        Payable p1 = new Employee(50000);
        Payable p2 = new Freelancer(20, 1000);

        System.out.println(p1.getPayment());
        System.out.println(p2.getPayment());
    }
}
