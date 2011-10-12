package gototoday

import grails.test.GrailsUnitTestCase;

public class ConferenceTest extends GrailsUnitTestCase {

    void testUrlTagCanNotBeBlank() {
        def c = new Conference()
        assertFalse(c.validate())
    }
    
    void testUrlTagMayOnlyContainAlphaAndNumbers() {
        def c = new Conference(name: "Århus 2011", urlTag: "??")
        assertFalse("will validate", c.validate())
    }

    void testUrlTagMayContainAlphaNumbersAndDash() {
        def c = new Conference(name: "Århus 2011", urlTag: "aarhus-2011")
        assertTrue(c.validate())
    }

    void testNameMayNotBeBlank() {
        def c = new Conference(name: "", urlTag:"tag")
        assertFalse(c.validate())
    }
}
