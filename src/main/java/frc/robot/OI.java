/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
import util.controls.AxisButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private Joystick driver = new Joystick(Constants.DRIVER_CONTROLLER);
  private Joystick operator = new Joystick(Constants.OPERATOR_CONTROLLER);

  private Button driver_A = new JoystickButton(driver, Constants.A_BUTTON);
  private Button driver_X = new JoystickButton(driver, Constants.X_BUTTON);
  private Button driver_START = new JoystickButton(driver, Constants.START_BUTTON);
  private Button driver_SELECT = new JoystickButton(driver, Constants.SELECT_BUTTON);
  private Button driver_RS_PUSH = new JoystickButton(driver, Constants.RS_PUSH);

  private Button operator_LeftShoulder = new JoystickButton(operator, Constants.LEFT_SHOULDER);

  private Button operator_LeftTrigger = new AxisButton(operator, 2);
  private Button operator_RightTrigger = new AxisButton(operator, 3);

  public OI() {
    driver_A.whileHeld(new MoveDown());
    driver_X.whileHeld(new MoveUp());
    driver_START.whenPressed(new ToggleArms());
    driver_SELECT.whenPressed(new ToggleVisionAssist());
    driver_RS_PUSH.whenPressed(new AssistedDriving());


    operator_LeftShoulder.whenPressed(new SendOut());
    operator_LeftShoulder.whenReleased(new ForceClose());

    operator_LeftTrigger.whenPressed(new RearClimb());
    operator_RightTrigger.whenPressed(new FrontClimb());

    this.populateDashboard();
  }

  private void populateDashboard() {

    SmartDashboard.putNumber("Elevator Position", QUASAR.elevator.getPosition());

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
}
