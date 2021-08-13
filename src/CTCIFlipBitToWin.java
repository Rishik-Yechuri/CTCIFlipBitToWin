public class CTCIFlipBitToWin {
    public static void main(String[] args) {
        try{
            CTCIFlipBitToWin obj = new CTCIFlipBitToWin();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        System.out.println("Input: 1775\nOutput:" + findLongestSequenceOfOnes(1775));
    }
    public int findLongestSequenceOfOnes(int number){
        String numInBinary = Integer.toString(number,2);
        char[] holdCharacters = numInBinary.toCharArray();
        int[] largestSequenceFromLeft = new int[numInBinary.length()];
        int[] largestSequenceFromRight = new int[numInBinary.length()];
        int currentLengthOfSequence = 0;
        int sequenceLengthRecord = 0;
        boolean zeroFound = false;
        for(int x=0;x<numInBinary.length();x++){
            if((int)holdCharacters[x] == 49){
                currentLengthOfSequence++;
            }else{
                currentLengthOfSequence = 0;
            }
            largestSequenceFromLeft[x] = currentLengthOfSequence;
        }
        currentLengthOfSequence = 0;
        for(int x=numInBinary.length()-1;x>=0;x--){
            if((int)holdCharacters[x] == 49){
                currentLengthOfSequence++;
            }else{
                currentLengthOfSequence = 0;
            }
            largestSequenceFromRight[x] = currentLengthOfSequence;
        }
        for(int x=0;x<numInBinary.length();x++){
            if((int)holdCharacters[x] == 48){
                zeroFound = true;
                int longestOnLeft = 0;
                int longestOnRight = 0;
                if(x!=0){
                    longestOnLeft = Math.max(largestSequenceFromLeft[x-1],largestSequenceFromRight[x-1]);
                }
                if(x+1<numInBinary.length()){
                    longestOnRight = Math.max(largestSequenceFromLeft[x+1],largestSequenceFromRight[x+1]);
                }
                int currentSize = longestOnLeft+longestOnRight+1;
                if(currentSize > sequenceLengthRecord){
                    sequenceLengthRecord = currentSize;
                }
            }
        }
        if(!zeroFound){
            return numInBinary.length();
        }
        return sequenceLengthRecord;
    }
}