package util.controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class AxisButton extends Button {

    Joystick j;
    int a;

    public AxisButton(Joystick joystick, int axis) {
        j = joystick;
        a = axis;
    }

    @Override
    public boolean get() {
        return j.getRawAxis(a) > 0.15;
    }
}