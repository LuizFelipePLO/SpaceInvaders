package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

/**
 * Represents a simple ball that crosses the screen over and over again
 * @author Bernardo Copstein and Rafael Copstein
 */
public class AlienNormal extends BasicElement{
    public AlienNormal(int px,int py){
    	super(px,py);
    }
    
    @Override
    public void start(){
        setDirV(1);
    }
    

    
    
        
    @Override
    public void Update(){
        if (jaColidiu()){
        	aumentaScore();
        	Game.getInstance().eliminate(this);
            
        }else{
            setPosY(getY() + getDirV() * getSpeed());
            // Se chegou no lado direito da tela ...
            if (getY() >= getLMaxV()){
                // Reposiciona no lado esquerdo e ...
                setPosY(getLMinV()-100);
                setPosX(ranAli.nextInt(800-50) + 32);
                setSpeed((getScore()/5)+2);
            }
        }
    }    
    
    public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#0000FF"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    }    
}
