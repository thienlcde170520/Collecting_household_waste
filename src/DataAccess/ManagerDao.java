
package DataAccess;

import common.Library;
import java.util.List;


public class ManagerDao {
    private Library l;
    public ManagerDao(){
    l = new Library();
    }
    private static ManagerDao instance = null;
    public static ManagerDao Instance(){
        if(instance == null){
            synchronized (ManagerDao.class){
                if(instance == null){
                    instance = new  ManagerDao();
                }
            }
        }
        return instance;
    }
    
     public void getGarbage(List<Integer> kl) {
        int n = l.getIntInput("How many location you want to input: ");
        int i = 0;
        while (i < n) {
            int input = l.getIntInput("Enter the amount of garbage at each station(in kg): ");
            kl.add(input);
            i++;
        }

    }

    public float calculator(List<Integer> kl) {
        int totalGarbage = 0;
        int time = 0;
        int count = 1;
        for (int i = 0; i < kl.size(); i++) {
            time += 8;
            if ((totalGarbage + kl.get(i)) >= 10000) {
                time += 30;
                totalGarbage = 0;
                count++;
            }
            totalGarbage += kl.get(i);

        }
        if (totalGarbage > 0) {
            time += 30;
        }
        float time1 = (float) time / 60;
        float totalCost = (time1 * 120000) + (57000 * count);
        return totalCost;
    }
    
    public void display(List<Integer> kl) {
        while (true) {
            getGarbage(kl);
            float a = calculator(kl);
            System.out.println("The total cost: " + a + "VND");
            if (!l.checkInputYN("Do you want to continue(Y/N)?: ")) {
                return;
            }
        }
    }
}
