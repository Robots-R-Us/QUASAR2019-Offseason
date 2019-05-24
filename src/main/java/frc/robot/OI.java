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
import frc.robot.commands.elevator.MoveToPreset;
import frc.robot.commands.elevator.MoveUp;
import frc.robot.commands.rearhatch.ForceClose;
import frc.robot.commands.rearhatch.SendOut;
import frc.robot.commands.rearhatch.SendOutHeld;
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

  private Button driver_RightTrigger = new AxisButton(driver, Constants.RIGHT_TRIGGER);

  private Button operator_LeftTrigger = new AxisButton(operator, Constants.LEFT_TRIGGER);
  private Button operator_RightTrigger = new AxisButton(operator, Constants.RIGHT_TRIGGER);

  private Button operator_LeftShoulder = new JoystickButton(operator, Constants.LEFT_SHOULDER);
  private Button operator_RightShoulder = new JoystickButton(operator, Constants.RIGHT_SHOULDER);

  private Button operator_START = new JoystickButton(operator, Constants.START_BUTTON);

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

    driver_X.whileHeld(new MoveUp());
    driver_A.whileHeld(new MoveDown());
    operator_START.whenPressed(new MoveToPreset());

    driver_START.whenPressed(new ToggleVisionAssist());
    driver_RS_PUSH.whenPressed(new AssistedDriving());

    operator_LeftShoulder.whenPressed(new SendOut());
    operator_LeftShoulder.whenReleased(new ForceClose());
    operator_RightShoulder.whenPressed(new SendOutHeld());
    operator_RightShoulder.whenReleased(new ForceClose());

    driver_RightTrigger.whenPressed(new ToggleArms());

    operator_LeftTrigger.whenPressed(new RearClimb());
    operator_RightTrigger.whenPressed(new FrontClimb());
    
    populateDashboard();

  }
  //#endregion

  //#region OI Functions
  public void populateDashboard() {
    SmartDashboard.putString("Approx. Position", parseElevatorPosition());
    SmartDashboard.putNumber("Elevator Position", QUASAR.elevator.getPosition());
    SmartDashboard.putNumber("Desired Value", QUASAR.current_preset);
    SmartDashboard.putBoolean("Elevator Switch", QUASAR.sensors.getElevatorSwitch());
    SmartDashboard.putBoolean("Hatch Switch", QUASAR.sensors.getHatchSwitch());
  }

  public void updateCurrentPreset() {
    if(getOperatorButton(Constants.A_BUTTON)) {
      QUASAR.current_preset = Constants.PRESET_HATCH_LOW;
    } else if(getOperatorButton(Constants.B_BUTTON)) {
      QUASAR.current_preset = Constants.PRESET_HATCH_MED;
    } else if(getOperatorButton(Constants.Y_BUTTON)) {
      QUASAR.current_preset = Constants.PRESET_HATCH_HIGH;
    } else if(getOperatorButton(Constants.X_BUTTON)) {
      QUASAR.current_preset = Constants.PRESET_BALL_LOW;
    }
  }

  private String parseElevatorPosition() {
    String toReturn = "UNKNOWN";
    if(Utilities.within(QUASAR.elevator.getPosition(), Constants.PRESET_HATCH_LOW-100, Constants.PRESET_HATCH_LOW+100))
      toReturn = "LOW HATCH";
    else if(Utilities.within(QUASAR.elevator.getPosition(), Constants.PRESET_HATCH_MED-100, Constants.PRESET_HATCH_MED+100))
      toReturn = "MED HATCH";
    else if(Utilities.within(QUASAR.elevator.getPosition(), Constants.PRESET_HATCH_HIGH-100, Constants.PRESET_HATCH_HIGH+100))
      toReturn = "HI HATCH";
    else if(Utilities.within(QUASAR.elevator.getPosition(), Constants.PRESET_BALL_LOW-100, Constants.PRESET_BALL_LOW+100))
      toReturn = "LOW CARGO";
    else if(Utilities.within(QUASAR.elevator.getPosition(), Constants.PRESET_BALL_MED-100, Constants.PRESET_BALL_MED+100))
      toReturn = "MED CARGO";
    else if(Utilities.within(QUASAR.elevator.getPosition(), Constants.PRESET_BALL_HIGH-100, Constants.PRESET_BALL_HIGH+100))
      toReturn = "HI CARGO";
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
