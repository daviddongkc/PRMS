package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.util.ArrayList;

import sg.edu.nus.iss.phoenix.schedule.entity.PSSearchObject;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.service.ScheduleService;

public class ScheduleDelegate {
    /*	
	public ArrayList<RadioProgram> searchPrograms(RPSearchObject rpso) {
		RadioProgram rp = new RadioProgram(rpso.getName());
		rp.setDescription(rpso.getDescription());
		ProgramService service = new ProgramService();
		return service.searchPrograms(rp);	
	}
	
	public ArrayList<RadioProgram> findRPByCriteria(RPSearchObject rpso) {
		RadioProgram rp = new RadioProgram(rpso.getName());
		rp.setDescription(rpso.getDescription());
		ProgramService service = new ProgramService();
		return service.searchPrograms(rp);	
	}
	
	public RadioProgram findPS(String psName) {
		ProgramSlot ps = new ProgramSlot(psName);
		ScheduleService service = new ScheduleService();
		return (service.searchProgramSlots(ps)).get(0);	
		
	}
    */
	public ArrayList<ProgramSlot> findAllPS() {
		ScheduleService service = new ScheduleService();
		return service.findAllPS();
		
	}
	
	public void processCreate(ProgramSlot ps) {
		ScheduleService service = new ScheduleService();
		service.processCreate(ps);
		
	}
	public void processModify(ProgramSlot ps) {
		ScheduleService service = new ScheduleService();
		service.processModify(ps);
		
	}

	public void processDelete(String name) {
		ScheduleService service = new ScheduleService();
		service.processDelete(name);
	}
}
