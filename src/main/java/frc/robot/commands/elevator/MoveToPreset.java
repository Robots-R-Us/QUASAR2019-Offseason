/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.QUASAR;
import util.Utilities;

/*
 *   Elevator Command
 *   Move To Preset
 * 
 *   Moves the elevator to a preset
 *   position tracked via encoder
 */
public class MoveToPreset extends Command {
  
  public MoveToPreset() {
    requires(QUASAR.elevator);
  }

  @Override
  protected void execute() {
    QUASAR.elevator.moveToPreset(QUASAR.current_preset);
  }

  @Override
  protected boolean isFinished() {
    if(Utilities.within(QUASAR.elevator.getPosition(),QUASAR.current_preset-500,QUASAR.current_preset+500))
      return true;
    else return false;
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
