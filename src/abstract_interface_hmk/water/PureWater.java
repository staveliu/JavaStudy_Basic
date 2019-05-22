package abstract_interface_hmk.water;

public class PureWater extends Water implements WaterBuffer,WaterFilter,WaterHeating {
    @Override
    public void water() {
        System.out.println("Get water");
    }

    @Override
    public void buffer() {
        System.out.println("Buffing...");
    }

    @Override
    public void filter() {
        System.out.println("Filting...");
    }

    @Override
    public void heating() {
        System.out.println("Heating...");
    }


}
