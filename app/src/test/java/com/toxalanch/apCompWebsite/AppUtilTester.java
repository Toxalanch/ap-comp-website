package com.toxalanch.apCompWebsite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppUtilTester {

    @Test
    void findClass() {
        assertEquals("Hello", AppUtil.findClass("public class Hello {"));
        assertEquals("Hello", AppUtil.findClass("public class Hello{"));
        //TODO assertEquals("Hello", AppUtil.findClass("class Hello{"));    Doesn't currently work, but I need to make it work later
    }
    
}
