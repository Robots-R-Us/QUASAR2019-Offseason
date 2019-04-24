/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.QUASAR;

/*
 *   Climber Command
 *   Front Climb
 * 
 *   Extends when called, retracts afterwards
 */
public class FrontClimb extends Command {

  public FrontClimb() {
    requires(QUASAR.frontClimber);
  }

  @Override
  protected void execute() {
    QUASAR.frontClimber.extend();
  }

  @Override
  protected boolean isFinished() {
    if(QUASAR.oi.getOperatorAxis(3) > Constants.AXIS_THRESHOLD) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  protected void end() {
    QUASAR.frontClimber.retract();
  }
}
