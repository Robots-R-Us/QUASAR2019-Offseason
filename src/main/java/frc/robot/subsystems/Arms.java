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

public class Arms extends Subsystem {

  public boolean isClosed;
  private Solenoid armsSolenoid;

  //#region Subsystem Constructor
  public Arms() {
    armsSolenoid = new Solenoid(Constants.ARMS_SOLENOID);
  }
  //#endregion

  //#region Subsystem Functions
  public void openArms() {
    armsSolenoid.set(true);
    isClosed = false;
  }

  public void closeArms() {
    armsSolenoid.set(false);
    isClosed = true;
  }
  //#endregion

  @Override
  public void initDefaultCommand() {

  }
}
