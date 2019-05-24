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
import util.*;

/*
 *   Elevator Command
 *   Move Down
 * 
 *   If the limit switch is hit, the elevator
 *   encoder position is set to zero.
 */
public class MoveDown extends Command {

  private boolean command_ran = false;

  public MoveDown() {
    requires(QUASAR.elevator);
  }

  @Override
  protected void execute() {
    if(QUASAR.sensors.getElevatorSwitch()) {
      Log.WriteLine(MessageType.INFO, "I've hit the bottom of the elevator! Zeroing the encoder...");
      QUASAR.elevator.zero();
      command_ran = true;
    } else {
      QUASAR.elevator.down();
    }
  }

  @Override
  protected boolean isFinished() {
    if(command_ran && !QUASAR.oi.getDriverButton(Constants.A_BUTTON)) {
      return true;
    } else {
      return false;
    }
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
