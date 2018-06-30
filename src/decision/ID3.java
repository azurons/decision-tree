/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import java.math.BigDecimal;

/**
 *
 * @author azuron
 */
/*public class ID3 {
 
    // table des faits
    public Line[] facts;
    public float Enthropy;
    public Node three;
    
    
    public ID3(Line[] facts){
        this.facts = facts;
        CalculateTotalEnthropy();
        float[] gains = CalculateGains(facts);
        int bestGain = PickBestGain(gains);
        
        Node node = new Node(bestGain, true);

       
    }
    
    
    private void CalculateTotalEnthropy(){
        float numberDeath = 0;
        float numberSurvive = 0;
        
        for(int i = 0; i < facts.length; i++){
            if(facts[i].death){
                numberDeath++;
            }else {
                numberSurvive++;
            }
        }
        
        float ratioSurvive = numberSurvive / facts.length;
        float ratioDeath = numberDeath / facts.length; 

        Enthropy = -ratioSurvive*log2(ratioSurvive) - ratioDeath*log2(ratioDeath);
        
    }
    
    
    
    private float[] CalculateGains(Line[] lines){
        
        float[] gains = new float[4];
        
        
        for(int i = 0; i < lines[i].surroundings.length; i++){
            float enthropyEmpty = CalculateEnthropyForField(i, Cell.Empty);
            float enthropyPlayer =  CalculateEnthropyForField(i, Cell.Player);
            float enthropySmell = CalculateEnthropyForField(i, Cell.Smell);
            float enthropyUnknown = CalculateEnthropyForField(i, Cell.Unknown);
            float enthropyWind = CalculateEnthropyForField(i, Cell.Wind);
        
            float probabilityEmpty = 0;
            float probabilityPlayer = 0;
            float probabilitySmell = 0;
            float probabilityUnknown = 0;
            float probabilityWind = 0;
        
            for(int j = 0 ; j < facts.length; j++){
                switch(facts[j].surroundings[i]){
                    case Empty:
                        probabilityEmpty++;
                    break;
                    case Player:
                        probabilityPlayer++;
                    break;
                    case Smell:
                        probabilitySmell++;
                    break;
                    case Unknown:
                        probabilityUnknown++;
                    break;
                    case Wind:
                        probabilityWind++;
                }
            }
            gains[i] = Enthropy - ((probabilityEmpty/facts.length)*enthropyEmpty) - ((probabilityPlayer/facts.length)*enthropyPlayer) - ((probabilitySmell/facts.length)*enthropySmell) - ((probabilityUnknown/facts.length)*enthropyUnknown) - ((probabilityWind/facts.length)*enthropyWind);                

        }
        
        return gains;
   }
    
    private Float CalculateEnthropyForField(int index, Cell cell){
        float probabilityCell = 0;
        float numberDeath = 0;
        float numberSurvive = 0;
        
        for(int i = 0; i < facts.length; i++){
            if(facts[i].surroundings[index] == cell){
                probabilityCell++;
                if(facts[i].death){
                    numberDeath++;
                }else{
                    numberSurvive++;
                }
            }
        }
        
        float ratioSurvive = numberSurvive / probabilityCell;
        float ratioDeath = numberDeath / probabilityCell; 
        
        return -ratioDeath*log2(ratioDeath) - ratioSurvive*log2(ratioSurvive);
    }
    
    private float log2(float number) {
        if (number == 0) {
                return number;
        }
        return (float) Math.log(number) / (float) Math.log(2);
    }
    
    private int PickBestGain(float[] gains){
        int index = 0;
        float max = gains[0];
        
        for(int i = 0; i < gains.length; i++){
            if(gains[i] > max){
                index = i;
            }
        }
        return index;
    }
    
}
*/