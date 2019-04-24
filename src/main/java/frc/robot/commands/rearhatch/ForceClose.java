/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.rearhatch;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.QUASAR;

public class ForceClose extends Command {
  public ForceClose() {
    requires(QUASAR.rearHatch);
  }

  @Override
  protected void execute() {
    QUASAR.rearHatch.kickIn();
    QUASAR.rearHatch.hatchSecure();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
