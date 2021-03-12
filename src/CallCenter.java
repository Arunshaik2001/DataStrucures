import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

enum Rank{
    OPERATORS(10),
    MANAGER(67);

    int x;
    Rank(int c){
        this.x=c;
    }
}

enum CallState{
    READY,
    COMPLETE,
    IN_PROGRESS
}

abstract class Employee{
    String name;
    int id;
    Rank rank;
    boolean canHandle;
    boolean isFree=true;

    Employee(String name,int id,Rank rank,boolean canHandle){
        this.name=name;
        this.id=id;
        this.rank=rank;
        this.canHandle=canHandle;
    }
}

class Customer{
    String name,location;
    int id;
    Customer(String name,String location,int id){
        this.name=name;
        this.location=location;
        this.id=id;
    }
}

class Call{
    int pinNo;
    Customer customer;
    CallState callState;
}

class Operator extends Employee{

    Operator(String name, int id, Rank rank,boolean canHandle) {
        super(name, id, rank,canHandle);
    }
}

class Manager extends Employee{

    Manager(String name, int id, Rank rank) {
        super(name, id, rank,true);
    }
}

public class CallCenter {

    ArrayList<Employee> arrayList=new ArrayList<>(20);
    Queue<Call> callQueue=new LinkedList<>();
    int callsHandled=0;
    public void callComing(Call call){
        callQueue.add(call);
       
        while (!callQueue.isEmpty() && callsHandled<10){
            Call call1=callQueue.poll();
            for (Employee employee:arrayList){
                if (employee.rank== Rank.OPERATORS && employee.isFree){
                    assignCall(call1,employee);
                    break;
                }
            }
        }
    }

    public void assignCall(Call call,Employee employee){
        employee.isFree=false;
        call.callState=CallState.IN_PROGRESS;

    }


    public static void main(String[] args) {

    }
}


