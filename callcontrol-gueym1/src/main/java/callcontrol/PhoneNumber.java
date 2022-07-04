package callcontrol;
/**
 * @author Mohamed Gueye
 *
 */
public final class PhoneNumber {
    private  String countryCode;
    private  String areaCode;
    private  String subscriberNum;


    public PhoneNumber(String countryCode, String areaCode, String subscriberNum) {

        this.countryCode = countryCode.replaceAll("^[0]{1,4}", "+");
        if(countryCode.charAt(0) !='0' && countryCode.charAt(0) != '+'){
            this.countryCode = '+'+countryCode;
        }
        this.areaCode = areaCode.replaceAll("^0","");
        String subSub = subscriberNum;
        if(subscriberNum.charAt(3)!=' '){
            subSub = subscriberNum.substring(0,3)+" "+subscriberNum.substring(3,subscriberNum.length());
        }
        this.subscriberNum = subSub;
    }

    @Override
    public String toString() {
        return countryCode + ' ' +areaCode +'/'+ subscriberNum;
    }
}
