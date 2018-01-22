package jp.promin.chike.android.chikedentaku.ui;

import android.databinding.ObservableField;
import android.databinding.ObservableLong;
import android.view.View;

import jp.promin.chike.android.chikedentaku.ui.view.FunctionButtonType;

public final class MainActivityViewModel {
    public interface Listener {
        void onClickKey(View view);
    }

    private ObservableLong calcValue = new ObservableLong(0);
    private ObservableField<String> currentOperation = new ObservableField<>("");

    void setCalcValue(long calcValue) {
        this.calcValue.set(calcValue);
    }

    public ObservableLong getCalcValue() {
        return calcValue;
    }
    public ObservableField<String> getCurrentOperation() {
        return currentOperation;
    }

    // Operation
    boolean inputValue(long value) {
        final long result = getCalcValue().get() * 10 + value;
        if (isValidCalculation(value, result)) {
            setCalcValue(result);
            return true;
        }
        return false;
    }

    private boolean isValidCalculation(final long value, final long resultValue) {
        final boolean addOps = value > -1 && getCalcValue().get() > -1;
        if (addOps && 0 > resultValue) return false;

        final boolean subOps = 0 > value && 0 > getCalcValue().get();
        return !(subOps && resultValue > -1);
    }

    boolean doFunction(FunctionButtonType type) {
        final long currentValue = getCalcValue().get();
        switch (type) {
            case NUM_DELETE:
                setCalcValue(Math.round(currentValue / 10));
                break;
            case NUM_00:
                if (currentValue != 0) {
                    setCalcValue(currentValue * 100);
                }
                break;
            case CANCEL_ALL:
                setCalcValue(0);
                break;

            case OP_ADD:
                currentOperation.set(type.getName());
                return true;

            case OP_SUB:
                currentOperation.set(type.getName());
                return true;

            case OP_MULTIPLE:
                currentOperation.set(type.getName());
                return true;

            case OP_DIVISION:
                currentOperation.set(type.getName());
                return true;
        }
        currentOperation.set("");
        return true;
    }
}
