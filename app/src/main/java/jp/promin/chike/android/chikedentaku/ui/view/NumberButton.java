package jp.promin.chike.android.chikedentaku.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

import jp.promin.chike.android.chikedentaku.R;

public final class NumberButton extends Button {
    private final long number;

    public NumberButton(Context context) {
        this(context, null);
    }

    public NumberButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.numberButtonStyle);
    }

    public NumberButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.NumberButton,
                defStyleAttr, 0);

        number = typedArray.getInteger(R.styleable.NumberButton_number, -1);
        typedArray.recycle();
        setText(String.valueOf(number));
    }

    public long getNumber() {
        return number;
    }
}
