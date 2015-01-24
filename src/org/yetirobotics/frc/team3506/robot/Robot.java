
package org.yetirobotics.frc.team3506.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Relay spike;
	Joystick leftJoy;
	I2C i2c;
	byte[] toSend = new byte[1];
	
    // Runtime methods after this point
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	public void robotInit() {
    	// Instantiation of various peripherals
		leftJoy = new Joystick(1);
		spike = new Relay(3);
		i2c = new I2C(I2C.Port.kOnboard, 168);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	while(isEnabled() && isOperatorControl()){
    		spike.set(Value.kForward);
    		if(leftJoy.getRawButton(10)) {
    			toSend[0] = 76;
    		}
    		else {
    			toSend[0] = 72;
    		}
    		i2c.transaction(toSend, 1, null, 0);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {

    }
    
}
