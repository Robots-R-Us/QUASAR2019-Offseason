/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.QUASAR;

public class RearClimb extends Command {

  public RearClimb() {
    requires(QUASAR.rearClimber);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    QUASAR.rearClimber.extend();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(QUASAR.oi.getOperatorAxis(2) > 0.15) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  protected void end() {
    QUASAR.rearClimber.retract();
  }
}
