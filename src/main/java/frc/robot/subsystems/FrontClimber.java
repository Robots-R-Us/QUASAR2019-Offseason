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

public class FrontClimber extends Subsystem {
  
  private Solenoid frontClimber;

  //#region Subsystem Constructor
  public FrontClimber() {
    frontClimber = new Solenoid(Constants.CLIMBER_FRONT);
  }
  //#endregion

  //#region Subsystem Functions
  public boolean get() {
    return frontClimber.get();
  }

  public void retract() {
    frontClimber.set(false);
  }

  public void extend() {
    frontClimber.set(true);
  }
  //#endregion

  @Override
  public void initDefaultCommand() {
  }
}
