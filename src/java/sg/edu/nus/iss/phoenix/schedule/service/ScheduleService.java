package sg.edu.nus.iss.phoenix.schedule.service;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.dao.ScheduleDAO;


public class ScheduleService {
    DAOFactoryImpl factory;
    ScheduleDAO psdao;

    public ScheduleService() {
	super();
	// Sorry. This implementation is wrong. To be fixed.
	factory = new DAOFactoryImpl();
	psdao = factory.getScheduleDAO();
    }
    public ArrayList<ProgramSlot> searchPrograms(ProgramSlot psso) {
	ArrayList<ProgramSlot> list = new ArrayList<ProgramSlot>();
	try {
        	list = (ArrayList<ProgramSlot>) psdao.searchMatching(psso);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
                return list;
	}

	public ArrayList<ProgramSlot> findRPByCriteria(ProgramSlot ps) {
		ArrayList<ProgramSlot> currentList = new ArrayList<ProgramSlot>();

		try {
			currentList = (ArrayList<ProgramSlot>) psdao.searchMatching(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currentList;

	}

	public ProgramSlot findPS(String psName) {
		ProgramSlot currentps = new ProgramSlot();
		currentps.setName(psName);
		try {
			currentps = ((ArrayList<ProgramSlot>) psdao
					.searchMatching(currentps)).get(0);
			return currentps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentps;

	}

	public ArrayList<ProgramSlot> findAllPS() {
		ArrayList<ProgramSlot> currentList = new ArrayList<ProgramSlot>();
		try {
			currentList = (ArrayList<ProgramSlot>) psdao.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentList;

	}
        
	public void processCreate(ProgramSlot ps) {
		try {
			psdao.create(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processModify(ProgramSlot ProgramSlot) {
		
			try {
				psdao.save(ProgramSlot);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void processDelete(String name) {

            try {
                ProgramSlot ps = new ProgramSlot(name);
                psdao.delete(ps);
            } catch (NotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	}

}