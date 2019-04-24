/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.QUASAR;

public class SensorDrive extends Command {

  public SensorDrive() {
    requires(QUASAR.sensors);
    requires(QUASAR.driveTrain);
  }

  @Override
  protected void initialize() {
    QUASAR.driveTrain.stop();
  }

  @Override
  protected void execute() {
    if(QUASAR.sensors.getFloorSensorFront() || QUASAR.sensors.getFloorSensorRear()) {
      QUASAR.driveTrain.robotDrive(0.33, 0, 1);
    }
  }

  @Override
  protected boolean isFinished() {
    if(QUASAR.sensors.getFloorSensorFront() || QUASAR.sensors.getFloorSensorRear()) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  protected void end() {
    QUASAR.driveTrain.stop();
  }

  @Override
  protected void interrupted() {
    QUASAR.driveTrain.stop();
  }
}
