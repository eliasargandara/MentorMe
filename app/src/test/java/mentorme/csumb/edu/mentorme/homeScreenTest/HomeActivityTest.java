package mentorme.csumb.edu.mentorme.homeScreenTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import mentorme.csumb.edu.mentorme.homeScreen.HomeActivity;

import static junit.framework.Assert.assertNotNull;

/**
 * Unit tests to test {@Link HomeActivity} functionality.
 */
@RunWith(RobolectricTestRunner.class)
public class HomeActivityTest {

    private HomeActivity mHomeActivity;

    @Before
    public void setUp() {
        mHomeActivity = Robolectric.buildActivity(HomeActivity.class).get();
    }

    @Test
    public void onCreate_shouldInitializeHomeActivity() {
        assertNotNull(mHomeActivity);
    }
}
