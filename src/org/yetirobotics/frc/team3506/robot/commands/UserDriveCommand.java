/**
 * 
 */
package org.yetirobotics.frc.team3506.robot.commands;

import org.yetirobotics.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author acampbell
 *
 */
public class UserDriveCommand extends Command {

	public UserDriveCommand() {
		requires(Robot.drive);
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#initialize()
	 */
	@Override
	protected void initialize() {

	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#execute()
	 */
	@Override
	protected void execute() {
		Robot.drive.userDrive();
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#end()
	 */
	@Override
	protected void end() {
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#interrupted()
	 */
	@Override
	protected void interrupted() {
		end();
	}

}
