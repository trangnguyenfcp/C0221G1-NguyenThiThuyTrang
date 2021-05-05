package FuramaResort.models;

public class Villa extends Services{
    private String standardOfRoom;
    private String descriptionOtherAmenities;
    private double swimmingPoolArea;
    private int numberOfFloors;
    public Villa(){
    }
    public Villa(String id, String service, Double usableArea, long rentalCost, int maximumInHouse, String rentalPeriod, String standardOfRoom, String descriptionOtherAmenities, double swimmingPoolArea, int numberOfFloors) {
        super(id, service, usableArea, rentalCost, maximumInHouse, rentalPeriod);
        this.standardOfRoom = standardOfRoom;
        this.descriptionOtherAmenities = descriptionOtherAmenities;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardOfRoom() {
        return standardOfRoom;
    }

    public void setStandardOfRoom(String standardOfRoom) {
        this.standardOfRoom = standardOfRoom;
    }

    public String getDescriptionOtherAmenities() {
        return descriptionOtherAmenities;
    }

    public void setDescriptionOtherAmenities(String descriptionOtherAmenities) {
        this.descriptionOtherAmenities = descriptionOtherAmenities;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
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
    public double getRentalCost() {
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
        return "Villa{" +
                "id='" + this.getId()+ '\'' +
                ", service='" + this.getService()+ '\'' +
                ", usableArea=" + this.getUsableArea() +
                ", rentalCost=" + this.getRentalCost() +
                ", maximumInHouse=" + this.getMaximumInHouse() +
                ", rentalPeriod='" + this.getRentalPeriod() + '\'' +
                "standardOfRoom='" + standardOfRoom + '\'' +
                ", descriptionOtherAmenities='" + descriptionOtherAmenities + '\'' +
                ", swimmingPoolArea='" + swimmingPoolArea + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
