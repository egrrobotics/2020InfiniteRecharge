/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeDrive;

/**
 * Add your docs here.
 */
public class Intake extends PIDSubsystem {

  TalonSRX lift;

  /**
   * Add your docs here.
   */
  public Intake() {
    // Intert a subsystem name and PID values here
    super("Intake", 1, 2, 3);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    lift = new TalonSRX(RobotMap.intakeLift);
    setSetpoint(getLiftPos()); enable();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new IntakeDrive());
  }

  public double getLiftPos() {
    return returnPIDInput();
  }

  public void setLiftPos(double pos) {
    setSetpoint(pos);
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return lift.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    if (Math.abs(output) < 0.1) { output = 0; }
    lift.set(ControlMode.PercentOutput, output);
  }
}
