package jp.promin.chike.android.chikedentaku.ui.view;

import android.support.annotation.NonNull;

public enum FunctionButtonType {
    UNKNOWN(-1, "は?"),

    TAX(0, "税込"),
    MEMORY_PLUS(1, "M+"),
    MEMORY_MINUS(2, "M-"),
    MEMORY_CLEAR(3, "MC"),
    NUM_DOT(9, "．"),
    NUM_00(10, "00"),
    NUM_DELETE(11, "DEL"),

    OP_ADD(20, "＋"),
    OP_SUB(21, "－"),
    OP_MULTIPLE(22, "×"),
    OP_DIVISION(23, "÷"),
    OP_EQUAL(24, "＝"),

    CANCEL(30, "C"),
    CANCEL_ALL(31, "CA");
    final int value;
    final String name;

    FunctionButtonType(int value, @NonNull String name) {
        this.value = value;
        this.name = name;
    }

    @NonNull
    public static FunctionButtonType getType(int value) {
        for (FunctionButtonType type : FunctionButtonType.values()) {
            if (type.value == value) return type;
        }
        return FunctionButtonType.UNKNOWN;
    }

    public String getName() {
        return name;
    }
}
