package org.frou.service;

import org.junit.Before;
import org.junit.Test;

public class SetupServiceTest {

    private SetupService service;

    @Before
    public void init() {
        service = new SetupService();
    }

    @Test
    public void testStartSetup() throws Exception {
        service.startSetup();
    }
}