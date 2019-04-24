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

public class MoveDown extends Command {

  public MoveDown() {
    requires(QUASAR.elevator);
  }

  @Override
  protected void execute() {
    if(QUASAR.sensors.getElevatorSwitch()) {

      Log.WriteLine(MessageType.INFO, "Elevator switched! Position set to zero.");

      QUASAR.elevator.stop();
      QUASAR.elevator.zero();
    } else {
      QUASAR.elevator.down();
    }
  }

  @Override
  protected boolean isFinished() {
    if(QUASAR.oi.getDriverButton(Constants.A_BUTTON)) {
      return false;
    } else { return true; }
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
