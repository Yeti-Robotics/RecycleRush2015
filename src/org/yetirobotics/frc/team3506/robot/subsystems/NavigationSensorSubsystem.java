package org.yetirobotics.frc.team3506.robot.subsystems;

import org.yetirobotics.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class NavigationSensorSubsystem extends Subsystem {

	Gyro gyro;
	Encoder leftEncoder;
	Encoder rightEncoder;
	AnalogInput sonar;

	public NavigationSensorSubsystem() {
		gyro = new Gyro(RobotMap.GYRO_PORT);
		leftEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENC[0], RobotMap.LEFT_DRIVE_ENC[1]);
		rightEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENC[0], RobotMap.RIGHT_DRIVE_ENC[1]);
		leftEncoder.setDistancePerPulse(RobotMap.DIST_PER_PULSE); //In feet
		sonar = new AnalogInput(RobotMap.SONAR_PORT);
	}

	public void initDefaultCommand() {
		// Nothing to do here
	}

	public Gyro getGyro() {
		return gyro;
	}

	public void resetGyro() {
		gyro.reset();
	}

	public Encoder getLeftEncoder() {
		return leftEncoder;
	}

	public void resetLeftEncoder(){
    	leftEncoder.reset();
    }
	
	public AnalogInput getSonar() {
		return sonar;
	}
	
	public void resetAll(){
		resetGyro();
		resetLeftEncoder();
	}

	public void log() {
		/*
		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
		SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
		SmartDashboard.putData("Gyro", gyro);
		SmartDashboard.putData("Encoder", leftFrontEncoder);
		SmartDashboard.putNumber("Sonar", sonar.getVoltage());
		*/
	}
}
