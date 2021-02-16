package com.company;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EventObjectTest {
    //private static EmployeeOrganizer employeeOrganizer;
    private EventObject eventObject;

    @Test
    @DisplayName("should create event")
    public void ShouldCreateEvent(){
        eventObject.AddEvent("Gebeya","gebeya developer conference","94688");
//        eventObject.AddEvent("Gebeya","gebeya developer conference","94688");
        //validate the expected output with the actual output of the test
        assertEquals(1, eventObject.getListOfEvents().size());
    }

    //assumptions are preconditions that needed to be satisfied to run subsequent assertions in test
    @Test
    @DisplayName("assumption")
    public void AssumptionTest(){
        eventObject.AddEvent("Gebeya","gebeya developer conference","94678");

        //validate that the provided assumption is true
        //throws testAborted exception if assumption is not satisfied
        Assumptions.assumeTrue(eventObject.getListOfEvents().get(0).getEventName()=="Gebeya");
        System.out.println("Assumption passed Successfully!");
    }
    @BeforeAll
    @DisplayName("Before All")
    public static void BeforeAll(){
        System.out.println("Should be printed before all tests");
    }
    @BeforeEach
    @DisplayName("Before Each")
    public void BeforeEach(){
        eventObject = new EventObject();
        System.out.println("Instantiating EventObject before Each test");
    }
    @AfterEach
    @DisplayName("After Each")
    public void AfterEach(){
        System.out.println("This Should be printed After each test");
    }



    @AfterAll
    @DisplayName("After All")
    public static void AfterAll(){
        System.out.println("this should be printed after all test");
    }


    @DisplayName("event Unique id should match the required Format")
    //parameterizedTest allows developers to run same test multiple times with different argument(just only changing argument)
    @ParameterizedTest
    //valueSource allows passing of different values form of array
    @ValueSource(strings = {"56789", "67890", "67898"})
    public void ParameterizedTest(String eventID) {
        eventObject.AddEvent("event1","event description",eventID);
    }


    @DisplayName("Repeat Event Creation Test 5 Times")
    //this allow us to repeat test by specified number of times
    @RepeatedTest(3)
    public void RepeatedTestEventObject() {
        eventObject.AddEvent("new event", "new event description", "12345");
    }

    //The ExecutionCondition extension API allows developers to enable or disable tests based on certain conditions programmatically
    @Test
    @EnabledOnOs(value = {OS.WINDOWS,OS.MAC, OS.LINUX})
    public void EnabledOnOs(){
        eventObject.AddEvent("Gebeya","gebeya developer conference","94678");

        //validate that the provided assumption is true
        //throws testAborted exception if assumption is not satisfied
        Assumptions.assumeTrue(eventObject.getListOfEvents().get(0).getEventName()=="Gebeya");
        System.out.println("Assumption passed Successfully!");
    }
    @Test
    @DisabledOnOs(value = OS.LINUX)
    public void DisabledOnOs(){
        eventObject.AddEvent("Gebeya","gebeya developer conference","94678");

        //validate that the provided assumption is true
        //throws testAborted exception if assumption is not satisfied
        Assumptions.assumeTrue(eventObject.getListOfEvents().get(0).getEventName()=="Gebeya");
        System.out.println("Assumption passed Successfully!");
    }

    @Test
    @Order(1)
    void executeFirst(){
        System.out.println("executeFirst");
    }
    @Test
    @Order(2)
    void executeSecond(){
        System.out.println("executeSecond");
    }
    @Test
    @Order(3)
    void executeLast(){
        System.out.println("executeLast");
    }


    @TestFactory
    public Collection<DynamicTest> dynamicEventTest(){
        ArrayList<ArrayList<String>> inputs = new ArrayList<>();
        ArrayList<String> first = new ArrayList<>();
        first.add("Gebeya");
        first.add("somethin");
        first.add("88744");
        ArrayList<String> second = new  ArrayList<>();
        second.add("Gebeya");
        second.add("somethin");
        second.add("88474");
        ArrayList<String> third= new ArrayList<>();
        third.add("Gebeya");
        third.add("somethin");
        third.add("88474");
        inputs.add((ArrayList<String>) first);
        inputs.add((ArrayList<String>) second);
        inputs.add((ArrayList<String>) third);

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i=0; i< inputs.size(); i++){
            ArrayList<String> input = inputs.get(i);
            EventObject e = new EventObject();

            e.AddEvent(input.get(0), input.get(1),input.get(2));
            DynamicTest dynamicTest = DynamicTest.dynamicTest("Dynamic test for Event: input - "+input,() ->{
                assertEquals(input.get(2), e.getListOfEvents().get(0).getEventUniqueId());
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }




}