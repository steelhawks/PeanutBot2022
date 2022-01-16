package frc.robot.Util;

import edu.wpi.first.wpilibj.shuffleboard.*;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class ColorSensor {

    ShuffleboardTab tab = Shuffleboard.getTab("colors");

    //color sensor testing
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();
    
    // private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    // private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    // private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    // private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    private final Color kBlueTarget = Color.kBlue;
    private final Color kGreenTarget = Color.kGreen;
    private final Color kRedTarget = Color.kRed;
    private final Color kYellowTarget = Color.kYellow;

    private Color detectedColor;
    private ColorMatchResult match;
    private String colorString;
    

    //constructor
    public ColorSensor(){}

    public void matchfixedcolors(){
            
        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kGreenTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
        m_colorMatcher.addColorMatch(kYellowTarget); 
        
    }

    public Color detectColor(){
        detectedColor = m_colorSensor.getColor();

        
        match = m_colorMatcher.matchClosestColor(detectedColor);
    
        if (match.color == kBlueTarget) {
          colorString = "Blue";
        } else if (match.color == kRedTarget) {
          colorString = "Red";
        } else if (match.color == kGreenTarget) {
          colorString = "Green";
        } else if (match.color == kYellowTarget) {
          colorString = "Yellow";
        } else {
          colorString = "Unknown";
        }

        return detectedColor;
    }
    
    public void colorShuffleBoard(Color color){

        detectedColor = color;

        Shuffleboard.getTab("colors").add("Red", detectedColor.red);
        Shuffleboard.getTab("colors").add("Green", detectedColor.green);
        Shuffleboard.getTab("colors").add("Blue", detectedColor.blue);
        Shuffleboard.getTab("colors").add("Confidence", match.confidence);
        Shuffleboard.getTab("colors").add("Detected Color", colorString);
    }
}
