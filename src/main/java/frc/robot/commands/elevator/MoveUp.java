/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.QUASAR;

public class MoveUp extends Command {

  public MoveUp() {
    requires(QUASAR.elevator);
  }

  @Override
  protected void execute() {
    QUASAR.elevator.up();
  }

  @Override
  protected boolean isFinished() {
    if(QUASAR.oi.getDriverButton(Constants.X_BUTTON)) {
      return false;
    } else { return true; }
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
