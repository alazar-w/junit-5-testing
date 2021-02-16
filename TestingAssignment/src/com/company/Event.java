package com.company;

public class Event {
    private String eventName;
    private  String eventDescription;
    private  String eventUniqueId;


    Event(String eventName, String eventDescription, String eventUniqueId){
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventUniqueId = eventUniqueId;
    }
    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventUniqueId() {
        return eventUniqueId;
    }

    public void setEventUniqueId(String eventUniqueId) {
        this.eventUniqueId = eventUniqueId;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public void ValidateEventName(){
        if(this.eventName == null){
            throw new RuntimeException("EventName can not be null");
        }
    }
    public void ValidateEventDescription(){
        if(this.eventDescription == null){
            throw new RuntimeException("EventDescription can not be null");
        }
    }
    public void ValidateEventUniqueID(){
        if(this.eventUniqueId.length() != 5){
            throw new RuntimeException("event unique id should be 5 character!");
        }
        if (!this.eventUniqueId.matches("[0-9]+")){
            throw new RuntimeException("Event Unique id should Contain only digits");
        }

    }

}
