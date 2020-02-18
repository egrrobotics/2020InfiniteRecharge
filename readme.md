# 2020 Infinite Recharge
# New code is [here](https://github.com/egrrobotics/2020InfiniteRecharge-New)

Robot code and documentation for team 5980's FIRST Robotics season, dubbed "Infinite Recharge".

<br>

## Notes

Yes, this code is using the deprecated old-style command template, but may be rewritten and upgraded to match the new templates. As of now, the current templates don't make much sense yet, so we will continue using the deprecated template.

On the bright side, we will try to comment and document our code as best as we can to make sure that, in the event of a rewrite, we can re-implement the same functionality using the new template.

<br>

## Commands

This is a list of all [commands](src/main/java/frc/robot/commands) used, what they are for, and what they do. As a command is finalized it will be added to this list while other, unfinished commands may remain missing.

| Command Name | Usage/Purpose |
|---:|:---|
| [Autonomous](src/main/java/frc/robot/commands/Autonomous.java) | Dummy autonomous routine, does nothing for now. |
| [ArcadeDrive](src/main/java/frc/robot/commands/ArcadeDrive.java) | Controls drivetrain speed and direction with a tank-style controlset. |
| [IntakeDrive](src/main/java/frc/robot/commands/IntakeDrive.java) | Controls intake rotor and angle. |

<br>

## Subsystems

This is a list of all [subsystems](src/main/java/frc/robot/subsystems) used. Similarly to the commands list, unfinished commands may be missing from the list while more finalized commands will be added.

| Subsystem Name | Elements/Purpose |
|---:|:---|
| [Drivetrain](src/main/java/frc/robot/subsystems/Drivetrain.java) | Controls the robot's movement across the field. |
| [Intake](src/main/java/frc/robot/subsystems/Intake.java) | Power cell intake management. |

<br>

## Controller Mappings

These are the controller mappings defined in the [OI class](src/main/java/frc/robot/OI.java) for both driver and operator controllers.

| Driver Control | Action |
|---:|:---|
| LS Up/Down | Drive Forward/Back |
| RS Left/Right | Steer Left/Right |
| Right Bumper | Boost (Changes power clipping from 0.75 to 1.00) |

| Operator Control | Action |
|---:|:---|
| *n/a* | *Coming soon.* |
