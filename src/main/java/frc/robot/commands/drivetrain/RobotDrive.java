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

/*
 *   Drive Train Command
 *   Robot Drive
 * 
 *   There are three modes:
 *   Default: modified speed drive
 *   LS: full speed drive
 *   Select: modified speed reverse drive
 */
public class RobotDrive extends Command {

  public RobotDrive() {
    requires(QUASAR.driveTrain);
  }

  @Override
  protected void execute() {
    double speed = QUASAR.oi.getDriverAxis(Constants.LEFT_Y);
    double rotation = QUASAR.oi.getDriverAxis(Constants.LEFT_X);

    if(QUASAR.oi.getDriverButton(Constants.LEFT_SHOULDER)) {
      QUASAR.driveTrain.robotDrive(speed, rotation, 1.0);
    } else if(QUASAR.oi.getDriverButton(Constants.SELECT_BUTTON)) {
      QUASAR.driveTrain.robotDrive(-speed, rotation, Constants.ROBOT_DRIVE_MODIFIER);
    } else {
      QUASAR.driveTrain.robotDrive(speed, rotation, Constants.ROBOT_DRIVE_MODIFIER);
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    QUASAR.driveTrain.stop();
  }
}
