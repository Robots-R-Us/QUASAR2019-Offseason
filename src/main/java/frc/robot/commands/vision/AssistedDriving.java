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

/*
 *   Vision / Drive Train Command
 *   Assisted Driving
 * 
 *   Approaches detected target and stops
 */
public class AssistedDriving extends Command {
  
  public AssistedDriving() {
    requires(QUASAR.vision);
    requires(QUASAR.driveTrain);
  }

  @Override
  protected void initialize() {
    QUASAR.driveTrain.stop();
  }

  @Override
  protected void execute() {
    QUASAR.vision.adjustSteering();
  }

  @Override
  protected boolean isFinished() {
    if(QUASAR.oi.getDriverButton(Constants.RS_PUSH))
      return false;
    else return true;
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
