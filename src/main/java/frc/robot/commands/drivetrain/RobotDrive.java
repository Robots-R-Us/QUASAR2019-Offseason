/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.QUASAR;

public class RobotDrive extends Command {

  public RobotDrive() {
    requires(QUASAR.driveTrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speed = QUASAR.oi.getDriverAxis(Constants.LEFT_Y);
    double rotation = QUASAR.oi.getDriverAxis(Constants.LEFT_X);

    if(QUASAR.oi.getDriverButton(Constants.LEFT_SHOULDER)) {
      QUASAR.driveTrain.robotDrive(speed, rotation, 1.0); // full speed
    } else if(QUASAR.oi.getDriverButton(Constants.SELECT_BUTTON)) {
      QUASAR.driveTrain.robotDrive(-speed, rotation, 0.66); // reverse drive at 2/3 speed
    } else {
      QUASAR.driveTrain.robotDrive(speed, rotation, 0.66); // drive at 2/3 speed
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    QUASAR.driveTrain.stop();
  }
}
