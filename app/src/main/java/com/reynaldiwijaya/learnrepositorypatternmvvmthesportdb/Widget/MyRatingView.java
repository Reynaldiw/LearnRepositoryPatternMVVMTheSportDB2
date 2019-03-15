package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.R;

public class MyRatingView extends LinearLayout {

    public MyRatingView(Context context) {
        super(context);
        init(context, null);
    }

    public MyRatingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyRatingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyRatingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private boolean ratingOngoing = false;
    private Context mContext;
    private int numStars = 5;
    private int mRating = 0;

    //mengkonfigurasi atribut yang sudah kita buat selain itu juga untuk mengkonfigurasi
    //orientasi dan gravity untuk view nya.
    private void init(Context context, AttributeSet set) {
        this.mContext = context;

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

        final TypedArray styleAttributesArray = context.obtainStyledAttributes(set, R.styleable.MyRatingView);
        numStars = styleAttributesArray.getInteger(R.styleable.MyRatingView_numStars, numStars);
        mRating = styleAttributesArray.getInteger(R.styleable.MyRatingView_rating, mRating);

        styleAttributesArray.recycle();

        addRatingStars();
        updateViewAfterRatingChanged(mRating-1);
    }

    private CheckBox getRatingView() {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CheckBox checkBox = (CheckBox) inflater.inflate(R.layout.rating_star_item, this, false);
        checkBox.setId(getChildCount());
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);

        return checkBox;
    }

    //method ini
    //berfungsi untuk memasukan item - item view nya kedalam kelas parent nya
    private void addRatingStars() {
        if (numStars != 0) {
            for (int i = 0; i < numStars; i++) {
                addView(getRatingView());
            }
        }
    }

    //method ini berfungsi
    //untuk menyimpan nilai untuk kondisi view ketika rating di klik
    private void updateViewAfterRatingChanged(int checkedPosition) {
        this.mRating = checkedPosition + 1;
        ratingOngoing = true;
        if (checkedPosition < getChildCount()) {
            for (int i = 0; i < getChildCount(); i++) {
                ((CheckBox) getChildAt(i)).setChecked(i <= checkedPosition);
            }
        }
        ratingOngoing = false;
    }

    private final CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (ratingOngoing) {
                return;
            }
            if (buttonView.getId() >= 0 && buttonView.getId() <= getChildCount() - 1) {
                updateViewAfterRatingChanged(buttonView.getId());

            }
        }
    };

}
