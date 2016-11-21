package edu.galileo.android.facebookrecipes.libs;

import org.junit.Test;
import org.mockito.Mock;

import edu.galileo.android.facebookrecipes.BaseTest;

import static org.mockito.Mockito.verify;

/**
 * Created by Alvaro on 20-11-2016.
 */
public class GreenRobotEventBusTest extends BaseTest {

    private GreenRobotEventBus greenRobotEventBus;

    @Mock
    org.greenrobot.eventbus.EventBus eventBus;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        greenRobotEventBus = new GreenRobotEventBus(eventBus);
    }

    @Test
    public void testRegister() throws Exception {
        String test = "";
        greenRobotEventBus.register(test);
        verify(eventBus).register(test);
    }

    @Test
    public void testUnregister() throws Exception {
        String test = "";
        greenRobotEventBus.unregister(test);
        verify(eventBus).unregister(test);
    }

    @Test
    public void testPost() throws Exception {
        String event = "";
        greenRobotEventBus.post(event);
        verify(eventBus).post(event);
    }
}
