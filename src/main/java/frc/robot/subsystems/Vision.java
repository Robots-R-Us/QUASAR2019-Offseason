/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.QUASAR;
import util.Log;
import util.MessageType;

public class Vision extends Subsystem {

  private NetworkTable nt;
  private NetworkTableEntry tx, tv, thor;
  private NetworkTableEntry camMode, ledMode;

  public Vision() {
    nt = NetworkTableInstance.getDefault().getTable(Constants.CAMERA_NAME);
    this.updateNetworkTables();
  }

  public void updateNetworkTables() {
    tx = nt.getEntry("tx"); tv = nt.getEntry("tv"); thor = nt.getEntry("thor");
    camMode = nt.getEntry("camMode"); ledMode = nt.getEntry("ledMode");
  }

  public void adjustSteering() {

    double steering_adjust = 0;
    double velocity_adjust = 0;

    double txValue = tx.getDouble(0.0);
    double thorValue = thor.getDouble(0.0);

    if(getTarget()) {

      // we adjust our velocity based on the read of tHor value
      if(thorValue < 60 && thorValue > 0) {
        velocity_adjust = -0.88;
      } else if(thorValue < 120 && thorValue > 60) {
        velocity_adjust = -0.66;
      } else if(thorValue < 150 && thorValue > 120) {
        velocity_adjust = -0.55;
      } else if(thorValue > 150) {
        velocity_adjust = 0;
      } else { 
        velocity_adjust = 0;
      }

      // then do the same with our steering and the tx value
      if(txValue > 5) {
        steering_adjust = 0.66;
      } else if (txValue < -5) {
        steering_adjust = -0.66;
      } else if(txValue > -5 && txValue < -1) {
        steering_adjust = -0.35;
      } else if(txValue < 5 && txValue > 1) {
        steering_adjust = 0.35;
      } else if(txValue < 1 && txValue > 0.15) {
        steering_adjust = 0.3;
      } else if(txValue > -1 && txValue < -0.15) {
        steering_adjust = -0.3;
      } else if (txValue < 0.15 && txValue > -0.15) {
        steering_adjust = 0;
      } else {
        steering_adjust = 0;
      }
    }

    QUASAR.driveTrain.robotDrive(velocity_adjust, steering_adjust, Constants.ROBOT_DRIVE_MODIFIER);

  }

  public double getLEDMode() {
    return ledMode.getDouble(1);
  }

  public boolean getTarget() {
    double _tv = tv.getDouble(0);
    
    if(_tv == 0) return false;
    else return true;
  }

  public void toggleMode() {
    if(getLEDMode() == 0) {
      disable();
    } else {
      enable();
    }
  }

  public void enable() {
    try { camMode.setValue(0); ledMode.setValue(0); }
    catch(Exception ex) { Log.WriteLine(MessageType.ERROR, ex.toString()); }
  }

  public void disable() {
    try { camMode.setValue(1); ledMode.setValue(1); }
    catch(Exception ex) { Log.WriteLine(MessageType.ERROR, ex.toString()); }
  }

  @Override
  public void initDefaultCommand() {
    
  }
}
