/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.QUASAR;

/*
 *   Vision Command
 *   Toggle Vision Assist
 * 
 *   Turns the camera LED on or off
 */
public class ToggleVisionAssist extends Command {

  private boolean command_ran = false;

  public ToggleVisionAssist() {
    requires(QUASAR.vision);
  }

  @Override
  protected void execute() {
    QUASAR.vision.toggleMode();
    command_ran = true;
  }

  @Override
  protected boolean isFinished() {
    return command_ran;
  }
}
