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

public class RearHatch extends Subsystem {

  public boolean isKicked = false, isSecured = false;
  private Solenoid kickerSolenoid, flowerSolenoid;

  //#region Subsystem Constructor
  public RearHatch() {
    kickerSolenoid = new Solenoid(Constants.BACKHATCH_KICKER);
    flowerSolenoid = new Solenoid(Constants.BACKHATCH_FLOWER);
  }
  //#endregion

  //#region Subsystem Functions
  public void kickOut() {
    kickerSolenoid.set(true);
    isKicked = true;
  }

  public void kickIn() {
    kickerSolenoid.set(false);
    isKicked = false;
  }

  public void hatchSecure() {
    flowerSolenoid.set(false);
    isSecured = true;
  }

  public void hatchRelease() {
    flowerSolenoid.set(true);
    isSecured = false;
  }
  //#endregion
  
  @Override
  public void initDefaultCommand() {
  }
}
