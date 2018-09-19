package sg.edu.nus.iss.phoenix.schedule.restful;

import java.util.List;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

public class ProgramSlots {
    private List <ProgramSlot> psList;

    public List<ProgramSlot> getPsList() {
        return psList;
    }
 
    public void setPsList(List<ProgramSlot> psList) {
        this.psList = psList;
    }
    
}
