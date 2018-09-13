package epi.greedy;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GasupProblem {
    public static final int MILEAGE_PER_GALLON = 20;
    
    public static void main(String[] args) {
        List<Integer> distances = new ArrayList<>(Arrays.asList(900, 600, 200, 400, 600, 200, 100));
        List<Integer> bunksCapacities = new ArrayList<>(Arrays.asList(50, 20, 5, 30, 25, 10, 10));
        System.out.println(getAmpleCityIndx(distances, bunksCapacities));
    }
    
    public static int getAmpleCityIndx(List<Integer> distances, List<Integer> bunksCapacities) {
        
        int minCityIndex = -1;
        int minFuelRemaining = Integer.MAX_VALUE;
        int fuelRemaining = 0;
        
        for (int i = 0; i < distances.size(); i++) {
            fuelRemaining = (fuelRemaining + bunksCapacities.get(i)) - (distances.get(i) /  MILEAGE_PER_GALLON);
            
            if (fuelRemaining < minFuelRemaining) {
                minFuelRemaining = fuelRemaining;
                minCityIndex = i;
            }
        }
        
        return minCityIndex > -1 ? minCityIndex + 1 : minCityIndex;
    }
}
