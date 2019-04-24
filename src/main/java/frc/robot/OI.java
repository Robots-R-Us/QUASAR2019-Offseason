/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//#region Imports
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.arms.ToggleArms;
import frc.robot.commands.climber.FrontClimb;
import frc.robot.commands.climber.RearClimb;
import frc.robot.commands.elevator.MoveDown;
import frc.robot.commands.elevator.MoveUp;
import frc.robot.commands.rearhatch.ForceClose;
import frc.robot.commands.rearhatch.SendOut;
import frc.robot.commands.vision.AssistedDriving;
import frc.robot.commands.vision.ToggleVisionAssist;
import util.Utilities;
import util.controls.AxisButton;
//#endregion

public class OI {

  //#region OI Declarations
  private Joystick driver = new Joystick(Constants.DRIVER_CONTROLLER);
  private Joystick operator = new Joystick(Constants.OPERATOR_CONTROLLER);

  private Button driver_A = new JoystickButton(driver, Constants.A_BUTTON);
  private Button driver_X = new JoystickButton(driver, Constants.X_BUTTON);
  private Button driver_START = new JoystickButton(driver, Constants.START_BUTTON);
  private Button driver_RS_PUSH = new JoystickButton(driver, Constants.RS_PUSH);

  private Button driver_LeftTrigger = new JoystickButton(driver, Constants.LEFT_TRIGGER);
  private Button driver_RightTrigger = new AxisButton(driver, Constants.RIGHT_TRIGGER);

  private Button operator_LeftTrigger = new AxisButton(operator, Constants.LEFT_TRIGGER);
  private Button operator_RightTrigger = new AxisButton(operator, Constants.RIGHT_TRIGGER);
  //#endregion

  //#region OI Constructor
  /*  Reminder:
   *  Driver LEFT SHOULDER & Driver SELECT are
   *  already in use by the robotdrive command
   *  Check the command code for more info
   * 
   *  Operator A,B,Y,X are also elevator presets
   */
  public OI() {
    driver_A.whileHeld(new MoveDown());
    driver_X.whileHeld(new MoveUp());
    driver_START.whenPressed(new ToggleVisionAssist());
    driver_RS_PUSH.whenPressed(new AssistedDriving());

    driver_LeftTrigger.whenPressed(new SendOut());
    driver_LeftTrigger.whenReleased(new ForceClose());

    driver_RightTrigger.whenPressed(new ToggleArms());

    operator_LeftTrigger.whenPressed(new RearClimb());
    operator_RightTrigger.whenPressed(new FrontClimb());

    if(getOperatorButton(Constants.A_BUTTON)) {
      QUASAR.current_preset = Constants.PRESET_HATCH_LOW;
    } else if(getOperatorButton(Constants.B_BUTTON)) {
      QUASAR.current_preset = Constants.PRESET_HATCH_MED;
    } else if(getOperatorButton(Constants.Y_BUTTON)) {
      QUASAR.current_preset = Constants.PRESET_HATCH_HIGH;
    } else if(getOperatorButton(Constants.X_BUTTON)) {
      QUASAR.current_preset = Constants.PRESET_BALL_LOW;
    }

    populateDashboard();
  }
  //#endregion

  //#region OI Functions
  private void populateDashboard() {

    SmartDashboard.putNumber("Elevator Position", QUASAR.elevator.getPosition());
    SmartDashboard.putString("Elevator Preset", parseElevatorPosition());

  }

  private String parseElevatorPosition() {

    String toReturn = "NOT SET";

    if(Utilities.within(QUASAR.current_preset, Constants.PRESET_HATCH_LOW-100, Constants.PRESET_HATCH_LOW+100))
      toReturn = "LOW HATCH";
    else if(Utilities.within(QUASAR.current_preset, Constants.PRESET_HATCH_MED-100, Constants.PRESET_HATCH_MED+100))
      toReturn = "MED HATCH";
    else if(Utilities.within(QUASAR.current_preset, Constants.PRESET_HATCH_HIGH-100, Constants.PRESET_HATCH_HIGH+100))
      toReturn = "HI HATCH";
    else if(Utilities.within(QUASAR.current_preset, Constants.PRESET_BALL_LOW-100, Constants.PRESET_BALL_LOW+100))
      toReturn = "LOW CARGO";

    return toReturn;
  }

  public double getDriverAxis(int axis) {
    return driver.getRawAxis(axis);
  }

  public double getOperatorAxis(int axis) {
    return operator.getRawAxis(axis);
  }

  public boolean getOperatorButton(int button) {
    return operator.getRawButton(button);
  }

  public boolean getDriverButton(int button) {
    return driver.getRawButton(button);
  }
  //#endregion
}
