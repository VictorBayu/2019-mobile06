package id.ac.polinema.idealbodyweight.Util;

public class BodyMassIndex {
    private float mass;
    private float height;
    private float bmi;

    public BodyMassIndex(float mass, float height) {
        this.mass = mass;
        this.height = height;
        this.index();
    }

    private void index() {
        this.bmi = this.mass / (this.height * this.height);
    }
    public String range(){
        String rangeBMI="";
        if(this.bmi < 18.50){
            rangeBMI = "underweight";
        }else if(this.bmi >= 18.50 && this.bmi <=24.99){
            rangeBMI = "healthy weight";
        }else if(this.bmi > 25.00){
            rangeBMI = "overweight";
        }else if(this.bmi >= 30.00 && this.bmi <= 29.99){
            rangeBMI = "obesity level 1";
        }else if (this.bmi >= 35.00 && this.bmi <= 39.99){
            rangeBMI = "obesity level 2";
        }else if (this.bmi > 40.00){
            rangeBMI = "obesity level 3";
        }
        return  rangeBMI;
    }
}
