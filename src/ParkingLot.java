enum VehicleType{
    SMALL,
    MEDIUM,
    LARGE
}

enum PaymentStatus{
    PROCESSING,
    DONE,
    CANCELLED,
    FAILED,
    REFUNDED
}

enum ParkingSlotStatus{
    ENGAGED,
    FREE
}

enum WorkerShift{
    NIGHT,
    DAY
}

class ParkingSlot{
    VehicleType vehicleTypeItCanHold;
    ParkingSlotStatus parkingSlotStatus=ParkingSlotStatus.FREE;
    Vehicle vehicle=null;
    ParkingSlot(Vehicle vehicle,ParkingSlotStatus parkingSlotStatus,VehicleType vehicleType){
        this.vehicle=vehicle;
        this.parkingSlotStatus=parkingSlotStatus;
        this.vehicleTypeItCanHold=vehicleType;
    }
}

class Vehicle{
    int licenseNumber;
    VehicleType vehicleType;
    int numberOfHoursAtParking;
    int entryTime=0,exitTime=0;

    public Vehicle(int licenseNumber, VehicleType vehicleType, int numberOfHoursAtParking, int entryTime, int exitTime) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.numberOfHoursAtParking = numberOfHoursAtParking;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

}

class Worker{
    String name;
    int id;
    WorkerShift workerShift;

    public Worker(String name, int id, WorkerShift workerShift) {
        this.name = name;
        this.id = id;
        this.workerShift = workerShift;
    }
}

class WorkerAtGate extends Worker{
    public WorkerAtGate(String name, int id, WorkerShift workerShift) {
        super(name, id, workerShift);
    }

    public void CarChecking(Vehicle vehicle,int id){

    }


}

public class ParkingLot {

}
