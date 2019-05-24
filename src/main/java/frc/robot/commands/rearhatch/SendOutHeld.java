/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.rearhatch;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.QUASAR;

/*
 *   Rear Hatch Command
 *   Send Out
 * 
 *   Automatically secures hatch panel
 *   if one is detected being held
 */
public class SendOutHeld extends Command {

  public SendOutHeld() {
    requires(QUASAR.rearHatch);
  }

  @Override
  protected void execute() {
    QUASAR.rearHatch.kickOut();
    Timer.delay(0.2);
    QUASAR.rearHatch.hatchRelease();
  }

  @Override
  protected boolean isFinished() {
    if(!QUASAR.oi.getOperatorButton(Constants.RIGHT_SHOULDER)) return true;
    else return false;
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
