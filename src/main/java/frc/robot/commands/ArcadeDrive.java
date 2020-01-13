/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Core.
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArcadeDrive extends Command {
  
  // Variable declarations for processing.
  boolean boosted;
  double throttle, balance;
  double powerLeft, powerRight;

  public ArcadeDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Deadbanding function, prevents accidental movement.
  private double deadband(double value, double limit) {
    if (Math.abs(value) < limit) return 0;
    else return value;
  }

  // Clipping function, prevents overpowering.
  private double clip(double value) {
    if (boosted) { // Boosted, clips at 1.00
      if (value > 1) return 1;
      else if (value < -1) return -1;
      else return value;
    } else { // Not boosted, clips at 0.75
      if (value > 0.75) return 0.75;
      else if (value < -0.75) return -0.75;
      else return value;
    }
  }

  // Scaling function, changes "jumpiness factor".
  private double scale(double value, double mult) {
    return value*mult;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    // Obtain target values from controller.
    throttle = scale(deadband(-Robot.oi.driverJoystick.getRawAxis(1), 0.125), 1);
    balance = scale(deadband(Robot.oi.driverJoystick.getRawAxis(4), 0.15), 0.5);
    boosted = Robot.oi.driverButtonRightBumper.get();

    // Compute power values.
    powerLeft = clip(throttle + balance);
    powerRight = clip(throttle - balance);

    // Set drivetrain power.
    Robot.drivetrain.setPower(powerLeft, powerRight);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

}
