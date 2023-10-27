
package repository;

import DataAccess.ManagerDao;
import java.util.List;


public class ManagerRepository implements IManagerRepository{

    @Override
    public void display(List<Integer> kl) {
        ManagerDao.Instance().display(kl);
    }
    
}
