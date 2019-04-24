/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class RearHatch extends Subsystem {

  public boolean isKicked = false, isSecured = false;
  private Solenoid kickerSolenoid, flowerSolenoid;

  public RearHatch() {
    kickerSolenoid = new Solenoid(Constants.BACKHATCH_KICKER);
    flowerSolenoid = new Solenoid(Constants.BACKHATCH_FLOWER);
  }

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
  
  @Override
  public void initDefaultCommand() {

  }
}
