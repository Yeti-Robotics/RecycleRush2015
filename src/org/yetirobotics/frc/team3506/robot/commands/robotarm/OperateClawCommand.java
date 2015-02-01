package org.yetirobotics.frc.team3506.robot.commands.robotarm;

import org.yetirobotics.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateClawCommand extends Command {
	public static boolean isOpen = false;

    public OperateClawCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotarm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isOpen = !isOpen;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isOpen)
    		Robot.robotarm.clawClose();
    	else
    		Robot.robotarm.clawOpen();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}