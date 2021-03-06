package jp.promin.chike.android.chikedentaku.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

import jp.promin.chike.android.chikedentaku.R;

public final class FunctionButton extends Button {

    final FunctionButtonType buttonType;

    public FunctionButton(Context context) {
        this(context, null);
    }

    public FunctionButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.functionButtonStyle);
    }

    public FunctionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.FunctionButton,
                defStyleAttr, 0);
        if (typedArray.hasValue(R.styleable.FunctionButton_type)) {
            final int type = typedArray.getInt(R.styleable.FunctionButton_type, 0);
            buttonType = FunctionButtonType.getType(type);
        } else {
            buttonType = FunctionButtonType.UNKNOWN;
        }

        setText(buttonType.getName());

        typedArray.recycle();
    }

    public FunctionButtonType getButtonType() {
        return buttonType;
    }
}
