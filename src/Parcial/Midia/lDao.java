package Parcial.Midia;

import java.util.List;

public interface lDao <m>{
	
    void save (m t);
    
    m getOne(int id);
    
    List<m> list();
    
    void update (m t);
    
    void delete(int id);

	void saveVhs(Vhs v);

	void saveCd(Cd cd);


}
