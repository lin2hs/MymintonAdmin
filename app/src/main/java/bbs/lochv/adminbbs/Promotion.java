package bbs.lochv.adminbbs;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Promotion implements Serializable {

    public String promotionName;
    public String promotionID;
    public List<String> promotionDayInWeek;
    public List<Slot> promotionTimeSlot;
    public String promotionContent;
    //HashMap contains a map of promotion with key is DayInWeek, value is another
    //      HashMap with key is slot which is on sale and their value is discount percentage
    public HashMap<String, HashMap<Slot, String>> promotionProgram;
    public boolean isActivated;

    public Promotion() {
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public List<String> getPromotionDayInWeek() {
        return promotionDayInWeek;
    }

    public void setPromotionDayInWeek(List<String> promotionDayInWeek) {
        this.promotionDayInWeek = promotionDayInWeek;
    }

    public List<Slot> getPromotionTimeSlot() {
        return promotionTimeSlot;
    }

    public void setPromotionTimeSlot(List<Slot> promotionTimeSlot) {
        this.promotionTimeSlot = promotionTimeSlot;
    }

    public String getPromotionContent() {
        return promotionContent;
    }

    public void setPromotionContent(String promotionContent) {
        this.promotionContent = promotionContent;
    }

    public HashMap<String, HashMap<Slot, String>> getPromotionProgram() {
        return promotionProgram;
    }

    public void setPromotionProgram(HashMap<String, HashMap<Slot, String>> promotionProgram) {
        this.promotionProgram = promotionProgram;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }
}
