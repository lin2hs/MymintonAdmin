package bbs.lochv.adminbbs;

import java.io.Serializable;

public class Slot implements Serializable {

    public String slotID;
    public String slotOfBCourtID;
    public String slotTypeID;
    public String slotStartTime;
    public String slotEndTime;

    public Slot() {
    }

    public Slot(String slotID, String slotOfBCourtID, String slotTypeID, String slotStartTime,
                String slotEndTime) {
        this.slotID = slotID;
        this.slotOfBCourtID = slotOfBCourtID;
        this.slotTypeID = slotTypeID;
        this.slotStartTime = slotStartTime;
        this.slotEndTime = slotEndTime;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public String getSlotOfBCourtID() {
        return slotOfBCourtID;
    }

    public void setSlotOfBCourtID(String slotOfBCourtID) {
        this.slotOfBCourtID = slotOfBCourtID;
    }

    public String getSlotTypeID() {
        return slotTypeID;
    }

    public void setSlotTypeID(String slotTypeID) {
        this.slotTypeID = slotTypeID;
    }

    public String getSlotStartTime() {
        return slotStartTime;
    }

    public void setSlotStartTime(String slotStartTime) {
        this.slotStartTime = slotStartTime;
    }

    public String getSlotEndTime() {
        return slotEndTime;
    }

    public void setSlotEndTime(String slotEndTime) {
        this.slotEndTime = slotEndTime;
    }
}

