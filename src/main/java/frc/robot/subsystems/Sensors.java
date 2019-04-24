/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//#region Imports
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
//#endregion

public class Sensors extends Subsystem {
  private DigitalInput elevator_limitSwitch, hatch_limitSwitch;
  private DigitalInput floorSensorF, floorSensorR;

  //#region Subsystem Constructor
  public Sensors() {
    elevator_limitSwitch = new DigitalInput(Constants.ELEVATOR_LIMIT_SWITCH);
    hatch_limitSwitch = new DigitalInput(Constants.HATCH_LIMIT_SWITCH);
    floorSensorF = new DigitalInput(Constants.FLOOR_SENSOR_F);
    floorSensorR = new DigitalInput(Constants.FLOOR_SENSOR_R);
  }
  //#endregion

  //#region Subsystem Functions
  public boolean getElevatorSwitch() {
    return elevator_limitSwitch.get();
  }

  public boolean getHatchSwitch() {
    return hatch_limitSwitch.get();
  }

  public boolean getFloorSensorFront() {
    return floorSensorF.get();
  }

  public boolean getFloorSensorRear() {
    return floorSensorR.get();
  }
  //#endregion

  @Override
  public void initDefaultCommand() {
  }
}
