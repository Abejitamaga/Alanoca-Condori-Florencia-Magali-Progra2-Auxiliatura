public class Main{
    public static void main(String[] args){
      ElectricVehicle myEV = new ElectricVehicle("Tesla", "Model 3", 50000, 75, 500);
      myEV.stard();
      myEV.displayInfo();
      myEV.displayRange();
      myEV.stop();
    }
  }