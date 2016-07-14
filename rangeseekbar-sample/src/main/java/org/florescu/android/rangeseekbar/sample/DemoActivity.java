/*
Copyright 2015 Alex Florescu
Copyright 2014 Yahoo Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.florescu.android.rangeseekbar.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.florescu.android.rangeseekbar.RangeBar;

public class DemoActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Setup the new range seek bar
        RangeBar<Integer> rangeBar = new RangeBar<Integer>(this);
        // Set the range
        rangeBar.setRangeValues(15, 90);
        rangeBar.setSelectedMinValue(20);
        rangeBar.setSelectedMaxValue(88);
        rangeBar.setHintFormat("%s USD");
        //rangeSeekBar.setBarThickness(10);
        rangeBar.setCornersRadius(5);

        // Add to layout
        LinearLayout layout = (LinearLayout) findViewById(R.id.seekbar_placeholder);
        layout.addView(rangeBar);

        // Seek bar for which we will set text color in code
        RangeBar rangeBarTextColorWithCode = (RangeBar) findViewById(R.id.rangeSeekBarTextColorWithCode);
        rangeBarTextColorWithCode.setTextAboveThumbsColorResource(android.R.color.holo_blue_bright);
    }
}
