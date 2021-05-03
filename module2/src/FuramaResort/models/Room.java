package FuramaResort.models;

public class Room extends Services{
    public String freeService;
    public Room(){

    }
    public Room(String id, String service, Double usableArea, long rentalCost, int maximumInHouse, String rentalPeriod, String freeService){
        super(id, service, usableArea, rentalCost, maximumInHouse, rentalPeriod);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getService() {
        return super.getService();
    }

    @Override
    public void setService(String service) {
        super.setService(service);
    }

    @Override
    public double getUsableArea() {
        return super.getUsableArea();
    }

    @Override
    public void setUsableArea(double usableArea) {
        super.setUsableArea(usableArea);
    }

    @Override
    public long getRentalCost() {
        return super.getRentalCost();
    }

    @Override
    public void setRentalCost(long rentalCost) {
        super.setRentalCost(rentalCost);
    }

    @Override
    public int getMaximumInHouse() {
        return super.getMaximumInHouse();
    }

    @Override
    public void setMaximumInHouse(int maximumInHouse) {
        super.setMaximumInHouse(maximumInHouse);
    }

    @Override
    public String getRentalPeriod() {
        return super.getRentalPeriod();
    }

    @Override
    public void setRentalPeriod(String rentalPeriod) {
        super.setRentalPeriod(rentalPeriod);
    }

    @Override
    public String showInfor() {
        return "Room{" +
                "id='" + this.getId()+ '\'' +
                ", service='" + this.getService()+ '\'' +
                ", usableArea=" + this.getUsableArea() +
                ", rentalCost=" + this.getRentalCost() +
                ", maximumInHouse=" + this.getMaximumInHouse() +
                ", rentalPeriod='" + this.getRentalPeriod() + '\'' +
                "standardOfRoom='" + freeService + '\'' +
                '}';
    }

}
