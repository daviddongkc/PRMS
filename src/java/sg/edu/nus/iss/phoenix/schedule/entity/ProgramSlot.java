package sg.edu.nus.iss.phoenix.schedule.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;


public class ProgramSlot implements Cloneable, Serializable {
    
    /* Persistent Instance variables. This data is directly 
    * mapped to the columns of database table.
    */
    private String name;
    private String radioprogram;
    private String presenterid;
    private String producerid;
    private Date startdate;
    private Time starttime;
    private Time duration;
/** 
     * Constructors. 
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ProgramSlot () {

    }

    public ProgramSlot (String nameIn) {

          this.name = nameIn;

    }

    public ProgramSlot (String nameIn,
          String radioprogramIn, String presenteridIn, String produceridIn,
          Date startdateIn, Time starttimeIn, Time durationIn) {
          this.name = nameIn;
          this.radioprogram = radioprogramIn;
          this.presenterid = presenteridIn;
          this.producerid = produceridIn;
          this.startdate = startdateIn;
          this.starttime = starttimeIn;
          this.duration = durationIn;
    }



    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     * @return 
     */

    public String getName() {
          return this.name;
    }
    public void setName(String nameIn) {
          this.name = nameIn;
    }

    public String getRadioprogram() {
          return this.radioprogram;
    }
    public void setRadioprogram(String radioprogramIn) {
          this.radioprogram = radioprogramIn;
    }

    public String getPresenterid() {
          return this.presenterid;
    }
    public void setPresenterid(String presenteridIn) {
          this.presenterid = presenteridIn;
    }
    
    public String getProducerid() {
          return this.producerid;
    }
    public void setProducerid(String produceridIn) {
          this.producerid = produceridIn;
    }
    
    public Date getStartdate() {
          return this.startdate;
    }
    public void setStartdate(Date startdateIn) {
          this.startdate = startdateIn;
    }

    public Time getStarttime() {
          return this.starttime;
    }
    public void setStarttime(Time starttimeIn) {
          this.starttime = starttimeIn;
    }
    
    public Time getDuration() {
          return this.duration;
    }
    public void setDuration(Time durationIn) {
          this.duration = durationIn;
    }
    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variables, without going trough the 
     * individual set-methods.
     * @param nameIn
     * @param radioprogramIn
     * @param startdateIn
     */

    public void setAll(String nameIn,
          String radioprogramIn, String presenteridIn, String produceridIn,
          Date startdateIn, Time starttimeIn, Time durationIn) {
          this.name = nameIn;
          this.radioprogram = radioprogramIn;
          this.presenterid = presenteridIn;
          this.producerid = produceridIn;
          this.startdate = startdateIn;
          this.starttime = starttimeIn;
          this.duration = durationIn;
    }


    /** 
     * hasEqualMapping-method will compare two RadioProgram instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     * @param valueObject
     * @return 
     */
    public boolean hasEqualMapping(ProgramSlot valueObject) {

          if (this.name == null) {
                    if (valueObject.getName() != null)
                           return(false);
          } else if (!this.name.equals(valueObject.getName())) {
                    return(false);
          }
          if (this.radioprogram == null) {
                    if (valueObject.getRadioprogram() != null)
                           return(false);
          } else if (!this.radioprogram.equals(valueObject.getRadioprogram())) {
                    return(false);
          }
          if (this.presenterid == null) {
                    if (valueObject.getPresenterid() != null)
                           return(false);
          } else if (!this.presenterid.equals(valueObject.getPresenterid())) {
                    return(false);
          }
          
          if (this.producerid == null) {
                    if (valueObject.getProducerid() != null)
                           return(false);
          } else if (!this.producerid.equals(valueObject.getProducerid())) {
                    return(false);
          }
          
          if (this.startdate == null) {
                    if (valueObject.getStartdate() != null)
                           return(false);
          } else if (!this.startdate.equals(valueObject.getStartdate())) {
                    return(false);
          }
          
          if (this.starttime == null) {
                    if (valueObject.getStarttime() != null)
                           return(false);
          } else if (!this.starttime.equals(valueObject.getStarttime())) {
                    return(false);
          }
          
          if (this.duration == null) {
                    if (valueObject.getDuration() != null)
                           return(false);
          } else if (!this.duration.equals(valueObject.getDuration())) {
                    return(false);
          }


          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in text log.
     */
        @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("\nProgramSlot class, mapping to table radio-program\n");
        out.append("Persistent attributes: \n"); 
        out.append("name = ").append(this.name).append("\n"); 
        out.append("radioprogram = ").append(this.radioprogram).append("\n"); 
        out.append("presenterid = ").append(this.presenterid).append("\n"); 
        out.append("producerid = ").append(this.producerid).append("\n"); 
        out.append("startdate = ").append(this.startdate).append("\n"); 
        out.append("starttime = ").append(this.starttime).append("\n"); 
        out.append("duration = ").append(this.duration).append("\n");
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the returned cloned object
     * will also have all its attributes cloned.
     * @return 
     * @throws java.lang.CloneNotSupportedException 
     */
        @Override
    public Object clone() throws CloneNotSupportedException {
        ProgramSlot cloned = new ProgramSlot();

        if (this.name != null)
             cloned.setName(this.name); 
        if (this.radioprogram != null)
             cloned.setRadioprogram(this.radioprogram); 
        if (this.presenterid != null)
             cloned.setPresenterid(this.presenterid); 
        if (this.producerid != null)
             cloned.setProducerid(this.producerid); 
        if (this.startdate != null)
             cloned.setStartdate((Date)this.startdate.clone()); 
        if (this.starttime != null)
             cloned.setStarttime((Time)this.starttime.clone()); 
        if (this.duration != null)
             cloned.setDuration((Time)this.duration.clone()); 
        return cloned;
    }



}
