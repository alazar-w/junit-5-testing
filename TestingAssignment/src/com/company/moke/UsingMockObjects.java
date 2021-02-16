package com.company.moke;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UsingMockObjects {
    @Mock
    Database databaseMock;
    @Test
    public void  testQuery(){
        assertNotNull(databaseMock);
        when(databaseMock.isAvailable()).thenReturn(true);
        Service studentService= new Service(databaseMock);
       Student student= studentService.addStudents(new Student(
                "jj","james",23,"Software"
        ));
       boolean check=studentService.query("* from t");
       System.out.println(check);
       assertTrue(check);
        assertEquals("jj james",student.getFullName() );
    }
}