/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//#region Imports
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
//#endregion

public class RearClimber extends Subsystem {
  
  private Solenoid rearClimber;

  //#region Subsystem Constructor
  public RearClimber() {
    rearClimber = new Solenoid(Constants.CLIMBER_REAR);
  }
  //#endregion

  //#region Subsystem Functions
  public boolean get() {
    return rearClimber.get();
  }

  public void retract() {
    rearClimber.set(false);
  }

  public void extend() {
    rearClimber.set(true);
  }
  //#endregion

  @Override
  public void initDefaultCommand() {
  }
}
