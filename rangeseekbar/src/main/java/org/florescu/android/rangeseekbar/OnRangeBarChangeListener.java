package org.florescu.android.rangeseekbar;

/**
 * Created by Krzysztof on 22.07.2016.
 */

/**
 * Callback listener interface to notify about changed range values.
 *
 * @param <T> The Number type the RangeSeekBar has been declared with.
 * @author Stephan Tittel (stephan.tittel@kom.tu-darmstadt.de)
 */
public interface OnRangeBarChangeListener <T extends Number> {
    void onRangeBarValuesChanged(RangeBar<T> bar, T minValue, T maxValue);
}
