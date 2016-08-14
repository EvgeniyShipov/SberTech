package ru.sbt.hw6;

import org.junit.Test;
import static org.junit.Assert.*;

public class BeanUtilsTest {

    @Test
    public void assignTest1() throws Exception {
        ObjectFrom objectFrom = new ObjectFrom("From", 1);
        ObjectTo objectTo = new ObjectTo("To", 2);
        BeanUtils.assign(objectTo, objectFrom);
        assertEquals(objectFrom.getName(), objectTo.getName());
        assertEquals(objectFrom.getNumber(), objectTo.getNumber());
    }
    
}