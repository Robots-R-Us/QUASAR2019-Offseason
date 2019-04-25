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

import util.Log;
import util.MessageType;

/*
 *   Elevator Command
 *   Move Up
 * 
 *   If the driver tries to move higher than
 *   our upper limit, the elevator stops
 */
public class MoveUp extends Command {

  private boolean command_ran = false;

  public MoveUp() {
    requires(QUASAR.elevator);
  }

  @Override
  protected void execute() {
    if(QUASAR.elevator.getPosition() >= Constants.PRESET_BALL_HIGH) {
      Log.WriteLine(MessageType.INFO, "I can't reach any higher, boss!");
      command_ran = true;
    } else {
      QUASAR.elevator.up();
    }
  }

  @Override
  protected boolean isFinished() {
    if(QUASAR.oi.getDriverButton(Constants.X_BUTTON)) return false;
    else if(command_ran) return true;
    else return true;
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
