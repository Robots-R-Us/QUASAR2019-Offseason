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

public class Arms extends Subsystem {

  public boolean isClosed;
  private Solenoid armsSolenoid;

  public Arms() {
    armsSolenoid = new Solenoid(Constants.ARMS_SOLENOID);
  }

  public void openArms() {
    armsSolenoid.set(true);
    isClosed = false;
  }

  public void closeArms() {
    armsSolenoid.set(false);
    isClosed = true;
  }

  @Override
  public void initDefaultCommand() {

  }
}
