package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;

public class shooter {
    TalonFX flywheelTop;
    TalonFX flywheelBot;

    public shooter(){
        flywheelTop = new TalonFX(19);
        flywheelBot = new TalonFX(20);

        TalonFXConfiguration topConfig = new TalonFXConfiguration();
        topConfig.slot0.kP = .35;
        topConfig.slot0.kD = .045;
        topConfig.slot0.kF = .05;
        flywheelTop.configAllSettings(topConfig);
        TalonFXConfiguration botConfig = new TalonFXConfiguration();

        botConfig.slot0.kP =.35;    
        botConfig.slot0.kD = .045;
        botConfig.slot0.kF =.05;
        flywheelBot.configAllSettings(botConfig);

        flywheelBot.setNeutralMode(NeutralMode.Coast);
        flywheelTop.setNeutralMode(NeutralMode.Coast);

        flywheelBot.overrideLimitSwitchesEnable(false);
        flywheelTop.overrideLimitSwitchesEnable(false);

        flywheelBot.enableVoltageCompensation(true);
        flywheelTop.enableVoltageCompensation(true);

        flywheelTop.configVoltageCompSaturation(10);
        flywheelBot.configVoltageCompSaturation(10);

        flywheelTop.configVelocityMeasurementWindow(1, 1);
        flywheelBot.configVelocityMeasurementWindow(1, 1);
    }

    public void run(){
        flywheelTop.set(ControlMode.Velocity, 2000 * 2048/600);
        flywheelBot.set(ControlMode.Velocity, 2000 * 2048/600);
    }

    public void stop(){
        flywheelTop.set(ControlMode.PercentOutput, 0);
        flywheelBot.set(ControlMode.PercentOutput, 0);
    }
}
