/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.rearhatch;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.QUASAR;

/*
 *   Rear Hatch Command
 *   Send Out
 * 
 *   Automatically secures hatch panel
 *   if one is detected being held
 */
public class SendOut extends Command {

  public SendOut() {
    requires(QUASAR.rearHatch);
  }

  @Override
  protected void execute() {
    QUASAR.rearHatch.kickOut();
    QUASAR.rearHatch.hatchRelease();
  }

  @Override
  protected boolean isFinished() {
    if(!QUASAR.sensors.getHatchSwitch()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected void end() {
    secureHatchPanel();
  }

  @Override
  protected void interrupted() {
    secureHatchPanel();
  }

  private void secureHatchPanel() {
    QUASAR.rearHatch.kickIn();
    QUASAR.rearHatch.hatchSecure();
  }
}
