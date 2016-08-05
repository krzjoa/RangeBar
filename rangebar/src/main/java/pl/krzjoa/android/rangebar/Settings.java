package pl.krzjoa.android.rangebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


import pl.krzjoa.android.util.PixelUtil;

/**
 * Created by Krzysztof on 22.07.2016.
 */
public class Settings {

    private Context context;
    private AttributeSet attrs;

    // Text settings
    protected boolean showTextAboveThumbs;
    protected int textAboveThumbsColor;
    protected int textOffset;
    protected int textSize;
    protected int distanceToTop;

    protected boolean thumbShadow;
    protected int thumbShadowXOffset;
    protected int thumbShadowYOffset;
    protected int thumbShadowBlur;

    protected boolean activateOnDefaultValues;
    protected int thumbShadowColor;

    //Defaults
    int defaultShadowColor;
    int defaultShadowXOffset;
    int defaultShadowYOffset;
    int defaultShadowBlur;

    //boleans
    protected boolean singleThumb;
    protected boolean showLabels;
    protected boolean alwaysActive;

    //Colors
    protected int activeColor;
    protected int defaultColor;

    //Thumb shadow
    private Path thumbShadowPath;
    private Path translatedThumbShadowPath = new Path();
    private Matrix thumbShadowMatrix = new Matrix();

    // Thumb settings
    protected float thumbHalfWidth;
    protected float thumbHalfHeight;



    public Settings(Context context,@Nullable AttributeSet attrs) {
        this.attrs = attrs;
        this.context = context;
        init();
    }

    private void init() {

       defaultShadowColor = Color.argb(75, 0, 0, 0);
       defaultShadowXOffset = PixelUtil.dpToPx(context, 2);
       defaultShadowYOffset = PixelUtil.dpToPx(context, 0);
       defaultShadowBlur = PixelUtil.dpToPx(context, 2);

        if (attrs == null) {
            textAboveThumbsDefault();
            thumbShadowDefault();
            defaultColors();
            activateOnDefaultValues = false;
            alwaysActive = false;
        } else {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RangeBar, 0, 0);
            try {
              initTextAboveThumsSettings(a);
              initThumbShadowSettings(a);
              booleans(a);
              colors(a);
            } finally {
                a.recycle();
            }
        }
        textDimensions();
    }

    // region text above thumbs

    private void textAboveThumbsDefault(){
        showTextAboveThumbs = true;
        textAboveThumbsColor = Color.WHITE;
    }

    private void initTextAboveThumsSettings(TypedArray a){
        showTextAboveThumbs = a.getBoolean(R.styleable.RangeBar_valuesAboveThumbs, true);
        textAboveThumbsColor = a.getColor(R.styleable.RangeBar_textAboveThumbsColor, Color.WHITE);
    }

    private void textDimensions(){
        textSize = PixelUtil.dpToPx(context, Defaults.DEFAULT_TEXT_SIZE_IN_DP);
        distanceToTop = PixelUtil.dpToPx(context, Defaults.DEFAULT_TEXT_DISTANCE_TO_TOP_IN_DP);
        textOffset = !showTextAboveThumbs ? 0 : this.textSize + PixelUtil.dpToPx(context,
                Defaults.DEFAULT_TEXT_DISTANCE_TO_BUTTON_IN_DP) + this.distanceToTop;
    }


    // endregion text above thumbs

    // region thumb shadow

    private void thumbShadowDefault(){
        thumbShadowColor = defaultShadowColor;
        thumbShadowXOffset = defaultShadowXOffset;
        thumbShadowYOffset = defaultShadowYOffset;
        thumbShadowBlur = defaultShadowBlur;
    }

    private void initThumbShadowSettings(TypedArray a){
        thumbShadow = a.getBoolean(R.styleable.RangeBar_thumbShadow, false);
        thumbShadowColor = a.getColor(R.styleable.RangeBar_thumbShadowColor, defaultShadowColor);
        thumbShadowXOffset = a.getDimensionPixelSize(R.styleable.RangeBar_thumbShadowXOffset, defaultShadowXOffset);
        thumbShadowYOffset = a.getDimensionPixelSize(R.styleable.RangeBar_thumbShadowYOffset, defaultShadowYOffset);
        thumbShadowBlur = a.getDimensionPixelSize(R.styleable.RangeBar_thumbShadowBlur, defaultShadowBlur);
    }

    private void thumbShadowSwithc(){}

    // endregion thumb shadow

    // region booleans

    private void defaultBooleans(){

    }

    private void booleans(TypedArray a){
        singleThumb = a.getBoolean(R.styleable.RangeBar_singleThumb, false);
        showLabels = a.getBoolean(R.styleable.RangeBar_showLabels, true);
        alwaysActive = a.getBoolean(R.styleable.RangeBar_alwaysActive, false);
        activateOnDefaultValues = a.getBoolean(R.styleable.RangeBar_activateOnDefaultValues, false);
    }


    // endregion

    // region colors
    private void defaultColors(){
        activeColor = Defaults.ACTIVE_COLOR;
        defaultColor = Color.GRAY;
    }

    private void colors(TypedArray a){
        activeColor = a.getColor(R.styleable.RangeBar_activeColor, Defaults.ACTIVE_COLOR);
        defaultColor = a.getColor(R.styleable.RangeBar_defaultColor, Color.GRAY);
    }

    // endregion colors

}
