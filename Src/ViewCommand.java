import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JFrame;

public class ViewCommand extends JFrame {

    public ViewCommand(){
        JFrame jFrame=new JFrame();
        jFrame.setTitle("Command");
        jFrame.setSize(new Dimension(700, 700));
        jFrame.setVisible(true);
        Dimension windowSize=jFrame.getSize();
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint=ge.getCenterPoint();
        int dx=centerPoint.x-windowSize.width/ 2 ;
        int dy=centerPoint.y-windowSize.height/ 2-350;
        jFrame.setLocation(dx,dy);
    }

}
