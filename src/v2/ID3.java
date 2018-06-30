/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v2;

import javafx.util.Pair;

import java.math.BigDecimal;

/**
 *
 * @author azuron
 */
public class ID3 {
 
    // table des faits
    public Line[] totalFacts;
    public Tree tree;
    public Cell[] cellAvailable = {Cell.Empty, Cell.Player, Cell.Smell, Cell.Unknown, Cell.Wind};
    public String[] propertyAvailable = {"up", "right", "bottom", "left"};
    
    public ID3(Line[] totalFacts){
        this.totalFacts = totalFacts;
        CreateTree();
    }
    
    
    private void CreateTree(){
        
        float[] gains = new float[totalFacts[0].surroundings.length];
        float mainEntropy = CalculateEnthropy(totalFacts);
        for(int i = 0; i < totalFacts[0].surroundings.length;i++){
            gains[i] = CalculateGainforProperty(i, cellAvailable, totalFacts, mainEntropy);
        }

        int index = PickBestGain(gains);

        Property prop = new Property(propertyAvailable[index], index);
        for(var i = 0; i < cellAvailable.length; i++){
            prop.addAttribute(new Attribute(cellAvailable[i], prop));
        }
        tree = new Tree(prop);
    }

    private float CalculateGainforProperty(int index, Cell[] fields, Line[] facts, float mainEnthropie){
        float[] enthropy = new float[fields.length];
        float[] prevalence = new float[fields.length];
        for(int i = 0; i < fields.length; i++){
            Pair<Float, Float> pair =  CalculateEnthropyForField(index, fields[i], facts);
            enthropy[i] = pair.getKey();
            prevalence[i] =  pair.getValue();

        }
        float gain = ComputeGain(index, mainEnthropie, enthropy, prevalence, facts.length);
        return gain;
    }

    private float ComputeGain(int index, float mainEntropy, float[] entropy, float[] prevalence, float factsSize){
        float gain = mainEntropy;
        for(int i = 0; i < entropy.length; i++){
            gain -= ((prevalence[i]/factsSize)*entropy[i]);
        }

        return gain;
    }
    
    /*
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
   }*/


    private Pair<Float, Float> CalculateEnthropyForField(int index, Cell cell, Line[] facts){
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
        
        return new Pair<Float, Float>(-ratioDeath*log2(ratioDeath) - ratioSurvive*log2(ratioSurvive), probabilityCell);
    }
    



    /** Reusable */

    private float CalculateEnthropy(Line[] lines){
        float numberDeath = 0;
        float numberSurvive = 0;
        
        for(int i = 0; i < lines.length; i++){
            if(lines[i].death){
                numberDeath++;
            }else {
                numberSurvive++;
            }
        }
        
        float ratioSurvive = numberSurvive / facts.length;
        float ratioDeath = numberDeath / facts.length; 

        
        return -ratioSurvive*log2(ratioSurvive) - ratioDeath*log2(ratioDeath);
        
    }


    private float log2(float number) {
      /*  if (number == 0) {
                return number;
        }*/
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
