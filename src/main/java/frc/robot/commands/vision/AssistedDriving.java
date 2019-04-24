/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.QUASAR;

public class AssistedDriving extends Command {
  public AssistedDriving() {
    requires(QUASAR.vision);
    requires(QUASAR.driveTrain);
  }

  @Override
  protected void initialize() {
    QUASAR.driveTrain.robotDrive(0, 0, 0); // stop before we run
  }

  @Override
  protected void execute() {
    QUASAR.vision.adjustSteering();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(QUASAR.oi.getDriverButton(Constants.RS_PUSH))
      return false;
    else return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    QUASAR.driveTrain.robotDrive(0, 0, 0); // stop before we run
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    QUASAR.driveTrain.robotDrive(0, 0, 0); // stop before we run
  }
}
