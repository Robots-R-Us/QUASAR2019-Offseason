/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.QUASAR;

public class ZeroPosition extends Command {
  
  public ZeroPosition() {
    requires(QUASAR.elevator);
  }

  @Override
  protected void execute() {
    QUASAR.elevator.zero();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    QUASAR.elevator.stop();
  }

  @Override
  protected void interrupted() {
    QUASAR.elevator.stop();
  }
}
