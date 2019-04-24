/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arms;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.QUASAR;

public class ToggleArms extends Command {

  private boolean command_ran = false;

  public ToggleArms() {
    requires(QUASAR.arms);
  }

  @Override
  protected void execute() {
    if(QUASAR.arms.isClosed) {
      QUASAR.arms.openArms();
      command_ran = true;
    } else {
      QUASAR.arms.closeArms();
      command_ran = true;
    }
  }

  @Override
  protected boolean isFinished() {
    if(command_ran) return true;
    else return false;
  }
}
