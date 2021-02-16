package com.company;

import java.util.ArrayList;
import java.util.List;

public class EventObject {
    List<Event> a = new ArrayList<Event>();
    public void AddEvent(String eventName,String eventDescription,String eventUniqueID){
        Event event = new Event(eventName,eventDescription,eventUniqueID);
        ValidateEvent(event);
        a.add(event);
    }
    private void ValidateEvent(Event event){
        event.ValidateEventName();
        event.ValidateEventDescription();
        event.ValidateEventUniqueID();
    }

    public List<Event> getListOfEvents() {
        return a;
    }
    public boolean checkList(String eventName){
        for (Event i: a) {
            if ( i.getEventName() == eventName){
                return true;
            }
        }
        return false;
    }
}
