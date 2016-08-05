package pl.krzjoa.android.rangebar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RangeBarTest {

    @Test
    public void rsb_should_handle_long_values() {
        RangeBar<Long> mSeekBar = new RangeBar<>(RuntimeEnvironment.application);
        // Set up the seek bar
        mSeekBar.setRangeValues(0L, 100L);
        long minValue = mSeekBar.getAbsoluteMinValue();
        Assert.assertEquals(0L, minValue);
        long maxValue = mSeekBar.getAbsoluteMaxValue();
        Assert.assertEquals(100L, maxValue);
    }

}