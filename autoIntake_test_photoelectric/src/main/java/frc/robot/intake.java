package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class intake {
    DoubleSolenoid intakeSolenoid;
    CANSparkMax indexer;
    WPI_TalonSRX intake;
    //private static intake instance = new intake();

   public intake(){
    intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
    indexer = new CANSparkMax(21, MotorType.kBrushless);
    intake = new WPI_TalonSRX(32);

    intake.setNeutralMode(NeutralMode.Brake);
    indexer.setIdleMode(IdleMode.kBrake);
   } 

   /*
   public static intake getInstance(){
    return instance;
   }
   */

   public void autoIndex(double speed){
  
    /*if(intakeSensor.getValue() > 1000 || !beamBreak.get())
    indexer.set(0);     
    else    
    indexer.set(speed);*/
    }

    public void toggleIntake(){
        if(intakeSolenoid.get() == Value.kForward)
        intakeSolenoid.set(Value.kReverse);
        else if(intakeSolenoid.get() == Value.kReverse)
        intakeSolenoid.set(Value.kForward);
    }

    public void stopIndexer(){
        indexer.set(0);
    }

    public void setIndexer(){
        indexer.set(.85);
    }

    public void reverseIndexer(){
        indexer.set(-.85);
    }

    public void setIntake(){
        intake.set(ControlMode.PercentOutput, 0.85);
    }

    public void stopIntake(){
        intake.set(ControlMode.PercentOutput, 0);
    }
}
