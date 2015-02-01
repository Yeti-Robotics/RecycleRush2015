package org.yetirobotics.frc.team3506.robot.subsystems;

import org.yetirobotics.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
    
	DoubleSolenoid leftFrontLifter;
	DoubleSolenoid leftRearLifter;
	boolean isUp = false;
	
	public ElevatorSubsystem(){
		leftFrontLifter = new DoubleSolenoid(RobotMap.LEFT_FRONT_LIFTER[0], RobotMap.LEFT_FRONT_LIFTER[1]);
		leftRearLifter = new DoubleSolenoid(RobotMap.LEFT_REAR_LIFTER[0], RobotMap.LEFT_REAR_LIFTER[1]);
	}
	
	public void toggleOrientation(){
		if(isUp){
			leftFrontLifter.set(Value.kReverse);
			leftRearLifter.set(Value.kReverse);
		}else{
			leftFrontLifter.set(Value.kForward);
			leftRearLifter.set(Value.kForward);
		}
		this.isUp  = !isUp;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

