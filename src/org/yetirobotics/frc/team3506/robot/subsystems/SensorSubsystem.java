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
public class SensorSubsystem extends Subsystem {

	Gyro gyro;
	Encoder leftFrontEncoder;
	AnalogInput sonar;

	public SensorSubsystem() {
		gyro = new Gyro(RobotMap.GYRO_PORT);
		leftFrontEncoder = new Encoder(RobotMap.LEFT_FRONT_ENC1, RobotMap.LEFT_FRONT_ENC2);
		leftFrontEncoder.setDistancePerPulse(RobotMap.DIST_PER_PULSE); //In feet
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

	public Encoder getLeftFrontEncoder() {
		return leftFrontEncoder;
	}

	public void resetLeftFrontEncoder(){
    	leftFrontEncoder.reset();
    }
	
	public AnalogInput getSonar() {
		return sonar;
	}
	
	public void resetAll(){
		resetGyro();
		resetLeftFrontEncoder();
	}

	public void log() {
		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
		SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
		SmartDashboard.putData("Gyro", gyro);
		SmartDashboard.putData("Encoder", leftFrontEncoder);
		SmartDashboard.putNumber("Sonar", sonar.getVoltage());
	}
}
