/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Core.
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

// External.
import frc.robot.commands.ArcadeDrive;

/**
 * Drivetrain subsystem. Controls the robot's movement across the field.
 */

public class Drivetrain extends Subsystem {

  // Victor definition and mode setup.
  VictorSPX leftA, leftB;
  VictorSPX rightA, rightB;

  // Subsystem initialization.
  public Drivetrain() {
    leftA = new VictorSPX(RobotMap.driveLeftA);
    leftB = new VictorSPX(RobotMap.driveLeftB);
    rightA = new VictorSPX(RobotMap.driveRightA);
    rightB = new VictorSPX(RobotMap.driveRightB);
    rightA.setInverted(true); // Right side is inverted due to the
    rightB.setInverted(true); // orientation of the motors.
  }

  // Deadbanding function, prevents motor burnout.
  private double deadband(double power) {
    if (Math.abs(power) < 0.1) return 0;
    else return power;
  }

  // Left-specific power management (internal use).
  private void setLeftPower(double power) {
    power = deadband(power);
    leftA.set(ControlMode.PercentOutput, power);
    leftB.set(ControlMode.PercentOutput, power);
  }

  // Right-specific power management (internal use).
  private void setRightPower(double power) {
    power = deadband(power);
    rightA.set(ControlMode.PercentOutput, power);
    rightB.set(ControlMode.PercentOutput, power);
  }

  // General power management, equal balance.
  public void setPower(double power) {
    setLeftPower(power); setRightPower(power);
  }

  // General power management, custom balance.
  public void setPower(double powerLeft, double powerRight) {
    setLeftPower(powerLeft); setRightPower(powerRight);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    this.setDefaultCommand(new ArcadeDrive());
  }
  
}
