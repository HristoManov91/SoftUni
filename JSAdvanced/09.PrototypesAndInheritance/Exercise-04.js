function solve(){
    class Balloon{
        constructor(color, gasWeight){
            this.color = color;
            this.gasWeight = Number(gasWeight);
        }
    }

    class PartyBalloon extends Balloon{
        constructor(color, gasWeight, ribbonColor, ribbonLength){
            super(color, gasWeight);
            this.ribbonColor = ribbonColor;
            this.ribbonLength = Number(ribbonLength);
            this._ribbon = {
                color: ribbonColor,
                length: Number(ribbonLength)
            }
        }
        get ribbon(){
            return this._ribbon;
        }
    }
    class BirthdayBalloon extends PartyBalloon{
        constructor(color, gasWeight, ribbonColor, ribbonLength, text){
            super(color, gasWeight, ribbonColor, ribbonLength);
            this.text = text;
        }
    }
    return {
        Balloon,
        PartyBalloon,
        BirthdayBalloon
    }
}