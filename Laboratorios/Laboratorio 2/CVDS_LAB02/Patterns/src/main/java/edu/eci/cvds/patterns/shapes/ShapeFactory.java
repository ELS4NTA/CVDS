package edu.eci.cvds.patterns.shapes;
import edu.eci.cvds.patterns.shapes.concrete.*;

public class ShapeFactory {

    public static Shape create (RegularShapeType type) {
        Shape s = null;
        switch (type){
            case Triangle:{
                s = new Triangle();
                break;
            }
            case Pentagon:{
                s = new Pentagon();
                break;
            }
            case Quadrilateral:{
                s = new Quadrilateral();
                break;
            }
            case Hexagon:{
                s = new Hexagon();
                break;
            }
        }
        return s;
    }    
}
