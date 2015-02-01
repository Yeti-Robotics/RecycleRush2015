package org.yetirobotics.frc.team3506.robot.subsystems;

import org.yetirobotics.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CompressorSubsystem extends Subsystem {
	Compressor compressor;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public CompressorSubsystem() {
		compressor = new Compressor(RobotMap.PCM_ID_NUMBER);
	}

	public void turnOffCompressor() {
		compressor.stop();
	}
	
	public void turnOnCompressor() {
		compressor.start();
	}
}
